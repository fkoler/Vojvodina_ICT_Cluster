package com.iktobuka.data_access.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@Column(nullable = false)
	protected String name;

	@Column(nullable = false, unique = true)
	protected String email;

	@Column(nullable = true)
	protected String comment;

	@Column(nullable = true)
	protected LocalDate dateOfBirth;

	@Column(nullable = true, unique = true, length = 15)
	protected String phoneNumber;

	@Column(nullable = true, unique = true, length = 9)
	protected String ssn;

	@Column(nullable = true, unique = true, length = 10)
	protected String idCardNumber;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "address")
	protected AddressEntity address;

	public UserEntity() {
	}

	public UserEntity(Integer id, String name, String email, LocalDate dateOfBirth, String phoneNumber, String ssn,
			String idCardNumber) {
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setDateOfBirth(dateOfBirth);
		this.setPhoneNumber(phoneNumber);
		this.setSsn(ssn);
		this.setIdCardNumber(idCardNumber);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
}
