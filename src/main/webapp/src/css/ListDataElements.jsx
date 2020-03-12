import React, { Component } from 'react';
import ElementDataService from "../service/ElementDataService";
import {InputGroup} from 'react-bootstrap';
import {FormControl} from 'react-bootstrap';

class ListDataElements extends Component {

    constructor(props) {
        super(props)
        this.state = {
            elements: [],
            message: null
        }
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

    render() {
        return (
            <div className="container">
                <div className="container">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>Data Element</th>
                            <th>Value</th>
                        </tr>
                        </thead>
                        <tbody>{
                            this.state.elements.map(element =>
                                    <tr key={element.id}>
                                        <td>{element.id}</td>
                                        <td>{element.description}</td>
                                        <InputGroup className="mb-3">
                                            <FormControl
                                                placeholder="Value"
                                                aria-label="Value"
                                                aria-describedby="basic-addon1"
                                                defaultValue={element.value}
                                            />
                                        </InputGroup>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListDataElements