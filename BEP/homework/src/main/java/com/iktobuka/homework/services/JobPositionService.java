package com.iktobuka.homework.services;

import com.iktobuka.homework.entities.JobPositionEntity;
import com.iktobuka.homework.entities.JobPositionEntityDTO;

public interface JobPositionService {

	Iterable<JobPositionEntity> getAllJobPositions();

	JobPositionEntity getJobPositionById(Integer id);

	JobPositionEntity createJobPosition(JobPositionEntityDTO jobPositionDTO);

	JobPositionEntity updateJobPosition(
			Integer id, 
			JobPositionEntityDTO jobPositionDTO
		);

	JobPositionEntity deleteJobPosition(Integer id);
}
