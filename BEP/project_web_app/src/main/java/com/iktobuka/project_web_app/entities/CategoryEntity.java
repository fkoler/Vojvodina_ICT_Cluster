package com.iktobuka.project_web_app.entities;

public class CategoryEntity {

	private int id;
	private String categoryName;
	private String categoryDescription;

	public CategoryEntity() {
	}

	public CategoryEntity(
			int id, 
			String categoryName, 
			String categoryDescription
			) {
		this.setId(id);
		this.setCategoryName(categoryName);
		this.setCategoryDescription(categoryDescription);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
}
