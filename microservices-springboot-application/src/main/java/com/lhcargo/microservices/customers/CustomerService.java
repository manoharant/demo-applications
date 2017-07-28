package com.lhcargo.microservices.customers;

import java.util.List;

public interface CustomerService {

	Customers findById(Integer id);

	Customers findByName(String name);

	void saveCustomer(Customers customer);

	void updateCustomer(Customers customer);

	void deleteCustomerById(Integer id);

	void deleteAllCustomers();

	List<Customers> findAllCustomers();

	boolean isCustomerExist(Customers customer);
}