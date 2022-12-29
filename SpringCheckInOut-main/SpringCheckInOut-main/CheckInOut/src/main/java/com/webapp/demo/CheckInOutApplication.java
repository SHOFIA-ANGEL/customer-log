package com.webapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CheckInOutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckInOutApplication.class, args);
	}

}
