package com.iktobuka.homework.entities;

import com.iktobuka.homework.entities.JobPositionEntity.EmploymentLevel;

public class JobPositionEntityDTO {

	private Integer id;
	private String name;
	private EmploymentLevel employmentLevel;

	public EmploymentLevel getEmploymentLevel() {
		return employmentLevel;
	}

	public void setEmploymentLevel(
			EmploymentLevel employmentLevel
		) {
		this.employmentLevel = employmentLevel;
	}

	public JobPositionEntityDTO() {
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
}
