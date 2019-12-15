package com.min.springboot.activemq.service;

import com.min.springboot.activemq.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConsumerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
    @JmsListener(destination = "ActiveMQQueue")
    // SendTo 会将此方法返回的数据, 写入到 OutQueue 中去.
    @SendTo("SQueue")
    public String handleMessage(String name) {
        System.out.println((new Date()).getTime() +"-ActiveMQQueue成功接受Name=" + name);
        return "成功接受Name" + name;
    }
    @JmsListener(destination = "SQueue")
    public void handleMessage2(String name) {
        System.out.println((new Date()).getTime() +"-SQueue成功接受Name=" + name);
    }

    @JmsListener(destination = "Person")
    public void handleMessage3(Person person) {
        System.out.println((new Date()).getTime() +"-Person成功接受person=" + person.toString());
    }
}
