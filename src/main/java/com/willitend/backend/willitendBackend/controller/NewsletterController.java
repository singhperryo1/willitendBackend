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

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/newsletter")
public class NewsletterController {
	
	@Autowired 
	NewsletterRepository newsletterRepository; 
	
	@GetMapping("/{email}")
	public ResponseEntity<Newsletter> getNewsletter(@PathVariable("email") String email) {
		try {
			Newsletter newsletter = newsletterRepository.findByEmail(email); 
			
			if (newsletter == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); 
			}

			return new ResponseEntity<>(newsletter, HttpStatus.OK); 
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping ("/create")
	public ResponseEntity<Newsletter> createNewsletter (@RequestBody Newsletter newsletter) {
		try {
			Newsletter _newsletter = newsletterRepository.save(new Newsletter(newsletter.getEmail(), newsletter.getState()));
			return new ResponseEntity<>(_newsletter, HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
}
