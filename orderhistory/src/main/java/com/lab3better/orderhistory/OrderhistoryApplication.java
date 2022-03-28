package com.lab3better.orderhistory;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderhistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderhistoryApplication.class, args);
	}

	@Bean
	GroupedOpenApi readOperations() {
		String[] packages = {"com.lab3better.orderhistory.controller.read"};
		return GroupedOpenApi.builder().group("readOperations").packagesToScan(packages).build();
	}

	@Bean
	GroupedOpenApi writeOperations() {
		String[] packages = {"com.lab3better.orderhistory.controller.write"};
		return GroupedOpenApi.builder().group("writeOperations").packagesToScan(packages).build();
	}
}
