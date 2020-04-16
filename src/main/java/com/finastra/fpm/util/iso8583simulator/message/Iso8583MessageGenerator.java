package com.finastra.fpm.util.iso8583simulator.message;

import com.finastra.fpm.util.iso8583simulator.model.ISO8583Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Iso8583MessageGenerator {

    @Autowired
    private ApplicationContext applicationContext;

    public  String generate(DataElementDto dataElementDto, String messageType) {
        ISO8583MessageType iso8583MessageType = ISO8583MessageType.valueOf(messageType);

        Iso8583MessageBuilder iso8583MessageBuilder =
                applicationContext.getBean(Iso8583MessageBuilder.class, iso8583MessageType);

        dataElementDto.getDataElements().forEach(e-> {

                iso8583MessageBuilder.putElement(e.getId(), e.getValue());

        });

        return iso8583MessageBuilder.getMessage();
    }

    public  String generate(ISO8583Message iso8583Message, String messageType) {
        ISO8583MessageType iso8583MessageType = ISO8583MessageType.valueOf(messageType);

       /* Iso8583MessageBuilder iso8583MessageBuilder =
                applicationContext.getBean(Iso8583MessageBuilder.class, iso8583MessageType);

        dataElementDto.getDataElements().forEach(e-> {
            if (e.getValue()!=null && !e.getValue().isEmpty()) {
                iso8583MessageBuilder.putElement(e.getId(), e.getValue());
            }
        });*/
        return "";
        //return iso8583MessageBuilder.getMessage();
    }
}