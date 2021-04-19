package com.willitend.backend.willitendBackend;

import com.willitend.backend.willitendBackend.User;
import com.willitend.backend.willitendBackend.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String email) {
	    
		try {
			List<User> users = new ArrayList<User>();
			
			if (email == null)
				userRepository.findAll().forEach(users::add);
			else
				userRepository.findByTitleContaining(email).forEach(users::add); // findByEmailContaining or findByTitleContaining
			
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(users, HttpStatus.OK);
			}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	  }
	
	
	@GetMapping("/users/{email}")
	public ResponseEntity<User> getUserById(@PathVariable("email") String email){  // getUserByState 0r getUserById
		Optional<User> userData = userRepository.findById(email);
		
		if(userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			User _user = userRepository
				.save(new User (user.getEmail(),user.getState(),user.getPassword(), user.getUsername() ));
			return new ResponseEntity<> (_user, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/users/{email}")
	public ResponseEntity<User> updateUser (@PathVariable("email") String email, @RequestBody User user){
		Optional<User> userData = userRepository.findByID(email);
		
		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setPassword(user.getPassword());
			_user.setState(user.getState());
			_user.setUsername(user.getUsername());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);		
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/users/{email}")
	public ResponseEntity<HttpStatus> deleteUser (@PathVariable("email") String email){
		try {
			userRepository.deleteById(email);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/users")
	public ResponseEntity<HttpStatus> deleteAllusers(){
		try {
		      userRepository.deleteAll();
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("/user/state")
	  public ResponseEntity<List<User>> findByState() {
	    try {
	      List<User> users = userRepository.findByState("state");

	      if (users.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/user/username")
	  public ResponseEntity<List<User>> findByUsername() {
	    try {
	      List<User> users = userRepository.findByState("username");

	      if (users.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	@GettMapping("/user/password") //Not too sure of this
	
	
	

}
