package com.finastra.fpm.util.iso8583simulator.service;

import com.finastra.fpm.util.iso8583simulator.message.ISO8583MessageType;
import org.apache.commons.lang3.Validate;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static com.finastra.fpm.util.iso8583simulator.message.ISO8583MessageType.getByMTI;

@Component
public class ResponseGeneratorFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public ResponseGenerator getResponseGenerator(ISOMsg isoMsg) {
        Validate.notNull(isoMsg, "isoMsg should not be null");

        String mti = null;
        try {
            mti = isoMsg.getMTI();
        } catch (ISOException e) {
            throw new RuntimeException("Exception encountered when getting MTI, unable to provide ResponseGenerator", e);
        }

        ISO8583MessageType messageType = getByMTI(mti);

        switch (messageType) {
            case DREQ:
                return applicationContext.getBean(DepositResponseGenerator.class);
            case EREQ:
                return applicationContext.getBean(EchoResponseGenerator.class);
            default:
                return applicationContext.getBean(DefaultResponseGenerator.class);
        }
    }
}
