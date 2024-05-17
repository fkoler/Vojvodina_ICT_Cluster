package com.iktobuka.data_access.controllers;

import java.util.Comparator;
import java.util.List;

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

import com.iktobuka.data_access.entities.UserEntity;
import com.iktobuka.data_access.repositories.UserRepository;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public Iterable<UserEntity> getUsers() {
		System.out.println("Operation getUsers successfully done");
		return userRepository.findAll();
	}

	@PostMapping
	public UserEntity addUser(@RequestParam String name, @RequestParam String email) {
		UserEntity user = new UserEntity();
		user.setEmail(email);
		user.setName(name);
		userRepository.save(user);

		System.out.println("Operation addUser successfully done");
		return user;
	}

	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable Integer id) {
		UserEntity user = userRepository.findById(id).orElse(null);

		if (user != null && user.getId() == id) {
			System.out.println("Operation getUserById successfully done");

			return user;

		} else {
			System.out.println("Operation getUserById failed");

			return null;
		}
	}

	@PutMapping("/{id}")
	public UserEntity updateUser(@PathVariable Integer id, @RequestBody UserEntity updatedUser) {
		UserEntity existingUser = userRepository.findById(id).orElse(null);

		if (existingUser != null && existingUser.getId() == id) {
			existingUser.setName(updatedUser.getName());
			existingUser.setEmail(updatedUser.getEmail());
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

		if (userToDelete != null && userToDelete.getId() == id) {
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
}
