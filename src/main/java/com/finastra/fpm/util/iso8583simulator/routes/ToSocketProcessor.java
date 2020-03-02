package com.finastra.fpm.util.iso8583simulator.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ToSocketProcessor implements Processor {
    private static final Logger logger = LoggerFactory.getLogger(ToSocketProcessor.class);

    private String hostName;
    private int port;

    public ToSocketProcessor(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }


    @Override
    public void process(Exchange exchange) throws Exception {
        String inputMessage = exchange.getIn().getBody().toString();

        try (Socket kkSocket = new Socket(hostName, port);
             PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));) {
            logger.info("Connected to {}:{}",hostName, port);

            out.println(inputMessage);
            logger.info("Sent message {}", inputMessage);
            String fromServer;
            if ((fromServer = in.readLine()) != null) {
                exchange.getMessage().setBody(fromServer, String.class);
                logger.info("Received: \n" + fromServer);
            }
            in.close();
            out.close();
            kkSocket.close();
            logger.info("Sent message {} to server {}:{}", inputMessage, hostName, port);
        } catch (UnknownHostException e) {
            logger.error("Could not find host {}", hostName, e);
        } catch (IOException e) {
            logger.error("Couldn't get I/O for the connection to {}:{}", hostName,port, e);
        }
    }
}
