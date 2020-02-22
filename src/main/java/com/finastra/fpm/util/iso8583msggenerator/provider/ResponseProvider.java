package com.finastra.fpm.util.iso8583msggenerator.provider;

import com.finastra.fpm.util.iso8583msggenerator.message.DataElementDto;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

@Component
public class ResponseProvider {

    public void convertToResponse(DataElementDto dataElementDto) {
        Validate.notNull(dataElementDto, "dataElementDto should not be null.");
        Validate.notEmpty(dataElementDto.getDataElements(), "dataElements should not be empty.");




    }


}
