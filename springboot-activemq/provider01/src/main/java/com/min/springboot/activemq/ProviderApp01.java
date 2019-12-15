package com.min.springboot.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class ProviderApp01 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp01.class, args);
    }
}

