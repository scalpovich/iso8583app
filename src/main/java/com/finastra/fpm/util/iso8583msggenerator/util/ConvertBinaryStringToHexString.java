package com.finastra.fpm.util.iso8583msggenerator.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class ConvertBinaryStringToHexString {

    private static int CHUNK_SIZE = 16;

    private ConvertBinaryStringToHexString(){}

    public static String convert(String binaryString) {
        StringBuilder sb = new StringBuilder();

        int test = binaryString.length()%CHUNK_SIZE;
        Validate.isTrue(test==0, "binaryString should be divisible by 16");

        String stringToProcess = binaryString;
        while (StringUtils.isNotEmpty(stringToProcess)) {
            String string16 = stringToProcess.substring(0, CHUNK_SIZE);

            sb.append(convertToHex(string16));

            if (stringToProcess.length()>CHUNK_SIZE) {
                stringToProcess = stringToProcess.substring(16);
            } else {
                stringToProcess = StringUtils.EMPTY;
            }
        }

        return sb.toString();
    }

    private static String convertToHex(String bitMap16) {
        Validate.notEmpty(bitMap16, "parameter 'bitMap16' should not be null");
        Validate.isTrue(bitMap16.length()==CHUNK_SIZE, "parameter 'bitMap16' should be 16 characters long");

        int decimal = Integer.parseInt(bitMap16, 2);
        String hexStr = Integer.toString(decimal, CHUNK_SIZE);

        return StringUtils.leftPad(hexStr.toUpperCase(), 4, "0") ;
    }
}
