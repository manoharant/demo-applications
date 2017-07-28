package com.lhcargo.microservices.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@Import({ JpaConfiguration.class, CustomersConfiguration.class })

@EnableAutoConfiguration
@EnableDiscoveryClient
public class CustomerServer {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "customers-server");
		SpringApplication.run(CustomerServer.class, args);
	}
}
