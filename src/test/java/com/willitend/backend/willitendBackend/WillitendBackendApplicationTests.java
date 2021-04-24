package com.willitend.backend.willitendBackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.willitend.backend.willitendBackend.model.User;

public class WillitendBackendApplicationTests extends AbstractTest {
	
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getUserInfo() throws Exception {
		String uri = "/user/singh";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
				
	   int status = mvcResult.getResponse().getStatus(); 		
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   User user = super.mapFromJson(content, User.class); 
	   assertEquals(user.getEmail(), "g@sikh.com"); 
	   assertEquals(user.getState(), "CA");
	   assertEquals(user.getPassword(), "akaal");
	   assertEquals(user.getUsername(), "singh");
	}
	
	@Test
	public void createUser() throws Exception {
		String uri = "/user/create"; 
		User user = new User();
		user.setUsername("Akaal Singh");
		user.setEmail("ustat@akaal.com");
		user.setState("KA");
		user.setPassword("Panjab");
		   
		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		User userCreated = super.mapFromJson(content, User.class); 
		assertEquals(userCreated.getUsername(), user.getUsername()); 
		assertEquals(userCreated.getEmail(), user.getEmail()); 
		assertEquals(userCreated.getState(), user.getState()); 
		assertEquals(userCreated.getPassword(), user.getPassword());	
	}
	
}
