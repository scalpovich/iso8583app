import React, { Component } from 'react';
import {ButtonToolbar} from 'react-bootstrap';
import {Button} from 'react-bootstrap';
import '../css/Iso8583Home.css'
import ListDataElements from "../css/ListDataElements";

class Iso8583Home extends Component {
    render() {
        return(
            <>
                <h1 align={"center"}>ISO8583</h1>
                <ButtonToolbar>
                    <Button>Send</Button>
                    <Button>Reset</Button>
                </ButtonToolbar>
                <ListDataElements/>
            </>
        )
    }
}

export default Iso8583Home