package com.walter.lychee.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LycheeSpringcloudGatewayApplication {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes().route(r -> r.path("/jd").uri("http://www.baidu.com").id("jd_route")).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(LycheeSpringcloudGatewayApplication.class, args);
	}
}
