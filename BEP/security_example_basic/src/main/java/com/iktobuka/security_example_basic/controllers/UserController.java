package com.iktobuka.security_example_basic.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.security_example_basic.entities.RoleEntity;
import com.iktobuka.security_example_basic.entities.UserEntity;

@RestController
public class UserController {

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/users")
	public ResponseEntity<?> listUsers() {
		return new ResponseEntity<List<UserEntity>>(getDummyDB(), HttpStatus.OK);
	}

	public List<UserEntity> getDummyDB() {
		List<UserEntity> list = new ArrayList<>();

		RoleEntity re = new RoleEntity();
		re.setId(1);
		re.setName("admin");

		UserEntity ue = new UserEntity();
		ue.setId(1);
		ue.setEmail("user@example.com");
		ue.setName("Vladimir");
		ue.setLastName("Dimitrieski");
		ue.setPassword("password1234");
		ue.setRole(re);

		UserEntity ue1 = new UserEntity();
		ue1.setId(2);
		ue1.setEmail("user2@example.com");
		ue1.setName("Milan");
		ue1.setLastName("Celikovic");
		ue1.setPassword("password4321");
		ue1.setRole(re);

		list.add(ue);
		list.add(ue1);

		return list;
	}
}
