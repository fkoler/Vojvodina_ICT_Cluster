package com.iktobuka.data_access.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.data_access.entities.AddressEntity;
import com.iktobuka.data_access.repositories.AddressRepository;

@RestController
@RequestMapping(value = "/api/v1/addresses")
public class AddressController {

	@Autowired
	protected AddressRepository addressRepository;

	@GetMapping("/all")
	public Iterable<AddressEntity> getAllAddresses() {
		return addressRepository.findAll();
	}

	@PostMapping("/create")
	public AddressEntity createAddress(@RequestParam String street, @RequestParam String city,
			@RequestParam String country) {
		AddressEntity address = new AddressEntity();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		addressRepository.save(address);

		return address;
	}

	@PostMapping("/add")
	public AddressEntity addNewAddress(@RequestParam String street, @RequestParam String city,
			@RequestParam String country) {
		AddressEntity address = new AddressEntity();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		addressRepository.save(address);

		return address;
	}
}
