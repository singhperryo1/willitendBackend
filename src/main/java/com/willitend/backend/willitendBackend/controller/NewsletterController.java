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

import com.willitend.backend.willitendBackend.model.User;
import com.willitend.backend.willitendBackend.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/NewsLetter")
public class NewsLetterController {
	
	@Autowired
	UserRepository nlRepository; 
	
	@GetMapping("/getNesLetter")
	public ResponseEntity<NewsLetter> getNewsLetter(@PathVariable("email") String email) {
		try {
			NewLetter nl = userRepository.findByUsername(email); 
			
			if (user == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); 
			}

			return new ResponseEntity<>(nl, HttpStatus.OK); 
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getAllNewsLetter")
	public ResponseEntity<List<NewsLetter>> getAllNewsLetter() {
		try {
			List<NewsLetter> NewsLetter = new ArrayList<>(); 
			
			stateinfoRepository.findAll().forEach(NewsLetter::add);
			
			if (NewsLetter.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			
			return new ResponseEntity<>(NewsLetter, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/creatNewsLetter")
	public ResponseEntity<NewsLetter> creatNewsLetter(@RequestBody NewsLetter nl) {
		try {
			NewsLetter nl = nlRepository.save(new NewsLetter(nl.getUserEmail(),nl.getUserState()));
			return new ResponseEntity<>(nl,  HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
}
