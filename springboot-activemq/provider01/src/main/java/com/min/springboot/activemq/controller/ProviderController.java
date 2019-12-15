package com.min.springboot.activemq.controller;

import com.min.springboot.activemq.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import java.time.Period;
import java.util.Date;

@RestController
public class ProviderController {

    //注入存放消息的队列，用于下列方法一
    @Autowired
    private Queue queue;

    //注入springboot封装的工具类
    //当spring.activemq.pool.enabled=true的时候,必需在BeanConfig中生成bean,原因未知
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("send")
    public void send(String name) {

        Person person = new Person(1, "minqike", "男");
        //方法一：添加消息到消息队列
        jmsMessagingTemplate.convertAndSend(queue, name);
        jmsMessagingTemplate.convertAndSend("Person",person);
        //方法二：这种方式不需要手动创建queue，系统会自行创建名为test的队列
        //jmsMessagingTemplate.convertAndSend("test", name);

        System.out.println((new Date()).getTime() + "-发送成功");
    }
}
