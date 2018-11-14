package com.walter.lychee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.walter.lychee")
public class LycheeSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LycheeSpringbootApplication.class, args);
	}
}
