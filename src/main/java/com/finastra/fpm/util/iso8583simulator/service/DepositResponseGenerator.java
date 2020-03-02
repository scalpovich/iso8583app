package com.finastra.fpm.util.iso8583simulator.service;

import com.finastra.fpm.util.iso8583simulator.message.Fields;
import com.finastra.fpm.util.iso8583simulator.message.Iso8583MessageBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DepositResponseGenerator implements ResponseGenerator {
    private static final Logger logger = LoggerFactory.getLogger(DepositResponseGenerator.class);

    @Value("${max.field.id:64}")
    private int maxFieldId;

    @Value("${response.acsp.code:00}")
    private String acspResponseCode;

    @Value("${response.rjct.code:05}")
    private String rjctResponseCode;

    @Autowired
    private ResponseGeneratorHelper responseGeneratorHelper;

    private static List<Integer> fieldListToCopy = new ArrayList<>(Arrays.asList(2,3,4,7,11,12,14,18,22,37,41,42,43,47,48,49));

    @Override
    public String generate(ISOMsg isoMsg) throws IllegalArgumentException, ISOException {
        Validate.notNull(isoMsg, "isoMsg should not be null");

        Iso8583MessageBuilder iso8583MessageBuilder = responseGeneratorHelper.getBuilderForAutoResponse(isoMsg);

        boolean ignore =  isIgnore(isoMsg);
        if (ignore) {
            logger.warn("Ignoring message " + isoMsg.toString());
        }

        boolean accept = isAccept(isoMsg);
        if (accept) {
            iso8583MessageBuilder.putElement(Fields.RESPONSE_CODE.getPos(), acspResponseCode);

            //TODO check with Judith if this is the correct value for this field
            String authIdResponse = "ACCEPT";
            iso8583MessageBuilder.putElement(Fields.AUTH_ID_RESP.getPos(), authIdResponse);
        } else {
            iso8583MessageBuilder.putElement(Fields.RESPONSE_CODE.getPos(), rjctResponseCode);
        }

        // Copy other fields defined in the specification for response
        fieldListToCopy.forEach(i-> {
            if (StringUtils.isNotEmpty(isoMsg.getString(i))) {
                iso8583MessageBuilder.putElement(i, isoMsg.getString(i));
            }
        });

        // TODO what about MAC?


        return iso8583MessageBuilder.getMessage();
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
