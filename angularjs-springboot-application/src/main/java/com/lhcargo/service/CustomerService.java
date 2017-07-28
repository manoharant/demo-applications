package com.lhcargo.service;

import java.util.List;

import com.lhcargo.model.Customers;

public interface CustomerService {

	Customers findById(int id);

	Customers findByName(String name);

	void saveCustomer(Customers customer);

	void updateCustomer(Customers customer);

	void deleteCustomerById(int id);

	List<Customers> findAllCustomers();

	void deleteAllCustomers();

	public boolean isCustomerExist(Customers customer);

}
