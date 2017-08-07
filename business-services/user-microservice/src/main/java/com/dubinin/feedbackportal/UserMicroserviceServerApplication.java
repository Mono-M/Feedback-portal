package com.dubinin.feedbackportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
@EnableAutoConfiguration
public class UserMicroserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceServerApplication.class, args);
	}
	
}
