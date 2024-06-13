package com.iktobuka.homework.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktobuka.homework.entities.JobPositionEntity;
import com.iktobuka.homework.entities.JobPositionEntityDTO;
import com.iktobuka.homework.repository.JobPositionRepository;

@Service
public class JobPositionServiceImpl implements JobPositionService {

	@Autowired
	private JobPositionRepository jobPositionRepository;

	@Override
	public Iterable<JobPositionEntity> getAllJobPositions() {
		return jobPositionRepository.findAll();
	}

	@Override
	public JobPositionEntity getJobPositionById(Integer id) {
		return jobPositionRepository.findById(id).orElse(null);
	}

	@Override
	public JobPositionEntity createJobPosition(
			JobPositionEntityDTO jobPositionDTO
		) {
		JobPositionEntity jobPosition = new JobPositionEntity();
		jobPosition.setName(jobPositionDTO.getName());

		return jobPositionRepository.save(jobPosition);
	}

	@Override
	public JobPositionEntity updateJobPosition(
			Integer id, 
			JobPositionEntityDTO jobPositionDTO
		) {
		Optional<JobPositionEntity> optionalJobPosition = jobPositionRepository
														 .findById(id);
		
		if (optionalJobPosition.isPresent()) {
			JobPositionEntity jobPosition = optionalJobPosition.get();
			jobPosition.setName(jobPositionDTO.getName());

			return jobPositionRepository.save(jobPosition);
		}
		
		return null;
	}

	@Override
	public JobPositionEntity deleteJobPosition(Integer id) {
		Optional<JobPositionEntity> optionalJobPosition = jobPositionRepository
														 .findById(id);
		
		if (optionalJobPosition.isPresent()) {
			JobPositionEntity jobPosition = optionalJobPosition.get();
			jobPositionRepository.delete(jobPosition);
			
			return jobPosition;
		}
		
		return null;
	}
}
