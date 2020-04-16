package com.finastra.fpm.util.iso8583simulator.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finastra.fpm.util.iso8583simulator.model.DataElement;
import com.finastra.fpm.util.iso8583simulator.model.ISO8583Message;
import com.finastra.fpm.util.iso8583simulator.routes.CamelRouteBuilder;
import com.finastra.fpm.util.iso8583simulator.message.DataElementDto;
import com.finastra.fpm.util.iso8583simulator.message.Iso8583MessageGenerator;
import com.finastra.fpm.util.iso8583simulator.service.DefaultDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = { "http://localhost:3000"})
public class DefaultController {

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Autowired private DefaultDataProvider incomingDepositRequestProvider;
    @Autowired private Iso8583MessageGenerator iso8583MessageGenerator;
    @Autowired private CamelRouteBuilder sedaProducer;

    @GetMapping("/")
    public ModelAndView main(){
        DataElementDto dataElementDto = new DataElementDto();
        dataElementDto.setDataElements(incomingDepositRequestProvider.getRequest());
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("form", dataElementDto);
        return modelAndView;
    }

    @GetMapping("/iso8583")
    public List<DataElement> getDataElements(Model model) {
        return incomingDepositRequestProvider.getRequest();
    }

    @PostMapping("/create")
    public String create (@ModelAttribute DataElementDto form, Model model) {

        String generatedMessage = iso8583MessageGenerator.generate(form, form.getMessageType());
        logger.info("generatedMessage='{}'", generatedMessage);

        sedaProducer.sendMessage(generatedMessage);

        model.addAttribute("form", form);
        form.getDataElements().forEach(e->logger.info(e.toString()));
        return "redirect:/";
    }

    @PostMapping("/createISO8583")
    public String createISO8583(@RequestBody ISO8583Message iso8583) throws JsonProcessingException {
        List<DataElement> dataElementList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(iso8583);
        Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});

        map.forEach((key,value)->{
            List<DataElement> dataElements = incomingDepositRequestProvider.getRequest();
            dataElements.forEach(dataElement -> {
               if(dataElement.getValue().equals(key)) {
                   DataElement dataElement1 = new DataElement();
                   dataElement1.setId(dataElement.getId());
                   dataElement1.setValue(String.valueOf(value));
                   dataElementList.add(dataElement1);
               }
            });
        });

        DataElementDto dataElementDto = new DataElementDto();
        dataElementDto.setDataElements(dataElementList);

        String generatedMessage = iso8583MessageGenerator.generate(dataElementDto, iso8583.getMessageType());
        logger.info("generatedMessage='{}'", generatedMessage);

        //sedaProducer.sendMessage(generatedMessage);

        /*model.addAttribute("form", form);
        form.getDataElements().forEach(e->logger.info(e.toString()));*/
        /*return "redirect:/";*/
        return generatedMessage;
    }
}
