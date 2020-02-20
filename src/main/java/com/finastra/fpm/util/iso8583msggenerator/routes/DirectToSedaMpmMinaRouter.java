package com.finastra.fpm.util.iso8583msggenerator.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class DirectToSedaMpmMinaRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Sending message...");
                    }
                })
                .to("seda:myqueue");
    }
}
