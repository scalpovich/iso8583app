package com.finastra.fpm.util.iso8583simulator.service;

import com.finastra.fpm.util.iso8583simulator.message.Fields;
import com.finastra.fpm.util.iso8583simulator.message.Iso8583MessageBuilder;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EchoResponseGenerator implements ResponseGenerator{
    private static final Logger logger = LoggerFactory.getLogger(EchoResponseGenerator.class);

    @Autowired
    private ResponseGeneratorHelper responseGeneratorHelper;

    @Override
    public String generate(ISOMsg isoMsg) throws IllegalArgumentException, ISOException {
        // TODO implement me!


        return null;
    }

    // TODO implement me
    //  Determine rule when to respond an accept
    //  for now, this will always return true.
    private boolean isAccept(ISOMsg isoMsg) {
        return true;
    }

    //TODO
    // In NAPAS mock, if creditor is not present (field 103 starts with 0) discard/ignore this message
    // in InstaPay, it is on field 62, should we do the same?
    // isoMsg.getString(62).
    private boolean isIgnore(ISOMsg isoMsg) {
        return false;
    }
}
