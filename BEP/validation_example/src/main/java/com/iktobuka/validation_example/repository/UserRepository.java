package com.iktobuka.validation_example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iktobuka.validation_example.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
