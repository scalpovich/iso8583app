package com.finastra.fpm.util.iso8583msggenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DefaultController {

    @Autowired private IncomingDepositRequestProvider incomingDepositRequestProvider;
    @Autowired private ISO8583MessageGenerator iso8583MessageGenerator;
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
        System.out.println("generatedMessage='" + generatedMessage + "'");


        sedaProducer.sendMessage(generatedMessage);

        model.addAttribute("form", form);
        form.getDataElements().forEach(System.out::println);
        return "redirect:/";
    }
}
