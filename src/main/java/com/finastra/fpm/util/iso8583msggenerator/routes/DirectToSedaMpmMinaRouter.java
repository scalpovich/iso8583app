package com.finastra.fpm.util.iso8583msggenerator.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class DirectToSedaMpmMinaRouter extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(DirectToSedaMpmMinaRouter.class);

    @Override
    public void configure() {
        from("direct:start")
                .process(exchange -> logger.info("Sending message..."))
                .to("seda:myqueue");
    }
}
