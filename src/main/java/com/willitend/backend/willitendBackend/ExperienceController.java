package com.willitend.backend.willitendBackend;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ExperienceController {
	@Autowired
	ExperienceRepository experienceRepository;
	
	// Return List of Experience instances
	@GetMapping("/experiences")
	public ResponseEntity<List<Experience>> getAllExperiences() {
		List<Experience> experiences = experienceRepository.findAll();
		if (experiences.isEmpty())
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<>(experiences, HttpStatus.CREATED);
	}
	
	// Creates Experience instance
	@PostMapping("/experiences")
	public ResponseEntity<Experience> createExperience(@RequestBody Experience experience){
		try {
			Experience _experience = experienceRepository.save(new Experience(experience.getDate(), 
					experience.getEmail(), experience.getUserName(), experience.getPassword(), 
					experience.getSite(), experience.getTitle(), experience.getVaccExp()));
			return new ResponseEntity<>(_experience, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
