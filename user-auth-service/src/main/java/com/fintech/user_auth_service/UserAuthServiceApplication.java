package com.fintech.user_auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class UserAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthServiceApplication.class, args);
	}

}
