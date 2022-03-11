package com.example.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
// Enable consumption of HATEOAS payloads and uses HAL - Hypertext Application Language
// (https://stateless.group/hal_specification.html) as the format
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
// Clients
// https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html
@EnableFeignClients
public class FrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendApplication.class, args);
		System.out.println("Frontend Initialized...");
	}
}
