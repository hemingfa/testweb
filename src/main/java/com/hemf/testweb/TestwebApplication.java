package com.hemf.testweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.hemf.testweb.mapper")
public class TestwebApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(TestwebApplication.class, args);
	}
}
