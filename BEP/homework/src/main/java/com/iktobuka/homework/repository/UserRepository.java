package com.iktobuka.homework.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iktobuka.homework.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	UserEntity findByEmail(String email);

	List<UserEntity> findByNameOrderByEmailAsc(String name);

	List<UserEntity> findByDateOfBirthOrderByNameAsc(LocalDate dateOfBirth);

	@Query("SELECT u FROM UserEntity u WHERE LOWER(u.name) LIKE LOWER(CONCAT(:firstLetter, '%'))")
	List<UserEntity> findByNameStartingWithIgnoreCase(
			@Param("firstLetter") char firstLetter
		);
}
