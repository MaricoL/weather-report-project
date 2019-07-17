package com.waylau.spring.cloud.initializerstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InitializerStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitializerStartApplication.class, args);
	}

}
