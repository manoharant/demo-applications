package com.lhcargo.repository;

import org.springframework.data.repository.CrudRepository;

import com.lhcargo.model.Customers;

public interface CustomerRepository extends CrudRepository<Customers, Integer> {

	Customers findByCustomername(String name);
}
