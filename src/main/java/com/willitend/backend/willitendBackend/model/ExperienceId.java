package com.willitend.backend.willitendBackend.model;

import java.sql.Date;
import java.util.Objects;
import java.io.Serializable;

public class ExperienceId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String email;
	
	private Date date; 
	
	public ExperienceId () {
		
	}
	
	public ExperienceId (String email, Date date) {
		this.email = email; 
		this.date = date; 
	}
	
	public String getEmail() {
		return this.email; 
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setEmail(String email) {
		this.email = email; 
	}
	
	public void setDate (Date date) {
		this.date = date; 
	}
	
	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true; 
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		ExperienceId id = (ExperienceId) o; 
		return Objects.equals(email, id.getEmail()) &&
				Objects.equals(date, id.getDate());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, date);
	}
}
