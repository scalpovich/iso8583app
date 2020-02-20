package com.finastra.fpm.util.iso8583msggenerator.routes;

import com.finastra.fpm.util.iso8583msggenerator.DataElement;
import com.finastra.fpm.util.iso8583msggenerator.IncomingDepositRequestProvider;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.jpos.iso.ISOMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mina2Router extends RouteBuilder {

    @Value("${my.socketserver.host:localhost}")
    private String host;

    @Value("${my.socketserver.port:6001}")
    private String port;

    @Value("${my.socketserver.sync:true}")
    private String sync;

    @Autowired
    private IncomingDepositRequestProvider incomingDepositRequestProvider;

    @Override
    public void configure() throws Exception {
        from("mina2:tcp://"+ host +":" + port + "?sync=" + sync)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Received message '" + exchange.getIn().getBody().toString() + "'");
                        ISOMsg m = new ISOMsg();
                        m.unpack (exchange.getIn().getBody().toString().getBytes());
                        List<DataElement> list = incomingDepositRequestProvider.getRequest();
                        list.forEach(e->e.setValue(m.getString(e.getId())));
                        exchange.getMessage().setBody("OK");
                    }
                });
    }
}
