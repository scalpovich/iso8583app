package com.finastra.fpm.util.iso8583simulator.controller;

import com.finastra.fpm.util.iso8583simulator.routes.CamelRouteBuilder;
import com.finastra.fpm.util.iso8583simulator.message.DataElementDto;
import com.finastra.fpm.util.iso8583simulator.message.Iso8583MessageGenerator;
import com.finastra.fpm.util.iso8583simulator.service.DefaultDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DefaultController {

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Autowired private DefaultDataProvider incomingDepositRequestProvider;
    @Autowired private Iso8583MessageGenerator iso8583MessageGenerator;
    @Autowired private CamelRouteBuilder sedaProducer;

    @GetMapping("/")
    public String main(Model model) {
        DataElementDto dataElementDto = new DataElementDto();
        dataElementDto.setDataElements(incomingDepositRequestProvider.getRequest());
        model.addAttribute("form", dataElementDto);
        return "create";
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
}
