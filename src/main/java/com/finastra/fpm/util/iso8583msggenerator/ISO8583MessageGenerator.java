package com.finastra.fpm.util.iso8583msggenerator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ISO8583MessageGenerator {

    private static String DEFAULT_BITMAP = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
    private String bitmap;

    public  String generate(DataElementDto dataElementDto, String messageType) {
        StringBuilder msg = new StringBuilder();

        bitmap = DEFAULT_BITMAP.toString();

        msg.append(getDataElements(dataElementDto.getDataElements(), bitmap));

        /* Appending Primary+Secondary bitmaps*/
        msg.insert(0, convertToHex(bitmap));

        /* Appending MTI*/
        switch (messageType) {
            case AppConstants.EREQ :
                msg.insert(0, AppConstants.ECHO_REQUEST_MTI);
                break;
            case AppConstants.ERES :
                msg.insert(0, AppConstants.ECHO_RESPONSE_MTI);
                break;
            case AppConstants.DREQIN :
            case AppConstants.DREQOUT :
                msg.insert(0, AppConstants.REQUEST_MTI);
                break;
            case AppConstants.DRESIN :
            case AppConstants.DRESOUT :
                msg.insert(0, AppConstants.RESPONSE_MTI);
        }

        /* Appending Header*/
        msg.insert(AppConstants.START_INDEX, String.format("%04d", msg.length()));

        return msg.toString();
    }

    private  StringBuilder getDataElements(List<DataElement> dataElements, String bitmap) {
        StringBuilder msg = new StringBuilder();
        dataElements.forEach(e-> {
            if (e.getValue()!=null && !e.getValue().isEmpty()) {
                msg.append(e.getValue());
                setBit(e.getId(), bitmap);
            }
        });
        setBit(1, bitmap);

        return msg;
    }

    private void setBit(int pos, String bitmap) {
        bitmap = bitmap.substring(0,pos-1)+"1"+bitmap.substring(pos);
    }

    private String convertToHex(String bitMap) {
        String hex = "";
        while (!bitMap.isEmpty()) {
            String bitset = bitMap.substring(0, 4);
            bitMap = bitMap.substring(4);
            int hexNo = (bitset.charAt(0) == '0' ? 0 : 1) * 8 + (bitset.charAt(1) == '0' ? 0 : 1) * 4
                    + (bitset.charAt(2) == '0' ? 0 : 1) * 2 + (bitset.charAt(3) == '0' ? 0 : 1) * 1;
            switch (hexNo) {
                case 10:
                    hex += "A";
                    break;
                case 11:
                    hex += "B";
                    break;
                case 12:
                    hex += "C";
                    break;
                case 13:
                    hex += "D";
                    break;
                case 14:
                    hex += "E";
                    break;
                case 15:
                    hex += "F";
                    break;
                default:
                    hex += hexNo;
            }
        }
        return hex;
    }
}