package com.finastra.fpm.util.iso8583msggenerator.provider;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.finastra.fpm.util.iso8583msggenerator.message.DataElement;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class DefaultDataProvider {
    private static final Logger logger = LoggerFactory.getLogger(DefaultDataProvider.class);

    public List<DataElement> getRequest() {


        List<DataElement> list = null;
        try {
            File file = new ClassPathResource(
                    "dataelements.yml").getFile();
            Validate.notNull(file, "file should not be null.");
            list = readFile(file, DataElement::new);
        } catch (IOException e) {
            logger.error("Error reading/parsing file 'dataelements.yml'", e);
        }

        return list;
    }

    private static <T> List<T> readFile(File file, Function<Map<String, String>, T> function) throws IOException {
        YamlReader reader=null;
        List<T> list = new ArrayList<>();
        Validate.notNull(file, "file should not be null.");
        Validate.notNull(list, "list should not be null.");

        try {
            reader = new YamlReader(new FileReader(file));
            Map<String, String> entry;
            do {
                entry = (Map<String, String>) reader.read();

                if (entry != null) {
                    list.add(function.apply(entry));
                }
            } while(entry != null);

        } finally {
            if (reader!=null) {
                reader.close();
            }
        }
        return list;
    }
}
