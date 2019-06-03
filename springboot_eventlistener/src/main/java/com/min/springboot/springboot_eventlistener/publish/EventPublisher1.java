package com.min.springboot.springboot_eventlistener.publish;

import com.min.springboot.springboot_eventlistener.events.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher1 {
    @Autowired
    private ApplicationContext applicationContext;

    public void  publishEvent(Object source,String data){
        MyEvent myEvent = new MyEvent(source, data);
        applicationContext.publishEvent(myEvent);
    }

}
