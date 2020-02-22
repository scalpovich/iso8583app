package com.finastra.fpm.util.iso8583msggenerator.message;

public enum ISO8583MessageType {
    DREQIN ("DREQIN", "0200"),
    DRESIN ("DRESIN", "0210"),
    EREQ("EREQ", "0800"),
    ERES("ERES", "0810")
    ;

    private String messageType;
    private String mtiValue;

    ISO8583MessageType(String messageType, String mtiValue) {
        this.messageType = messageType;
        this.mtiValue = mtiValue;
    }


    public String getMessageType(){
        return this.messageType;
    }

    public String getMtiValue(){
        return this.mtiValue;
    }
}
