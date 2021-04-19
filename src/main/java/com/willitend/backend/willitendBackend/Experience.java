package com.willitend.backend.willitendBackend;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "experiences")
public class Experience {
	// Fields
	@Id
	@Column(name = "date")
	private Date date;
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "vaccExp")
	private String vaccExp;
	
	// Constructor for Experience
	public Experience(Date date, String email, String userName, String password, String site, String title, String vaccExp) {
		this.date = date;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.site = site;
		this.title = title;
		this.vaccExp = vaccExp;
	}
	
	// Getter Methods
	public Date getDate() {
		return this.date;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getSite() {
		return this.site;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getVaccExp() {
		return this.vaccExp;
	}
}
