package com.willitend.backend.willitendBackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.willitend.backend.willitendBackend.model.User;
import com.willitend.backend.willitendBackend.model.Experience;
import com.willitend.backend.willitendBackend.model.Newsletter;

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
	   System.out.println(content);
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
		
		// Instantiate new experience instance using first value's fields in respExp ArrayList
		Experience respExp1 = new Experience();
		respExp1.setDate((String) respExp.get(0).get("date"));
		respExp1.setEmail((String) respExp.get(0).get("email"));
		respExp1.setUsername((String) respExp.get(0).get("username"));
		respExp1.setSite((String) respExp.get(0).get("site"));
		respExp1.setState((String) respExp.get(0).get("state"));
		respExp1.setTitle((String) respExp.get(0).get("title"));
		respExp1.setVaccExp((String) respExp.get(0).get("vaccExp"));
		
		// assert Equality to fields of respExp1 and response
		assertEquals("test@mail.com", respExp1.getEmail());
		assertEquals(Date.valueOf("2021-04-25"), respExp1.getDate());
		assertEquals("testuser", respExp1.getUsername());
		assertEquals("Placer County", respExp1.getSite());
		assertEquals("My Experience", respExp1.getTitle());
		assertEquals("This is what happened", respExp1.getVaccExp());
		assertEquals("CA", respExp1.getState());
		assertEquals(0, response.get("currentPage"));
		assertEquals(2, response.get("totalItems"));
		assertEquals(1, response.get("totalPages"));
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
		assertEquals(201, status);
		
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
	
	@Test
	public void getNewsletter() throws Exception {
		String uri = "/newsletter/g@sikh.com";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
				
	   int status = mvcResult.getResponse().getStatus(); 		
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   System.out.print(content);
	   Newsletter nl = super.mapFromJson(content, Newsletter.class); 
	   assertEquals(nl.getEmail(), "g@sikh.com"); 
	   assertEquals(nl.getState(), "CA");
	}
	
	@Test
	public void createNewsLetter() throws Exception {
		String uri = "/newsletter/create"; 
		Newsletter nl = new Newsletter("li_hing@student.smc.edu","CA");
		String inputJson = super.mapToJson(nl);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		Newsletter getFromMVC = super.mapFromJson(content, Newsletter.class); 
		assertEquals(getFromMVC.getState(), nl.getState()); 
		assertEquals(getFromMVC.getEmail(), nl.getEmail()); 
	}

}
