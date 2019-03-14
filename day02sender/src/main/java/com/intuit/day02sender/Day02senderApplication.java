package com.intuit.day02sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@EnableJms
@SpringBootApplication
public class Day02senderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day02senderApplication.class, args);
    }

    @Bean
    public JmsListenerContainerFactory<?> stockFactory(
            ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        configurer.configure(factory, connectionFactory);
        return factory;
    }

}
