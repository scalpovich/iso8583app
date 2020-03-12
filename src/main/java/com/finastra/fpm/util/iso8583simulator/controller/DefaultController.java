package com.finastra.fpm.util.iso8583simulator.controller;


import com.finastra.fpm.util.iso8583simulator.model.DataElement;
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


import java.util.List;

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
}
