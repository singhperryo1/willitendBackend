package com.willitend.backend.willitendBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willitend.backend.willitendBackend.model.Newsletter;
import com.willitend.backend.willitendBackend.repository.NewsletterRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/newsletter")
public class NewsletterController {
	
	@Autowired 
	NewsletterRepository newsletterRepository; 
	
	@PostMapping ("/create")
	public ResponseEntity<Newsletter> createNewsletter (@RequestBody Newsletter newsletter) {
		try {
			Newsletter _newsletter = newsletterRepository.save(new Newsletter(newsletter.getEmail(), newsletter.getState()));
			return new ResponseEntity<>(null, HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
}
