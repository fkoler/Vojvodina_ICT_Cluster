package com.iktobuka.homework.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iktobuka.homework.util.LocalDateDeserializer;
import com.iktobuka.homework.util.LocalDateSerializer;

public class UserEntityDTO {

	private Integer id;
	private String name;
	private String email;
	private String comment;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dateOfBirth;

	private String phoneNumber;
	private String ssn;
	private String idCardNumber;
	private Integer addressId;
	private List<Integer> userAccountIds;
	private Integer jobPositionId;

	public UserEntityDTO() {
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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public List<Integer> getUserAccountIds() {
		return userAccountIds;
	}

	public void setUserAccountIds(List<Integer> userAccountIds) {
		this.userAccountIds = userAccountIds;
	}
	
	public Integer getJobPositionId() {
        return jobPositionId;
    }

    public void setJobPositionId(Integer jobPositionId) {
        this.jobPositionId = jobPositionId;
    }
}
