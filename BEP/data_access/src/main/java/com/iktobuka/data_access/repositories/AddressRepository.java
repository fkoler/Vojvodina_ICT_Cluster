package com.iktobuka.data_access.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.iktobuka.data_access.entities.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {
	List<AddressEntity> findByCity(String city);

	List<AddressEntity> findByOrderByCountryAsc();

	List<AddressEntity> findByStreetAndCity(String street, String city);

	Optional<AddressEntity> findByStreetAndCityAndCountry(String street, String city, String country);
	
	List<AddressEntity> findByCountry(String country);
}
