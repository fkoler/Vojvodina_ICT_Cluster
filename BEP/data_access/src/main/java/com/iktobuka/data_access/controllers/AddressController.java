package com.iktobuka.data_access.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.data_access.entities.AddressEntity;
import com.iktobuka.data_access.entities.UserEntity;
import com.iktobuka.data_access.repositories.AddressRepository;
import com.iktobuka.data_access.repositories.UserRepository;
import com.iktobuka.data_access.services.AddressDao;

@RestController
@RequestMapping(value = "/api/v1/addresses")
public class AddressController {

	@Autowired
	protected AddressRepository addressRepository;
	
	@Autowired
	protected AddressDao addressService;
	
	@Autowired
	protected UserRepository userRepository;

	@GetMapping
	public Iterable<AddressEntity> getAllAddresses() {
		return addressService.findAllDao();
	}

	@PostMapping("/create")
	public AddressEntity createAddress(
			@RequestParam String street,
			@RequestParam String city,
			@RequestParam String country
		) {		

		return addressService.createAddressDao(street, city, country);
	}

	@PostMapping("/add")
	public AddressEntity addNewAddress(
			@RequestParam String street,
			@RequestParam String city,
			@RequestParam String country
		) {
		AddressEntity address = new AddressEntity();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		
		addressRepository.save(address);

		return address;
	}

	@DeleteMapping("/{id}")
	public AddressEntity deleteAddress(@PathVariable Integer id) {
		Optional<AddressEntity> addressOptional = addressRepository.findById(id);
		if (addressOptional.isPresent()) {
			AddressEntity address = addressOptional.get();
			
			addressRepository.delete(address);
			return address;
		} else {
			return null;
		}
	}

	@GetMapping("/by-city")
	public List<AddressEntity> getAddressByCity(@RequestParam String city) {
		return addressRepository.findByCity(city);
	}

	@GetMapping("/by-country")
	public List<AddressEntity> getAddressByCountry(@RequestParam String country) {
		return addressRepository.findByCountry(country);
	}

	@PutMapping("/{addressId}/user/{userId}")
	public AddressEntity addUserToAddress(
			@PathVariable Integer addressId, 
			@PathVariable Integer userId
		) {
		Optional<AddressEntity> addressOptional = addressRepository.findById(addressId);
		Optional<UserEntity> userOptional = userRepository.findById(userId);

		if (addressOptional.isPresent() && userOptional.isPresent()) {
			AddressEntity address = addressOptional.get();
			UserEntity user = userOptional.get();

			address.addUser(user);

			addressRepository.save(address);

			userRepository.save(user);

			return address;
		} else {
			return null;
		}
	}

	@DeleteMapping("/{addressId}/user/{userId}")
	public AddressEntity removeUserFromAddress(
			@PathVariable Integer addressId,
			@PathVariable Integer userId
		) {
		Optional<AddressEntity> addressOptional = addressRepository.findById(addressId);
		Optional<UserEntity> userOptional = userRepository.findById(userId);

		if (addressOptional.isPresent() && userOptional.isPresent()) {
			AddressEntity address = addressOptional.get();
			UserEntity user = userOptional.get();

			address.removeUser(user);

			userRepository.save(user);

			addressRepository.save(address);

			return address;
		} else {
			return null;
		}
	}
	
	@GetMapping("/user/{name}")
	public List<AddressEntity> findAddressForAUser(@PathVariable String name){
		return addressService.findAddressesByUserNameDao(name);
	}
}
