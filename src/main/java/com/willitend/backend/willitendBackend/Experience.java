package com.willitend.backend.willitendBackend;
import javax.persistence.*;

@Entity
@Table(name = "experiences")
public class Experience {
	@Id
	private String date;
	
	@Id
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
}
