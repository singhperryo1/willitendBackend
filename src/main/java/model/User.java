package model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String email;
	
	@Column(name = "state")
	private String state; 
	
	@Column(name = "password")
	private String password; 
	
	@Column(name = "username")
	private String username; 
	
	public User() {
		
	}
	
	public User(String email, String state, String password, String username) {
		this.email = email; 
		this.state = state; 
		this.password = password; 
		this.username = username; 
	}
	
	public String getEmail() {
		return email; 
	}
	
	public String getState() {
		return state; 
	}
	
	public String password() {
		return password; 
	}
	
	public String username() {
		return username; 
	}
	
	public void setEmail(String email) {
		this.email = email; 
	}
	
	public void setState(String state) {
		this.state = state; 
	}
	
	public void setPassword(String password) {
		this.password = password; 
	}
	
	public void setUsername(String username) {
		this.username = username; 
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", state=" + state + ", username=" + email + "]";
	}
}
