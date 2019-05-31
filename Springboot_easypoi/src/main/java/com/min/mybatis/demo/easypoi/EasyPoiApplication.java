package com.min.mybatis.demo.easypoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EasyPoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyPoiApplication.class, args);
    }

}
