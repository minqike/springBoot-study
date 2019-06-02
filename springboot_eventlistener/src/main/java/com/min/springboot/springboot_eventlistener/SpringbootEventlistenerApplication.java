package com.min.springboot.springboot_eventlistener;

import com.min.springboot.springboot_eventlistener.events.MyEvent;
import com.min.springboot.springboot_eventlistener.listener.MyListener4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootEventlistenerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEventlistenerApplication.class, args);
        context.addApplicationListener(new MyListener4());
        context.publishEvent(new MyEvent("null","测试消息"));
    }

}
