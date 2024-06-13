package com.iktobuka.homework.services;

import java.util.List;

import com.iktobuka.homework.entities.AddressEntity;

public interface AddressDao {

	public List<AddressEntity> findAddressesByUserNameDao(String name);

	public Iterable<AddressEntity> findAllDao();

	public AddressEntity createAddressDao(
			String street,
			String city,
			String country
		);
}
