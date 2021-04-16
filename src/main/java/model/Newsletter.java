package model;

import javax.persistence.*;

@Entity
@Table(name = "newsletter")
public class Newsletter {
	
	@Id 
	private String email; 
	
	@Column(name = "state")
	private String state; 
	
	public Newsletter() {
		
	}
	
	public Newsletter(String email, String state) {
		this.email = email; 
		this.state = state; 
	}
	
	public String getEmail() {
		return email; 
	}
	
	public String getState() {
		return state; 
	}
	
	public void setEmail(String email) {
		this.email = email; 
	}
	
	public void setState(String state) {
		this.state = state; 
	}
	
	@Override
	public String toString() {
		return "Newsletter for [email: " + email + " living in state: " + state + " ]";  
	}
}
