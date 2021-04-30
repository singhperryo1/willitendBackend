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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository; 
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserInfo(@PathVariable("username") String username) {
		try {
			User user = userRepository.findByUsername(username); 
			
			if (user == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); 
			}

			return new ResponseEntity<>(user, HttpStatus.OK); 
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			User _user = userRepository.save(new User(user.getEmail(), user.getState(), user.getPassword(), user.getUsername()));
			return new ResponseEntity<>(_user,  HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
}
