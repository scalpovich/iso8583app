package com.finastra.fpm.util.iso8583msggenerator;

import org.apache.commons.lang3.StringUtils;
import org.thymeleaf.util.Validate;

import java.util.Map;

public class DataElement {
    private int id;
    private String description;
    private String value;

    public DataElement() {

    }

    public DataElement(Map<String, String> map)
    {
        Validate.notNull(map, "Map argument cannot be null.");

        for (String key : map.keySet())
        {
            switch (key)
            {
                case "id":
                    this.id = Integer.parseInt(map.get(key));
                    break;
                case "description":
                    this.description = map.get(key);
                    break;
                case "value":
                    this.value = map.get(key);
            }
        }

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
