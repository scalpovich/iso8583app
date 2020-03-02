package com.finastra.fpm.util.iso8583simulator.service;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

public interface ResponseGenerator {

    /**
     * Returns the ISO8583 format of the response
     *
     * @param isoMsg
     * @return
     * @throws IllegalArgumentException
     */
    String generate(ISOMsg isoMsg) throws IllegalArgumentException, ISOException;
}
