package com.iktobuka.homework.repository;

import org.springframework.data.repository.CrudRepository;

import com.iktobuka.homework.entities.JobPositionEntity;

public interface JobPositionRepository extends CrudRepository<JobPositionEntity, Integer> {
}
