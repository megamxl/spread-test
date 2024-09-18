package com.dsi.alcatrazserver;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spread.SpreadConnection;
import spread.SpreadException;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@ComponentScan
public class SpreadConfig {

    @Value("${spread.host}")
    String host;

    @Value("${spread.port}")
    int port;

    @Value("${spread.clientName}")
    String clientName;

    @Bean
    public SpreadConnection getConnection() throws UnknownHostException, SpreadException {
        SpreadConnection connection = new SpreadConnection();
        connection.connect(InetAddress.getByName(host), port,
               clientName , false, true);
        return connection;
    }


}
