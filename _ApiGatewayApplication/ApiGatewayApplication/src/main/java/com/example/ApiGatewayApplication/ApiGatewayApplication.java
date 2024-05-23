package com.example.ApiGatewayApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route("events", p -> p
						.path("/events")
						.uri("http://localhost:8080"))

				.route("users",p -> p
						.path("/users")
						.uri("http://localhost:8083"))

				.route("model", p -> p
						.path("/api/v1/ai/generate/info/**")
						.uri("http://localhost:8081"))
				.build();
			}
}


