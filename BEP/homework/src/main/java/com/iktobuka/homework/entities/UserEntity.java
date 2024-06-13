package com.iktobuka.homework.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iktobuka.homework.security.Views;
import com.iktobuka.homework.util.LocalDateDeserializer;
import com.iktobuka.homework.util.LocalDateSerializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.LeaderView.class)
	protected Integer id;

	@Column(nullable = false)
	@JsonView(Views.WorkerView.class)
	protected String name;

	@Column(nullable = false, unique = true)
	@JsonView(Views.LeaderView.class)
	protected String email;

	@Column(nullable = true)
	@JsonView(Views.WorkerView.class)
	protected String comment;

	@Column(nullable = true)
	@JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonView(Views.LeaderView.class)
	protected LocalDate dateOfBirth;

	@Column(nullable = true, unique = true, length = 15)
	@JsonView(Views.LeaderView.class)
	protected String phoneNumber;

	@Column(nullable = true, unique = true, length = 9)
	@JsonView(Views.DirectoryView.class)
	protected String ssn;

	@Column(nullable = true, unique = true, length = 10)
	@JsonView(Views.DirectoryView.class)
	protected String idCardNumber;

	@ManyToOne(
			cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY
		)
	@JoinColumn(name = "address")
	@JsonView(Views.DirectoryView.class)
	protected AddressEntity address;
	
	@ManyToOne(
			cascade = CascadeType.REFRESH,
			fetch = FetchType.LAZY
		)
	@JoinColumn(name = "job_position_id")
	@JsonView(Views.LeaderView.class)
	protected JobPositionEntity jobPosition;

	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY
		)
	@JsonIgnore
	@JsonView(Views.DirectoryView.class)
	protected List<UserAccountEntity> userAccounts = new ArrayList<>();

	public UserEntity() {
	}

	public UserEntity(
			Integer id,
			String name,
			String email, 
			LocalDate dateOfBirth,
			String phoneNumber,
			String ssn,
			String idCardNumber,
			List<UserAccountEntity> userAccounts,
			JobPositionEntity jobPosition
		) {
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setDateOfBirth(dateOfBirth);
		this.setPhoneNumber(phoneNumber);
		this.setSsn(ssn);
		this.setIdCardNumber(idCardNumber);
		this.setUserAccounts(userAccounts);
		this.setJobPosition(jobPosition);
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

	public List<UserAccountEntity> getUserAccounts() {
		return userAccounts;
	}
	
	public JobPositionEntity getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPositionEntity jobPosition) {
        this.jobPosition = jobPosition;
    }

	public void setUserAccounts(List<UserAccountEntity> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public void addUserAccount(UserAccountEntity userAccount) {
		if (
				userAccount != null &&
				!userAccounts.contains(userAccount)
			) {
			userAccounts.add(userAccount);
			userAccount.setUser(this);
		}
	}

	public void removeUserAccount(UserAccountEntity userAccount) {
		if (
				userAccount != null &&
				userAccounts.contains(userAccount)
			) {
			userAccounts.remove(userAccount);
			userAccount.setUser(null);
		}
	}
}
