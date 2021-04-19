package com.willitend.backend.willitendBackend;
import javax.persistence.*;


@Table (name="user")

public class User {
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "username")
	private String username;
	
	public User(String email, String state, String password, String username) {
		super();
		this.email = email;
		this.state = state;
		this.password = password;
		this.username = username;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "User [email=" + email + ", state=" + state + ", password=" + password + ", username=" + username + "]";
	}
	
	

	

}
