package com.walter.lychee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.walter.lychee")
@EnableCircuitBreaker
public class LycheeApiResApplication {

	public static void main(String[] args) {
		SpringApplication.run(LycheeApiResApplication.class, args);
	}
}
