package com.willitend.backend.willitendBackend;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class UserTest {
	


	  @Test
	  void testUserVariables() {
	    User user = new User("deco2@mail.com", "MI", "", "deco2" ); //String email, String state, String password, String username
	    assertEquals(user.getState(), "MI");
	    assertEquals(user.getEmail(), "dickson@yahoo.com");
	  }

	
	
//	  @Service
//	  public class RegisterUseCase {
//
//	    private final UserRepository userRepository;
//
//	    public RegisterUseCase(UserRepository userRepository) {
//	      this.userRepository = userRepository;
//	    }
//
//	    public User registerUser(User user) {
//	      return userRepository.save(user);
//	    }
//
//	  }
	

}
