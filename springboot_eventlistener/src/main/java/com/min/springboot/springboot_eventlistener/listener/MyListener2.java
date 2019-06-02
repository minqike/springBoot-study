package com.min.springboot.springboot_eventlistener.listener;

import com.min.springboot.springboot_eventlistener.events.MyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener2 {

    @EventListener
    public void doEvent(MyEvent event){
        System.out.println("MyListener2:用EventListener方式"+event.getData());
    }
}
