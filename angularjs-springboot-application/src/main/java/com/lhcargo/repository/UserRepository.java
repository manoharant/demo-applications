package com.lhcargo.repository;

import org.springframework.data.repository.CrudRepository;

import com.lhcargo.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String name);
}
