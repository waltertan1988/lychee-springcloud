package com.walter.lychee.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LycheeSpringcloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LycheeSpringcloudEurekaApplication.class, args);
	}
}
