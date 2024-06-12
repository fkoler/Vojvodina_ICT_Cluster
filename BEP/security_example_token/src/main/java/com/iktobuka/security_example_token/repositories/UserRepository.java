package com.iktobuka.security_example_token.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktobuka.security_example_token.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	public UserEntity findByEmail(String email);
}
