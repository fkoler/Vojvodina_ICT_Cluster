package com.iktobuka.validation_example.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.validation_example.entities.UserEntity;
import com.iktobuka.validation_example.entities.dto.UserDto;
import com.iktobuka.validation_example.repository.UserRepository;
import com.iktobuka.validation_example.utils.UserCustomValidator;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserCustomValidator userValidator;

	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@PostMapping
	public ResponseEntity<?> addNewUser(@Valid @RequestBody UserDto newUser, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
		} else {
			userValidator.validate(newUser, result);
		}
		UserEntity user = new UserEntity();

		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setUsername(newUser.getUsername());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
		user.setAge(newUser.getAge());

		userRepository.save(user);

		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}

	private String createErrorMessage(BindingResult result) {
		return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" "));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = "";
			String errorMessage = "";
			
			if (error instanceof FieldError) {
				fieldName = ((FieldError) error).getField();
				
				errorMessage = error.getDefaultMessage();
			} else if (error instanceof ObjectError) {
				fieldName = ((ObjectError) error).getObjectName();
				
				errorMessage = error.getDefaultMessage();
			}

			errors.put(fieldName, errorMessage);
		});

		return errors;
	}
}
