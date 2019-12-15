package com.min.springboot.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

@Configuration
public class BeanConfig {

    //定义存放消息的队列
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("ActiveMQQueue");
    }

//    @Bean
//    ConnectionFactory connectionFactory() {
//        return new ActiveMQConnectionFactory();
//    }
//
//    @Bean
//    JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
//        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
//        jmsTemplate.setPriority(999);
//        return jmsTemplate;
//    }
//
//    @Bean(value="jmsMessagingTemplate")
//    JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
//        JmsMessagingTemplate messagingTemplate = new JmsMessagingTemplate(jmsTemplate);
//        return messagingTemplate;
//    }

}
