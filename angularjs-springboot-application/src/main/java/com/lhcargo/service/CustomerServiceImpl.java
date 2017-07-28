package com.lhcargo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhcargo.model.Customers;
import com.lhcargo.repository.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customers> findAllCustomers() {
		return (List<Customers>) customerRepository.findAll();
	}

	public Customers findById(int id) {
		return customerRepository.findOne(id);
	}

	public Customers findByName(String name) {
		return customerRepository.findByCustomername(name);
	}

	public void saveCustomer(Customers customer) {
		customerRepository.save(customer);
	}

	public void updateCustomer(Customers customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomerById(int id) {
		customerRepository.delete(id);

	}

	public boolean isCustomerExist(Customers customer) {
		return findByName(customer.getCustomername()) != null;
	}

	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}

}
