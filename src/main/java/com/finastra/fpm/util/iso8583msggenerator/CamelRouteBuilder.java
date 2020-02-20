package com.finastra.fpm.util.iso8583msggenerator;

import com.finastra.fpm.util.iso8583msggenerator.routes.DirectToSedaMpmMinaRouter;
import com.finastra.fpm.util.iso8583msggenerator.routes.Mina2Router;
import com.finastra.fpm.util.iso8583msggenerator.routes.SedaToMinaRouter;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CamelRouteBuilder implements InitializingBean, DisposableBean {

    @Value("${mpm.socketserver.host:localhost}")
    private String host;

    @Value("${mpm.socketserver.port:8080}")
    private String port;

    @Value("${mpm.socketserver.sync:true}")
    private String sync;


    @Value("${development.actAsMpm:false}")
    private boolean actAsMpm;

    @Autowired
    private DirectToSedaMpmMinaRouter directRouter;

    @Autowired
    private Mina2Router mina2Router;

    @Autowired
    private SedaToMinaRouter sedaToMinaRouter;


    private CamelContext camelContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        camelContext = new DefaultCamelContext();

        camelContext.addRoutes(directRouter);
        camelContext.addRoutes(sedaToMinaRouter);
        if (actAsMpm) {
            camelContext.addRoutes(mina2Router);
        }

        camelContext.start();
    }


    @Override
    public void destroy() throws Exception {
        if (camelContext!=null) {
            camelContext.stop();
        }
    }


    public void sendMessage(String message) {
        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        producerTemplate.sendBody("direct:start", message);
    }
}
