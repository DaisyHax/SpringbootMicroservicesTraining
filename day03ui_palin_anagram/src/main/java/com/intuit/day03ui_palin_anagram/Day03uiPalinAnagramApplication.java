package com.intuit.day03ui_palin_anagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Day03uiPalinAnagramApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day03uiPalinAnagramApplication.class, args);
    }

}
