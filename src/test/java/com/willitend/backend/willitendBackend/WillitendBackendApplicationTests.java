package com.willitend.backend.willitendBackend;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.willitend.backend.willitendBackend.model.User;

import junit.framework.Assert;

import com.willitend.backend.willitendBackend.model.Experience;

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
	
	@Test
	public void getAllExperience() throws Exception{
		String uri = "/exp/getAll";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		// Get status from mvcResult and assert equality to expected status
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		// Get contents of getAllExperience return from server as a string
		String content = mvcResult.getResponse().getContentAsString();

		// Instantiate contents as HashMap<String = key, Object = value>
		HashMap<String, Object> response = super.mapFromJson(content, HashMap.class);
		// Instantiate exps-value of response as ArrayList of LinkedHashMaps with String = key and Object = value
		ArrayList<LinkedHashMap<String, Object>> respExp = (ArrayList<LinkedHashMap<String, Object>>) response.get("exps");

		/* Use assert to check totalPages and totalItems */ 
		int pages = (int) response.get("totalPages"), items = (int) response.get("totalItems"); 
		
		assertTrue(pages > 0); 
		assertTrue(items > 0); 
		/* Use assertTrue as the values in db always change */ 
		assertTrue(!respExp.isEmpty());
	}
	
	@Test
	public void createExperience() throws Exception{
		String uri = "/exp/create";

		// Test Fields
		Date testDate = Date.valueOf("2021-04-25");
		String testEmail = "user@willitend.com";
		String testUsername = "testuser";
		String testSite = "Roseville, CA";
		String testTitle = "My Vaccine Experience";
		String testState = "CA";
		String testVaccExp = "I didn't really feel any signifigant health anomalies follwing the first "
				+ "innouculation, however I definetly felt exhausted and a bit under the weather following "
				+ "the second."; 

		// Test Experience Instance
		Experience experience = new Experience(testEmail, testDate, testUsername, testSite, testState, testTitle, testVaccExp);

		// Upload Test Experience to server and return it
		String inputJson = super.mapToJson(experience);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		// Get status from mvcResult and assure equality to expected status
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		// Instantiate content of mvcResult's response as a String instance
		String content = mvcResult.getResponse().getContentAsString();
		// Use String content to instantiate new Experience instance and assure equality
		// to fields of previous experience instance that was uploaded
		Experience experienceCreated = super.mapFromJson(content, Experience.class);
		assertEquals(experienceCreated.getEmail(), experience.getEmail());
		assertEquals(experienceCreated.getDate(), experience.getDate());
		assertEquals(experienceCreated.getUsername(), experience.getUsername());
		assertEquals(experienceCreated.getSite(), experience.getSite());
		assertEquals(experienceCreated.getState(), experience.getState());
		assertEquals(experienceCreated.getTitle(), experience.getTitle());
		assertEquals(experienceCreated.getVaccExp(), experience.getVaccExp());
	}
}
