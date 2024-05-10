package com.iktobuka.homework_1.entities;

import java.time.LocalDate;

public class BankClientEntity {
	protected Integer id;
	protected String name;
	protected String surname;
	protected String email;
	protected LocalDate dateOfBirth;
    protected char creditRating;
    protected String city;
	
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public char getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(char creditRating) {
		this.creditRating = creditRating;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public BankClientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankClientEntity(
			Integer id, 
			String name, 
			String surname, 
			String email
		) {
		super();

		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
	}
	
	public BankClientEntity(
			Integer id, 
			String name, 
			String surname, 
			String email, 
			LocalDate dateOfBirth
		) {
		super();

		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
		this.setDateOfBirth(dateOfBirth);
	}
	
	public BankClientEntity(
			Integer id, 
			String name, 
			String surname, 
			String email, 
			LocalDate dateOfBirth, 
			char creditRating
		) {
		super();

		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
		this.setDateOfBirth(dateOfBirth);
		this.setCreditRating(creditRating);
	}
	
	public BankClientEntity(
			Integer id, 
			String name, 
			String surname, 
			String email, 
			LocalDate dateOfBirth,
			String city
		) {
		super();

		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
		this.setDateOfBirth(dateOfBirth);
		this.setCity(city);
	}
}
