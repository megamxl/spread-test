package com.dsi.alcatrazserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spread.*;

import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class AlcatrazServerApplicationListnerTest {

    public static void main(String[] args) throws UnknownHostException, SpreadException, InterruptedIOException, InterruptedException {

        SpreadConnection connection = new SpreadConnection();
        connection.connect(InetAddress.getByName("localhost"), 4803,
                "client2", false, true);

        SpreadGroup group = new SpreadGroup();
        group.join(connection, "group");


        while (true) {
            SpreadMessage receive = connection.receive();

            if (receive.getData().length > 0) {
                System.out.println(new String (receive.getData(), StandardCharsets.UTF_8));
            } else {
                System.out.println("No message");
            }
        }

    }

}
