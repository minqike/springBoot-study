package com.min.springboot.springboot_eventlistener.listener;

import com.min.springboot.springboot_eventlistener.events.MyEvent;
import org.springframework.context.ApplicationListener;


public class MyListener1 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("MyListener1:配置文件监听"+ event.getData());
    }
}
