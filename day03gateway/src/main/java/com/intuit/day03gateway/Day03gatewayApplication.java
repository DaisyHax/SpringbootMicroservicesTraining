package com.intuit.day03gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Day03gatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day03gatewayApplication.class, args);
    }

}
