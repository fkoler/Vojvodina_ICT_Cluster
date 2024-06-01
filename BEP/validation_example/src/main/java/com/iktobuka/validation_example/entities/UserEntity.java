package com.iktobuka.validation_example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	protected Integer id;

	@NotNull(message = "First name must be provided")
	@Size(min = 2, max = 30, message = "First name must be between {min} and {max}")
	protected String firstName;

	@NotNull(message = "Last name must be provided")
	@Size(min = 2, max = 30, message = "Last name must be between {min} and {max}")
	protected String lastName;

	@NotNull(message = "Email name must be provided")
	@Email
	protected String email;

	@NotNull(message = "Username must be provided")
	@Size(min = 5, max = 15, message = "Username must be between {min} and {max}")
	protected String username;

	@NotNull(message = "Password must be provided")
	@Size(min = 5, max = 10, message = "Password must be between {min} and {max}")
	protected String password;

	@NotNull(message = "Age must be provided")
	@Min(value = 5, message = "Age must be {min}")
	protected Integer age;

	public UserEntity() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
