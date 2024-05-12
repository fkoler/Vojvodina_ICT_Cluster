package com.iktobuka.project_web_app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.iktobuka.project_web_app.entities.CategoryEntity;

@RestController
@RequestMapping(value = "/project/categories")
public class CategoryController {
	public List<CategoryEntity> getDB() {
		List<CategoryEntity> categories = new ArrayList<>();

		categories.add(new CategoryEntity(1, "Drums", "Wide selection of drum kits and percussion instruments"));
		categories.add(new CategoryEntity(2, "Amplifiers", "Powerful amplifiers for your musical needs"));
		categories.add(new CategoryEntity(3, "Keyboards", "Explore our range of keyboards and e-pianos"));
		categories
				.add(new CategoryEntity(4, "Microphones", "Professional microphones for studio and live performances"));
		categories.add(new CategoryEntity(5, "Effects Pedals", "Enhance your sound with our effects pedals"));
		categories.add(new CategoryEntity(6, "Studio Equipment", "Everything you need to set up your home studio"));
		categories.add(new CategoryEntity(7, "Stage Lighting", "Illuminate your stage with our lighting solutions"));
		categories.add(new CategoryEntity(8, "Concert Tickets", "Get your tickets for upcoming concerts and live events"));
		categories.add(new CategoryEntity(9, "Software", "Discover software for music production and recording"));
		categories
				.add(new CategoryEntity(10, "Books & Media", "Explore books and media related to music and musicians"));
		categories.add(new CategoryEntity(11, "Acoustic Guitars", "Discover the warm tones of acoustic guitars"));
		categories.add(new CategoryEntity(12, "Electric Guitars",
				"Explore our collection of electric guitars for every style"));
		categories.add(new CategoryEntity(13, "Bass Guitars", "Find the perfect bass guitar to lay down the groove"));
		categories.add(new CategoryEntity(14, "Synthesizers",
				"Create unique sounds with our synthesizers and MIDI keyboards"));
		categories.add(
				new CategoryEntity(15, "DJ Equipment", "Get the party started with our DJ controllers and mixers"));
		categories.add(
				new CategoryEntity(16, "Recording Equipment", "Capture your music with professional recording gear"));
		categories
				.add(new CategoryEntity(17, "Live Sound", "Equip your venue with top-quality PA systems and speakers"));
		categories.add(
				new CategoryEntity(18, "Music Accessories", "Find essential accessories for musicians and performers"));
		categories.add(
				new CategoryEntity(19, "Sheet Music", "Explore sheet music for a variety of instruments and genres"));
		categories.add(new CategoryEntity(20, "Music Lessons",
				"Take your skills to the next level with expert music lessons"));

		return categories;
	}

	List<CategoryEntity> categories = getDB();

	@GetMapping("/")
	public List<CategoryEntity> getCategories() {
		return categories;
	}

	@PostMapping("/")
	public CategoryEntity addCategory(@RequestBody CategoryEntity category) {
		return category;
	}

	private CategoryEntity findCategoryById(int id) {
		for (CategoryEntity category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		System.out.println("No category with id " + id);

		return null;
	}

	@PutMapping("/{id}")
	public CategoryEntity updateCategory(@PathVariable int id, @RequestBody CategoryEntity updatedCategory) {
		CategoryEntity existingCategory = findCategoryById(id);

		if (existingCategory == null) {
			return null;
		}

		existingCategory.setCategoryName(updatedCategory.getCategoryName());
		existingCategory.setCategoryDescription(updatedCategory.getCategoryDescription());

		return existingCategory;
	}

	@DeleteMapping("/{id}")
	public CategoryEntity deleteCategory(@PathVariable int id) {
		CategoryEntity categoryToDelete = findCategoryById(id);

		if (categoryToDelete != null) {
			categories.remove(categoryToDelete);
		}
		System.out.println(categoryToDelete.getCategoryName() + " successfully deleted");

		return categoryToDelete;
	}

	@GetMapping("/{id}")
	public CategoryEntity getCategoryById(@PathVariable int id) {
		CategoryEntity category = findCategoryById(id);

		if (category != null) {
			return category;
		}

		return null;
	}
}
