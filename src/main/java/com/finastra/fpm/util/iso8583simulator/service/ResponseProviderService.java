package com.finastra.fpm.util.iso8583simulator.service;

import org.apache.commons.lang3.Validate;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseProviderService {
    private static final Logger logger = LoggerFactory.getLogger(ResponseProviderService.class);

    @Autowired
    private ResponseGeneratorFactory responseGeneratorFactory;

    public String generateResponse (ISOMsg isoMsg) throws IllegalArgumentException, ISOException {
        Validate.notNull(isoMsg, "isoMsg should not be null");

        ResponseGenerator responseGenerator = responseGeneratorFactory.getResponseGenerator(isoMsg);

        return responseGenerator.generate(isoMsg);
    }
}