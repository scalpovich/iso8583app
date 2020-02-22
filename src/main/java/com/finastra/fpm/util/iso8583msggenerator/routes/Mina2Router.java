package com.finastra.fpm.util.iso8583msggenerator.routes;

import com.finastra.fpm.util.iso8583msggenerator.message.DataElement;
import com.finastra.fpm.util.iso8583msggenerator.provider.DefaultDataProvider;
import org.apache.camel.builder.RouteBuilder;
import org.jpos.iso.ISOMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mina2Router extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(Mina2Router.class);

    @Value("${my.socketserver.host:localhost}")
    private String host;

    @Value("${my.socketserver.port:6001}")
    private String port;

    @Value("${my.socketserver.sync:true}")
    private String sync;

    @Autowired
    private DefaultDataProvider incomingDepositRequestProvider;

    @Override
    public void configure() {
        from("mina2:tcp://"+ host +":" + port + "?sync=" + sync)
                .process(exchange -> {
                    logger.info("Received message '{}'",exchange.getIn().getBody());
                    ISOMsg m = new ISOMsg();
                    m.unpack (exchange.getIn().getBody().toString().getBytes());
                    List<DataElement> list = incomingDepositRequestProvider.getRequest();
                    list.forEach(e->e.setValue(m.getString(e.getId())));
                    exchange.getMessage().setBody("OK");
                });
    }
}
