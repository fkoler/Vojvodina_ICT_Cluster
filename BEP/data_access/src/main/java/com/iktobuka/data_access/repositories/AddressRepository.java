package com.iktobuka.data_access.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktobuka.data_access.entities.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {
}
