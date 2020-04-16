import React, { Component } from 'react';
import ElementDataService from "../service/ElementDataService";
import {InputGroup} from 'react-bootstrap';
import {Form,Col,Button} from 'react-bootstrap';
import {Formik} from 'formik';
import ISO8583Service from "../service/ISO8583Service";

class ISO8583GeneratorApp extends Component {

    constructor(props) {
        super(props)
        this.state = {
            elements: [],
            message: null,
        }
        //this.handleChange = this.handleChange.bind(this)
        this.refreshCourses = this.refreshCourses.bind(this)
    }

    componentDidMount() {
        this.refreshCourses();
    }

    refreshCourses() {
        ElementDataService.retrieveAllElements()
            .then(
                response => {
                    console.log(response);
                    this.setState({
                        elements: response.data
                    })
                }
            )
    }

/*    handleChange(event) {
        const elementID = event.target.id;
        const elementValue = event.target.value;
        const newValues = {elementID: elementValue}
    }*/

    cancelCourse = () => {
        document.getElementById("isoform").reset();
    }

    handleSubmit(props) {
/*        {
            this.state.elements.map(element=>{
                console.log(element.id)
                console.log(props.data.element.value)
            })
        }*/

        let iso8583 = {
            primaryaccountnumber: props.primaryaccountnumber,
            processingcode: props.processingcode,
            txamount: props.txamount,
            settlementamount: props.settlementamount,
            chbillingamount: props.chbillingamount,
            transmissiondatetime: props.transmissiondatetime,
            settlementconversionrate: props.settlementconversionrate,
            cardholderconversionrate: props.cardholderconversionrate,
            systraceauditnum: props.systraceauditnum,
            timelocaltx: props.timelocaltx,
            datelocaltx: props.datelocaltx,
            expirationdate: props.expirationdate,
            datesettlement: props.datesettlement,
            merchanttype: props.merchanttype,
            acqinstcountrycode: props.acqinstcountrycode,
            ptofserviceentrymodecode: props.ptofserviceentrymodecode,
            ptofserviceconditioncode: props.ptofserviceconditioncode,
            acqinstidcode: props.acqinstidcode,
            retrievalrefnum: props.retrievalrefnum,
            authidresp: props.authidresp,
            respcode: props.respcode,
            cardaccpterminalid: props.cardaccpterminalid,
            cardaccpidcode: props.cardaccpidcode,
            cardaccpnmloc: props.cardaccpnmloc,
            addtldataprivate: props.addtldataprivate,
            txcurcode: props.txcurcode,
            settelmentcurcode: props.settelmentcurcode,
            curcodecardholderbilling: props.curcodecardholderbilling,
            usrdefinedfld: props.usrdefinedfld,
            servccode: props.servccode,
            txrefnum: props.txrefnum,
            networkmgtrespcode: props.networkmgtrespcode,
            recvinstidcode: props.recvinstidcode,
            fromacctid: props.fromacctid,
            toacctid: props.toacctid,
            contenttransfers: props.contenttransfers,
            infochaccthbeneficiary: props.infochaccthbeneficiary,
            msgauthcode: props.msgauthcode
        }

        ISO8583Service.createISO8583(iso8583)
            .then(
            response =>{
                console.log(response.data);
            }
        )
       // console.log("primary acct num" + props.primaryaccountnumber)
    }

    render() {
        return (
            <>
                <Formik initialValues={{element:''}} onSubmit={values => {this.handleSubmit(values)}}>
                    {({
                        handleSubmit,
                        handleChange,
                        handleReset,
                          values
                      }) => (
                        <Form id={"isoform"} onSubmit={handleSubmit}>
                            <Button className={"sticky-top"} type="submit">Send</Button>
                            <Button className={"sticky-top"} onClick={this.cancelCourse}>Reset</Button>
                                {
                                    this.state.elements.map(element=>
                                        <Form.Row key={element.id}>
                                            <Form.Group as={Col} md="4">
                                                <Form.Label>{element.description}</Form.Label>
                                                <InputGroup>
                                                    <InputGroup.Prepend>
                                                        <InputGroup.Text id="inputGroupPrepend">{element.id}</InputGroup.Text>
                                                    </InputGroup.Prepend>
                                                    <Form.Control
                                                        id={element.id}
                                                        type="text"
                                                        name={element.value}
                                                        onChange={handleChange}
                                                        value={values.element.value}
                                                    />
                                                </InputGroup>
                                            </Form.Group>
                                        </Form.Row>
                                    )
                                }
                        </Form>
                    )}
                </Formik>
            </>
        )
    }
}

export default ISO8583GeneratorApp