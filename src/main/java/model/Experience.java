package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "experience")
public class Experience {
	
	@Id
	private String email; 
	
	@Id
	private Date date; 
	
	@Column(name = "username")
	private String username;  
	
	@Column(name = "site")
	private String site; 
	
	@Column(name = "title")
	private String title; 
	
	@Column(name = "vaccExp")
	private String vaccExp; 
	
	public Experience() {
		
	}
	
	public Experience(String email, Date date, String username, String site, String title, String vaccExp) {
		this.email = email; 
		this.username = username; 
		this.date = date; 
		this.site = site; 
		this.title = title; 
		this.vaccExp = vaccExp; 
	}
	
	public String getEmail() {
		return email; 
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
	
	public void setDate(Date date) {
		this.date = date; 
	}
	
	public void setUsername(String username) {
		this.username = username; 
	}
	
	public void setSite(String site) {
		this.site = site; 
	}
	
	public void setTitle(String tite) {
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
