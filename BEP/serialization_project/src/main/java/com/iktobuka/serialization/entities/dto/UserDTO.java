package com.iktobuka.serialization.entities.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktobuka.serialization.entities.AddressEntity;
import com.iktobuka.serialization.security.Views;

public class UserDTO {
	
	@JsonView(Views.Public.class)
	@JsonProperty("ID")
	private Integer id;

	@JsonView(Views.Public.class)
	private String name;

	@JsonView(Views.Admin.class)
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = "dd-MMM-yyyy"
		)
	private LocalDate dateOfBirth;

	@JsonView(Views.Admin.class)
	private String email;

	@JsonView(Views.Admin.class)
	private String password;

	@JsonView(Views.Admin.class)
	private Integer version;

	@JsonView(Views.Private.class)
	@JsonManagedReference
	private AddressEntity address;

	public UserDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
}
