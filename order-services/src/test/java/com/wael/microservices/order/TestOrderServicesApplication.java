package com.wael.microservices.order;

import org.springframework.boot.SpringApplication;

public class TestOrderServicesApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderServicesApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
