package com.walter.lychee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.walter.lychee.api")
@EnableCircuitBreaker
public class LycheeApiUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(LycheeApiUserApplication.class, args);
	}
}
