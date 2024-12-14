package com.donmba.auth_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//TODO: remove exclude = {SecurityAutoConfiguration.class}
// once api-gateway is implemented
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AuthApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(AuthApiApplication.class, args);
	}

}
