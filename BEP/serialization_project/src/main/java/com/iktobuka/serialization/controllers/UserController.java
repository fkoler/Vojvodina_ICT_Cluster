package com.iktobuka.serialization.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktobuka.serialization.entities.AddressEntity;
import com.iktobuka.serialization.entities.UserEntity;
import com.iktobuka.serialization.security.Views;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	public List<UserEntity> getDummyDB() {
		List<UserEntity> list = new ArrayList<>();

		AddressEntity addr1 = new AddressEntity();
		addr1.setId(1);
		addr1.setStreet("123 Main St");
		addr1.setCity("New York");
		addr1.setCountry("USA");
		addr1.setVersion(1);

		AddressEntity addr2 = new AddressEntity();
		addr2.setId(2);
		addr2.setStreet("456 Maple Ave");
		addr2.setCity("Los Angeles");
		addr2.setCountry("USA");
		addr2.setVersion(1);

		UserEntity ue1 = new UserEntity();
		ue1.setId(1);
		ue1.setDateOfBirth(LocalDate.of(1990, 1, 1));
		ue1.setEmail("john.doe@example.com");
		ue1.setName("John Doe");
		ue1.setPassword("password1234");
		ue1.setVersion(0);
		ue1.setAddress(addr1);

		UserEntity ue2 = new UserEntity();
		ue2.setId(2);
		ue2.setDateOfBirth(LocalDate.of(1985, 6, 15));
		ue2.setEmail("jane.doe@example.com");
		ue2.setName("Jane Doe");
		ue2.setPassword("password4321");
		ue2.setVersion(0);
		ue2.setAddress(addr1);

		UserEntity ue3 = new UserEntity();
		ue3.setId(3);
		ue3.setDateOfBirth(LocalDate.of(1992, 3, 10));
		ue3.setEmail("jim.beam@example.com");
		ue3.setName("Jim Beam");
		ue3.setPassword("password5678");
		ue3.setVersion(0);
		ue3.setAddress(addr2);

		addr1.setUsers(new ArrayList<>());
		addr1.getUsers().add(ue1);
		addr1.getUsers().add(ue2);

		addr2.setUsers(new ArrayList<>());
		addr2.getUsers().add(ue3);

		list.add(ue1);
		list.add(ue2);
		list.add(ue3);

		return list;
	}

	@GetMapping("/public")
	@JsonView(Views.Public.class)
	public List<UserEntity> getAllUsersPublic() {
		return getDummyDB();
	}

	@GetMapping("/private")
	@JsonView(Views.Private.class)
	public List<UserEntity> getAllUsersPrivate() {
		return getDummyDB();
	}

	@GetMapping("/admin")
	@JsonView(Views.Admin.class)
	public List<UserEntity> getAllUsersAdmin() {
		return getDummyDB();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
		try {
			for (UserEntity ue : getDummyDB()) {
				if (ue.getId() == id) {
					return new ResponseEntity<UserEntity>(ue, HttpStatus.OK);
				}
			}

			return new ResponseEntity<String>(
					"User not found", 
					HttpStatus.NOT_FOUND
			);
		} catch (Exception e) {
			return new ResponseEntity<String>(
					e.getCause().getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR
			);
		}
	}
}
