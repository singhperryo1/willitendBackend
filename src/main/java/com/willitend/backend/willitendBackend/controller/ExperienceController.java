package com.willitend.backend.willitendBackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.willitend.backend.willitendBackend.model.Experience;
import com.willitend.backend.willitendBackend.repository.ExperienceRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/experience")
public class ExperienceController {
	
	@Autowired
	ExperienceRepository experienceRepository; 
	
	@GetMapping("/getAll")
	public ResponseEntity<Map<String, Object>>  getAllExperience(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int size) {
		try {
			List<Experience> experiencePosts = new ArrayList<>();
			Pageable paging = PageRequest.of(page, size);
			
			Page<Experience> pageExps = experienceRepository.findAll(paging);
			
			experiencePosts = pageExps.getContent();
			
			Map<String, Object> response = new HashMap<>();
			
			response.put("exps", experiencePosts);
		    response.put("currentPage", pageExps.getNumber());
		    response.put("totalItems", pageExps.getTotalElements());
		    response.put("totalPages", pageExps.getTotalPages());
		    
		    return new ResponseEntity<>(response, HttpStatus.OK);
		    
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/createExp")
	public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
		try {
			Experience _exp = experienceRepository.save(new Experience(experience.getEmail(), experience.getDate(), experience.getUsername(), experience.getSite(), experience.getState(), experience.getTitle(), experience.getVaccExp())); 
			return new ResponseEntity<>(_exp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
}
