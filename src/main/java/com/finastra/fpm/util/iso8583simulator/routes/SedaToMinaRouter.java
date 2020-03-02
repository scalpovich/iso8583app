package com.finastra.fpm.util.iso8583simulator.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SedaToMinaRouter extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(SedaToMinaRouter.class);

    @Value("${fpm.socketserver.host:localhost}")
    private String host;

    @Value("${fpm.socketserver.port:6000}")
    private int port;

    @Value("${fpm.socketserver.sync:true}")
    private String sync;

    private  ToSocketProcessor processor;

    @PostConstruct
    public void initialize() {
        this.processor = new ToSocketProcessor(host, port);
    }



    @Override
    public void configure() {
        from("seda:myqueue")
                .process(exchange -> logger.info("sending message to mina2:tcp://{}:{}?sync={} message is {}", host, port, sync, exchange.getIn().getBody().toString()))
//                .process(processor)
//                .to("stub:nowhere")
                .to("mina2:tcp://"+ host +":" + port + "?sync=" + sync + "&clientMode=true")
                .process(exchange -> logger.info("Response is '{}'", exchange.getIn().getBody()));
    }
}
