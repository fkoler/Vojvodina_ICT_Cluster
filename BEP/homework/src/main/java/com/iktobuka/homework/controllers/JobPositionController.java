package com.iktobuka.homework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.homework.entities.JobPositionEntity;
import com.iktobuka.homework.entities.JobPositionEntityDTO;
import com.iktobuka.homework.services.JobPositionService;

@RestController
@RequestMapping("/jobPositions")
public class JobPositionController {

	@Autowired
	private JobPositionService jobPositionService;

	@GetMapping
	public List<JobPositionEntity> getAll() {
		return (List<JobPositionEntity>) jobPositionService.getAllJobPositions();
	}

	@GetMapping("/{id}")
	public ResponseEntity<JobPositionEntity> getById(@PathVariable Integer id) {
		JobPositionEntity jobPosition = jobPositionService
									   .getJobPositionById(id);
		
		if (jobPosition != null) {
			return ResponseEntity.ok(jobPosition);
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<JobPositionEntity> create(
			@RequestBody JobPositionEntityDTO jobPositionDTO
		) {
		JobPositionEntity jobPosition = jobPositionService
									   .createJobPosition(jobPositionDTO);
		
		return ResponseEntity.ok(jobPosition);
	}

	@PutMapping("/{id}")
	public ResponseEntity<JobPositionEntity> update(
			@PathVariable Integer id,
			@RequestBody JobPositionEntityDTO jobPositionDTO
		) {
		JobPositionEntity jobPosition = jobPositionService
									   .updateJobPosition(id, jobPositionDTO);
		
		if (jobPosition != null) {
			return ResponseEntity.ok(jobPosition);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		JobPositionEntity jobPosition = jobPositionService.deleteJobPosition(id);
		
		if (jobPosition != null) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
