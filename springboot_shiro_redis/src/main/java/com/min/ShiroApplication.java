package com.min;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.min.dao")
public class ShiroApplication {



	public static void main(String[] args) {
		SpringApplication.run(ShiroApplication.class, args);

	}


}
