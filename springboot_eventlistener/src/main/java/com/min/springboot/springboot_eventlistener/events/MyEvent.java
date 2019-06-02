package com.min.springboot.springboot_eventlistener.events;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class MyEvent extends ApplicationEvent {

    private String data;

    public MyEvent(Object source, String data) {
        super(source);
        this.data = data;
    }

}
