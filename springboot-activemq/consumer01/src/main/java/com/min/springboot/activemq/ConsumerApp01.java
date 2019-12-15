package com.min.springboot.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJms
public class ConsumerApp01
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConsumerApp01.class, args);
    }
}
