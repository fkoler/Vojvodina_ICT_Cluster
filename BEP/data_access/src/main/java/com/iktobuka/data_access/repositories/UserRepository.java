package com.iktobuka.data_access.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktobuka.data_access.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	UserEntity findByEmail(String email);

	List<UserEntity> findByNameOrderByEmailAsc(String name);
}
