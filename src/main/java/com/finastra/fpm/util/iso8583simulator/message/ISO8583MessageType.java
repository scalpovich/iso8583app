package com.finastra.fpm.util.iso8583simulator.message;

import org.apache.commons.lang3.Validate;

public enum ISO8583MessageType {
    DREQ ("DREQ", "0200", "DRES"),
    DRES ("DRES", "0210", null),
    EREQ("EREQ", "0800", "ERES"),
    ERES("ERES", "0810", null)
    ;

    private String messageType;
    private String mtiValue;
    private String responseType;

    ISO8583MessageType(String messageType, String mtiValue,String responseType) {
        this.messageType = messageType;
        this.mtiValue = mtiValue;
        this.responseType = responseType;
    }


    public String getResponseType() {
        return responseType;
    }

    public String getMessageType(){
        return this.messageType;
    }

    public String getMtiValue(){
        return this.mtiValue;
    }

    public static ISO8583MessageType getByMTI(String mti) {
        Validate.notEmpty(mti, "MTI should not be null");

        for (ISO8583MessageType iso8583MessageType : values()) {
            if (iso8583MessageType.getMtiValue().equals(mti)) {
                return iso8583MessageType;
            }
        }
        throw new IllegalArgumentException("Unable to find message type for MTI '" + mti + "'");
    }
}
