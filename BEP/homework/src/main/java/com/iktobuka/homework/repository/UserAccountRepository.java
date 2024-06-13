package com.iktobuka.homework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iktobuka.homework.entities.UserAccountEntity;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccountEntity, Integer> {	
}
