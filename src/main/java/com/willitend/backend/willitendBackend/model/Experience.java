package com.willitend.backend.willitendBackend.model;

import java.sql.Date;  
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


@Table(name = "experience")
@Entity
@IdClass(ExperienceId.class)
public class Experience {

	@Id
	@Column(name = "email")
	private String email; 
	
	@Id
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date; 
	
	@Column(name = "username")
	private String username;  
	
	@Column(name = "site", columnDefinition = "TEXT")
	private String site; 
	
	@Column(name = "title", columnDefinition = "TINYTEXT")
	private String title; 
	
	@Column(name = "vaccExp", columnDefinition = "MEDIUMTEXT")
	private String vaccExp; 
	
	@Column(name = "state", columnDefinition = "CHAR(2)")
	private String state; 
	
	public Experience() {
		
	}
	
	public Experience(String email, Date date, String username, String site, String state, String title, String vaccExp) {
		this.email = email; 
		this.username = username; 
		this.date = date; 
		this.site = site; 
		this.title = title; 
		this.vaccExp = vaccExp; 
		this.state = state; 
	}
	
	public String getEmail() {
		return email; 
	}
	
	public String getState() {
		return state; 
	}
	
	public Date getDate() {
		return date; 
	}
	
	public String getUsername() {
		return username; 
	}
	
	public String getTitle() {
		return title; 
	}
	
	public String getSite() {
		return site; 
	}
	
	public String getVaccExp() {
		return vaccExp; 
	}
	
	public void setEmail(String email) {
		this.email = email; 
	}
	
	public void setState(String state) {
		this.state = state; 
	}
	
	public void setDate(String date){
		Date d = Date.valueOf(date);
		this.date = d;
	}
	
	public void setUsername(String username) {
		this.username = username; 
	}
	
	public void setSite(String site) {
		this.site = site; 
	}
	
	public void setTitle(String title) {
		this.title = title; 
	}
	
	public void setVaccExp(String vaccExp) {
		this.vaccExp = vaccExp; 
	}
	
	@Override
	public String toString() {
		return "Username: " + username + " from state: " + state + " at vaccination site : " + site + " writes "  + vaccExp + " on date: " + date; 
	}
}