package com.iktobuka.homework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.homework.entities.UserAccountEntity;
import com.iktobuka.homework.entities.UserAccountEntityDTO;
import com.iktobuka.homework.entities.UserEntity;
import com.iktobuka.homework.services.UserAccountService;

@RestController
@RequestMapping("/api/v1/user-accounts")
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;

	@GetMapping
	public List<UserAccountEntity> getAllUserAccounts() {
		return (List<UserAccountEntity>) userAccountService.getAllUserAccounts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserAccountEntity> getById(
			@PathVariable Integer id
		) {
		UserAccountEntity userAccount = userAccountService
									   .getUserAccountById(id);
		
		if (userAccount != null) {
			return ResponseEntity.ok(userAccount);
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<UserAccountEntity> createUserAccount(
			@RequestBody UserAccountEntityDTO userAccountDTO
		) {
		UserAccountEntity userAccount = userAccountService
									   .createUserAccount(userAccountDTO);
		
		return ResponseEntity.ok(userAccount);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserAccountEntity> updateUserAccount(
			@PathVariable Integer id,
			@RequestBody UserAccountEntityDTO userAccountDTO
		) {
		UserAccountEntity userAccount = userAccountService
									   .updateUserAccount(id, userAccountDTO);
		
		if (userAccount != null) {
			return ResponseEntity.ok(userAccount);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserAccount(
			@PathVariable Integer id
		) {
		UserAccountEntity userAccount = userAccountService
									   .deleteUserAccount(id);
		
		if (userAccount != null) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/{userId}/addAccount")
	public ResponseEntity<UserEntity> addUserAccountToUser(
			@PathVariable Integer userId,
			@RequestBody UserAccountEntityDTO userAccountDTO
		) {
		UserEntity user = userAccountService
						 .addUserAccountToUser(userId, userAccountDTO);
		
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{userId}/removeAccount/{accountId}")
	public ResponseEntity<UserEntity> removeUserAccountFromUser(
			@PathVariable Integer userId,
			@PathVariable Integer accountId
		) {
		UserEntity user = userAccountService
						 .removeUserAccountFromUser(userId, accountId);
		
		if (user != null) {
			return ResponseEntity.ok(user);
		}
		
		return ResponseEntity.notFound().build();
	}
}
