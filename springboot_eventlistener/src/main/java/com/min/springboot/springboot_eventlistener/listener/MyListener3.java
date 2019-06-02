package com.min.springboot.springboot_eventlistener.listener;

import com.min.springboot.springboot_eventlistener.events.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener3 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("MyListener3:用@Component方式"+ event.getData());
    }
}
