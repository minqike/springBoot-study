package com.min.springboot.activemq.service;

import com.min.springboot.activemq.entity.Person;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TopicService {

    @JmsListener(destination = "ActiveMQTopic",containerFactory = "jmsTopicListenerContainerFactory")
    public void handleMessage1(Person person) {
        System.out.println((new Date()).getTime() +"-Person成功接受person1=" + person.toString());
    }

    @JmsListener(destination = "ActiveMQTopic",containerFactory = "jmsTopicListenerContainerFactory")
    public void handleMessage2(Person person) {
        System.out.println((new Date()).getTime() +"-Person成功接受person2=" + person.toString());
    }
}
