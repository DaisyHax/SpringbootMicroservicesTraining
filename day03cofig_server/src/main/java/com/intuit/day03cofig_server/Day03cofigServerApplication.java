package com.intuit.day03cofig_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Day03cofigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day03cofigServerApplication.class, args);
    }

}
