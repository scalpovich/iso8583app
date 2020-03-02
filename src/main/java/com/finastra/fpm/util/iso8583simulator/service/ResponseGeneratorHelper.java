package com.finastra.fpm.util.iso8583simulator.service;

import com.finastra.fpm.util.iso8583simulator.message.ISO8583MessageType;
import com.finastra.fpm.util.iso8583simulator.message.Iso8583MessageBuilder;
import org.apache.commons.lang3.Validate;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ResponseGeneratorHelper {

    @Autowired
    private ApplicationContext applicationContext;

    public Iso8583MessageBuilder getBuilderForAutoResponse(ISOMsg isoMsg) throws ISOException {
        Validate.notNull(isoMsg, "isoMsg should not be null");

        String mti = isoMsg.getMTI();
        ISO8583MessageType messageType = ISO8583MessageType.getByMTI(mti);
        String responseTypeString = messageType.getResponseType();
        if (responseTypeString==null) {
            throw new IllegalArgumentException("Cannot generate a response from a response message");
        }

        ISO8583MessageType responseType = ISO8583MessageType.valueOf(responseTypeString);
        Iso8583MessageBuilder iso8583MessageBuilder =
                applicationContext.getBean(Iso8583MessageBuilder.class, responseType);
        return iso8583MessageBuilder;
    }
}
