package com.finastra.fpm.util.iso8583simulator.routes;

import com.finastra.fpm.util.iso8583simulator.service.ResponseProviderService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jpos.iso.ISOMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mina2Router extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(Mina2Router.class);

    @Value("${simulator.socketserver.host:localhost}")
    private String host;

    @Value("${simulator.socketserver.port:6001}")
    private String port;

    @Value("${simulator.socketserver.sync:true}")
    private String sync;

    @Autowired
    private ResponseProviderService responseProviderService;

    @Override
    public void configure() {
        from("mina2:tcp://"+ host +":" + port + "?sync=" + sync)
                .process(exchange -> {
                    logger.info("Received message '{}'",exchange.getIn().getBody());
                    ISOMsg m = new ISOMsg();
                    m.unpack (exchange.getIn().getBody().toString().getBytes());

                    String response = responseProviderService.generateResponse(m);
                    if (StringUtils.isNotEmpty(response)) {
                        exchange.getMessage().setBody(response);
                    } else {
                        exchange.getMessage().setBody(StringUtils.EMPTY);
                    }
                });
    }
}
