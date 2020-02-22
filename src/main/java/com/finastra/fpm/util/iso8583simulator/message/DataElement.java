package com.finastra.fpm.util.iso8583simulator.message;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.Validate;

import java.util.Map;

public class DataElement {
    private static final Logger logger = LoggerFactory.getLogger(DataElement.class);

    private int id;
    private String description;
    private String value;

    public DataElement() {

    }

    public DataElement(Map<String, String> map)
    {
        Validate.notNull(map, "Map argument cannot be null.");

        map.forEach((k,v) -> {
            switch (k)
            {
                case "id":
                    this.id = Integer.parseInt(v);
                    break;
                case "description":
                    this.description = v;
                    break;
                case "value":
                    this.value = v;
                    break;
                default:
                    logger.error("Unknown map entry '{}'", k);
            }
        });
    }


    public int getId() {
        return id;
    }

    public DataElement setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DataElement setDescription(String description) {
        this.description = description;
        return  this;
    }

    public String getValue() {
        return value;
    }

    public DataElement setValue(String value) {
        this.value = value;
        return this;
    }


    public String toString() {
        return "id:" + id + ", description='" + description + "', value='" + (StringUtils.isEmpty(value) ? "" : value) + "'";
    }
}
