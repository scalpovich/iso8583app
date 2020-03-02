package com.finastra.fpm.util.iso8583simulator.service;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.stereotype.Component;

@Component
public class DefaultResponseGenerator implements ResponseGenerator {
    @Override
    public String generate(ISOMsg isoMsg) throws IllegalArgumentException, ISOException {
        return null;
    }
}
