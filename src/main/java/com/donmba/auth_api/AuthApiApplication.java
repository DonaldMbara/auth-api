package com.donmba.auth_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//TODO: remove exclude = {SecurityAutoConfiguration.class}
// once api-gateway is implemented
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AuthApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(AuthApiApplication.class, args);
	}

}
