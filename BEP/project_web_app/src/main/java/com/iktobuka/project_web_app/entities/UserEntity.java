package com.iktobuka.project_web_app.entities;

public class UserEntity {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private UserRole userRole;

	public enum UserRole {
		ROLE_CUSTOMER, ROLE_ADMIN, ROLE_SELLER
	}

	public UserEntity() {
	}

	public UserEntity(int id, String firstName, String lastName, String username, String password, String email,
			UserRole userRole) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setUserRole(userRole);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
}
