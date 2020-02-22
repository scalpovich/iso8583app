package com.finastra.fpm.util.iso8583simulator.message;

import com.finastra.fpm.util.iso8583simulator.util.ConvertBinaryStringToHexString;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;

public class Iso8583MessageBuilder {
    private static int BITMAP_MAX_SIZE = 128;

    private ISO8583MessageType iso8583MessageType;
    private String[] fieldList;

    public Iso8583MessageBuilder(ISO8583MessageType iso8583MessageType) {
        this.iso8583MessageType = iso8583MessageType;
        fieldList = new String[BITMAP_MAX_SIZE];
    }

    public void putElement(int pos, String element) {
        Validate.isTrue(pos>0 && pos<=BITMAP_MAX_SIZE, "invalid pos value " + pos + " for element '" + element + "'");
        Validate.notEmpty(element, "element should not be empty");
        fieldList[pos-1] = element;
    }

    private char[] getNewBitMap(){
        char[] bm = new char[BITMAP_MAX_SIZE];

        for (int i = 0; i <BITMAP_MAX_SIZE ; i++) {
            bm[i] = '0';
        }
        return bm;
    }

    private String getBitMap() {
        StringBuilder sb = new StringBuilder();
        char[] bitmap = getNewBitMap();

        //set bit for MTI
        bitmap[0] = '1';

        for(int i=1; i<BITMAP_MAX_SIZE;i++) {
            bitmap[i] = StringUtils.isEmpty(fieldList[i]) ? '0' : '1';
        }
        return new String(bitmap);
    }

    private String getDataElements() {
        StringBuilder sb = new StringBuilder();
        Arrays.asList(fieldList).forEach(e-> {
            if (StringUtils.isNotEmpty(e)) {
                sb.append(e);
            }
        });
        return sb.toString();
    }

    public String getMessage() {
        String messageBody =
                iso8583MessageType.getMtiValue()                        // MTI
                + ConvertBinaryStringToHexString.convert(getBitMap())   // primary+secondary bitmap
                + getDataElements();                                    // dataElements

        return String.format( "%04d", messageBody.length())         //length of the body
                + messageBody;                                         // message body
    }
}
