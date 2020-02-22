package com.finastra.fpm.util.iso8583simulator.message;

import org.springframework.stereotype.Component;

@Component
public class Iso8583MessageGenerator {

    public  String generate(DataElementDto dataElementDto, String messageType) {
        ISO8583MessageType iso8583MessageType = ISO8583MessageType.valueOf(messageType);

        Iso8583MessageBuilder iso8583MessageBuilder = new Iso8583MessageBuilder(iso8583MessageType);
        dataElementDto.getDataElements().forEach(e-> {
            if (e.getValue()!=null && !e.getValue().isEmpty()) {
                iso8583MessageBuilder.putElement(e.getId(), e.getValue());
            }
        });

        return iso8583MessageBuilder.getMessage();
    }
}