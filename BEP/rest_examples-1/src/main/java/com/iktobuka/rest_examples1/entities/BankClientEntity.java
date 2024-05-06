package com.iktobuka.rest_examples1.entities;

public class BankClientEntity {
	protected Integer id;
	protected String name;
	protected String surname;
	protected String email;

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

	public BankClientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankClientEntity(Integer id, String name, String surname, String email) {
		super();
		
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
	}
}
