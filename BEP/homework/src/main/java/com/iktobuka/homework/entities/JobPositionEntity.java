package com.iktobuka.homework.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class JobPositionEntity {
	
	public enum EmploymentLevel {
		DIRECTOR,
		LEADER,
		WORKER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@OneToMany(
			mappedBy = "jobPosition",
			cascade = CascadeType.REFRESH,
			fetch = FetchType.LAZY
		)
	private List<UserEntity> users;
	
	@Enumerated(EnumType.STRING)
	private EmploymentLevel employmentLevel;	

	public JobPositionEntity() {
	}

	public Integer getId() {
		return id;
	}

	public EmploymentLevel getEmploymentLevel() {
		return employmentLevel;
	}

	public void setEmploymentLevel(
			EmploymentLevel employmentLevel
		) {
		this.employmentLevel = employmentLevel;
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

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
}
