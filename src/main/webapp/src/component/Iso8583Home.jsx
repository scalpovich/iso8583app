import React, { Component } from 'react';
import '../css/Iso8583Home.css'
import ISO8583GeneratorApp from "./ISO8583GeneratorApp";

class Iso8583Home extends Component {
    render() {
        return(
            <>
                <h1 align={"center"}>ISO8583</h1>
                <ISO8583GeneratorApp/>
            </>
        )
    }
}

export default Iso8583Home