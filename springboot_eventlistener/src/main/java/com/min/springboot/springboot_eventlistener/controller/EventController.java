package com.min.springboot.springboot_eventlistener.controller;

import com.min.springboot.springboot_eventlistener.publish.EventPublisher1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    EventPublisher1 eventPublisher1;

    @GetMapping("/event")
    public String event1(){
        eventPublisher1.publishEvent(eventPublisher1,"注册测试");
        return "事件发布完毕";
    }
}
