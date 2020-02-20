package com.finastra.fpm.util.iso8583msggenerator.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SedaToMinaRouter extends RouteBuilder {

    @Value("${mpm.socketserver.host:localhost}")
    private String host;

    @Value("${mpm.socketserver.port:6000}")
    private String port;

    @Value("${mpm.socketserver.sync:true}")
    private String sync;


    @Override
    public void configure() throws Exception {
        from("seda:myqueue")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("sending message to mina2:tcp://"+ host +":" + port + "?sync=" + sync);
                    }
                })
                .to("mina2:tcp://"+ host +":" + port + "?sync=" + sync + "&clientMode=true")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Response is '" + exchange.getIn().getBody().toString() + "'");
                    }
                });
    }
}
