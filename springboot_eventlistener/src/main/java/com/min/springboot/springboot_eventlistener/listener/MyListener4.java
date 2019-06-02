package com.min.springboot.springboot_eventlistener.listener;

import com.min.springboot.springboot_eventlistener.events.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

public class MyListener4 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("MyListener4:手工向ApplicationContext中添加监听器"+ event.getData());
    }
}
