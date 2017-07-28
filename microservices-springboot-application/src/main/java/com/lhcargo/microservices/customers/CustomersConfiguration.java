package com.lhcargo.microservices.customers;

import java.util.logging.Logger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The accounts Spring configuration.
 * 
 * @author Lufthansa Industry Solutions
 */
@Configuration
@ComponentScan
public class CustomersConfiguration {

	protected Logger logger;

	public CustomersConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

}
