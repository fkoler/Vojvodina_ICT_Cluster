package com.iktobuka.data_access.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.data_access.entities.AddressEntity;
import com.iktobuka.data_access.entities.UserEntity;
import com.iktobuka.data_access.repositories.AddressRepository;
import com.iktobuka.data_access.repositories.UserRepository;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@GetMapping
	public Iterable<UserEntity> getUsers() {
		System.out.println("Operation getUsers successfully done");

		return userRepository.findAll();
	}

	@PostMapping
	public UserEntity addUser(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam LocalDate dateOfBirth,
			@RequestParam String phoneNumber, 
			@RequestParam String ssn,
			@RequestParam String idCardNumber
		) {
		UserEntity user = new UserEntity();
		user.setEmail(email);
		user.setName(name);
		user.setDateOfBirth(dateOfBirth);
		user.setPhoneNumber(phoneNumber);
		user.setSsn(ssn);
		user.setIdCardNumber(idCardNumber);

		userRepository.save(user);

		System.out.println("Operation addUser successfully done");

		return user;
	}

	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable Integer id) {
		UserEntity user = userRepository.findById(id).orElse(null);

		if (user != null) {
			System.out.println("Operation getUserById successfully done");

			return user;

		} else {
			System.out.println("Operation getUserById failed");

			return null;
		}
	}

	@PutMapping("/{id}")
	public UserEntity updateUser(
			@PathVariable Integer id,
			@RequestBody UserEntity updatedUser
		) {
		UserEntity existingUser = userRepository.findById(id).orElse(null);

		if (existingUser != null) {
			if (updatedUser.getName() != null) {
				existingUser.setName(updatedUser.getName());
			}
			if (updatedUser.getEmail() != null) {
				existingUser.setEmail(updatedUser.getEmail());
			}
			if (updatedUser.getComment() != null) {
				existingUser.setComment(updatedUser.getComment());
			}
			if (updatedUser.getDateOfBirth() != null) {
				existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
			}
			if (updatedUser.getPhoneNumber() != null) {
				existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
			}
			if (updatedUser.getSsn() != null) {
				existingUser.setSsn(updatedUser.getSsn());
			}
			if (updatedUser.getIdCardNumber() != null) {
				existingUser.setIdCardNumber(updatedUser.getIdCardNumber());
			}

			userRepository.save(existingUser);

			System.out.println("Operation updateUser successfully done");

			return existingUser;
		} else {
			System.out.println("Operation updateUser failed");

			return null;
		}
	}

	@DeleteMapping("/{id}")
	public UserEntity deleteUser(@PathVariable Integer id) {
		UserEntity userToDelete = userRepository.findById(id).orElse(null);

		if (userToDelete != null) {
			userRepository.deleteById(id);

			System.out.println("Operation deleteUser successfully done");

			return userToDelete;
		} else {
			System.out.println("Operation deleteUser failed");

			return null;
		}
	}

	@GetMapping("/by-email/{email}")
	public UserEntity getUserByEmail(@PathVariable String email) {
		UserEntity user = userRepository.findByEmail(email);

		if (user != null) {
			System.out.println("Operation getUserByEmail successfully done");

			return user;
		} else {
			System.out.println("Operation getUserByEmail failed");

			return null;
		}
	}

	@GetMapping("/by-name/{name}")
	public List<UserEntity> getUsersByName(@PathVariable String name) {
		List<UserEntity> users = userRepository.findByNameOrderByEmailAsc(name);

		if (!users.isEmpty()) {
			users.sort(Comparator.comparing(UserEntity::getEmail));

			System.out.println("Operation getUsersByName successfully done");

			return users;
		} else {
			System.out.println("Operation getUsersByName failed");

			return null;
		}
	}

	@GetMapping("/by-dob")
	public List<UserEntity> getUsersByDateOfBirth(@RequestParam LocalDate dateOfBirth) {
		List<UserEntity> users = userRepository.findByDateOfBirthOrderByNameAsc(dateOfBirth);

		if (!users.isEmpty()) {
			System.out.println("Operation getUsersByDateOfBirth successfully done");

			return users;
		} else {
			System.out.println("Operation getUsersByDateOfBirth failed");

			return new ArrayList<>();
		}
	}

	@GetMapping("/by-name-first-letter/{firstLetter}")
	public List<String> getUserNamesByFirstLetter(@PathVariable char firstLetter) {
		List<UserEntity> users = userRepository.findByNameStartingWithIgnoreCase(firstLetter);
		List<String> userNames = new ArrayList<>();

		if (!users.isEmpty()) {
			System.out.println("Operation getUserNamesByFirstLetter successfully done");

			for (UserEntity user : users) {
				userNames.add(user.getName());
			}

			return userNames;
		} else {
			System.out.println("Operation getUserNamesByFirstLetter failed");

			return new ArrayList<>();
		}
	}

	@PutMapping("/address/{id}")
	public UserEntity addAddressToUser(
			@PathVariable Integer id,
			@RequestParam String address
			) {
		UserEntity userDB = userRepository.findById(id).get();
		AddressEntity addressDB = addressRepository
				.findById(Integer.parseInt(address)).get();

		userDB.setAddress(addressDB);
		userRepository.save(userDB);

		return userDB;
	}

	@PutMapping("/remove-address/{id}")
	public UserEntity removeAddressFromUser(@PathVariable Integer id) {
		UserEntity user = userRepository.findById(id).orElse(null);

		if (user != null) {
			user.setAddress(null);
			userRepository.save(user);

			System.out.println("Operation removeAddressFromUser successfully done");

			return user;
		} else {
			System.out.println("Operation removeAddressFromUser failed: User not found");

			return null;
		}
	}

	@PostMapping("/createUserWithAddress")
	public UserEntity createUserWithAddress(
			@RequestParam String name, 
			@RequestParam String email,
			@RequestParam LocalDate dateOfBirth,
			@RequestParam String phoneNumber,
			@RequestParam String ssn,
			@RequestParam String idCardNumber,
			@RequestParam String street,
			@RequestParam String city,
			@RequestParam String country
		) {
		Optional<AddressEntity> optionalAddress = addressRepository
				.findByStreetAndCityAndCountry(street, city, country);
		AddressEntity address;

		if (optionalAddress.isPresent()) {
			address = optionalAddress.get();
		} else {
			address = new AddressEntity();
			
			address.setStreet(street);
			address.setCity(city);
			address.setCountry(country);

			addressRepository.save(address);
		}

		UserEntity user = new UserEntity();
		
		user.setName(name);
		user.setEmail(email);
		user.setDateOfBirth(dateOfBirth);
		user.setPhoneNumber(phoneNumber);
		user.setSsn(ssn);
		user.setIdCardNumber(idCardNumber);
		
		user.setAddress(address);
		
		userRepository.save(user);

		System.out.println("Operation createUserWithAddress successfully done");
		return user;
	}
}
