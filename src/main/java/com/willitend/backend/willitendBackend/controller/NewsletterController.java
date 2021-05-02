package com.willitend.backend.willitendBackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willitend.backend.willitendBackend.model.Newsletter;
import com.willitend.backend.willitendBackend.repository.NewsletterRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/newsletter")
public class NewsletterController {
	
	@Autowired
	NewsletterRepository nlRepository; 
	
	@GetMapping("/{email}")
	public ResponseEntity<Newsletter> getNewsLetter(@PathVariable("email") String email) {
		try {
			Newsletter nl = nlRepository.findByEmail(email); 
			
			if (nl == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); 
			}

			return new ResponseEntity<>(nl, HttpStatus.OK); 
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<Newsletter> createNewsLetter(@RequestBody Newsletter nl) {
		try {
			Newsletter _nl = nlRepository.save(new Newsletter(nl.getEmail(),nl.getState()));
			return new ResponseEntity<>(_nl,  HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
}
