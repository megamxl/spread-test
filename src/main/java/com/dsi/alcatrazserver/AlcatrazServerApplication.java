package com.dsi.alcatrazserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spread.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class AlcatrazServerApplication implements CommandLineRunner {

    @Autowired
    SpreadConnection connection;

    public static void main(String[] args) throws UnknownHostException, SpreadException {

        SpringApplication.run(AlcatrazServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SpreadGroup group = new SpreadGroup();
        group.join(connection, "group");

        SpreadMessage message = new SpreadMessage();
        message.setSafe();
        message.setData("hello".getBytes(StandardCharsets.UTF_8));
        message.addGroup("group");

        for (int i = 0; i < 10 ; i++) {
            connection.multicast(message);
            Thread.sleep(1000);
        }

    }
}
