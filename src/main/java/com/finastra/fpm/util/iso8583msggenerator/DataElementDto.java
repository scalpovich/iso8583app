package com.finastra.fpm.util.iso8583msggenerator;

import java.util.List;

public class DataElementDto {
    private List<DataElement> dataElements;
    private String messageType =AppConstants.DREQIN;

    public DataElementDto() {

    }

    public DataElementDto(List<DataElement> list) {
        this.dataElements = list;
    }

    public void addDataElements(DataElement dataElement) {
        this.dataElements.add(dataElement);
    }

    public List<DataElement> getDataElements() {
        return dataElements;
    }

    public void setDataElements(List<DataElement> dataElements) {
        this.dataElements = dataElements;
    }


    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
