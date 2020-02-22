package com.finastra.fpm.util.iso8583msggenerator.message;

import com.finastra.fpm.util.iso8583msggenerator.util.ConvertBinaryStringToHexString;
import org.apache.commons.lang3.Validate;

public class Iso8583MessageBuilder {
    private static int BITMAP_MAX_SIZE = 128;

    private ISO8583MessageType iso8583MessageType;
    private char[] bitmap;
    private StringBuilder stringBuilder;

    public Iso8583MessageBuilder(ISO8583MessageType iso8583MessageType) {
        this.iso8583MessageType = iso8583MessageType;
        bitmap = getNewBitMap();

        //turn on bit 1 (data element 1 for bitmaps)
        bitmap[0] = '1';

        stringBuilder = new StringBuilder();
    }

    public void appendElement(int pos, String element) {
        Validate.isTrue(pos>0 && pos<=BITMAP_MAX_SIZE, "invalid pos value " + pos + " for element '" + element + "'");
        Validate.notEmpty(element, "element should not be empty");
        bitmap[pos-1] = '1';
        stringBuilder.append(element);
    }


    private char[] getNewBitMap(){
        char[] bm = new char[BITMAP_MAX_SIZE];

        for (int i = 0; i <BITMAP_MAX_SIZE ; i++) {
            bm[i] = '0';
        }
        return bm;
    }

    public String getMessage() {
        String messageBody =
                iso8583MessageType.getMtiValue()    // MTI
                + ConvertBinaryStringToHexString.convert(new String(bitmap))   // primary+secondary bitmap
                + stringBuilder.toString();         // dataElements

        return String.format( "%04d", messageBody.length()) //length of the body
                + messageBody;  // message body
    }
}
