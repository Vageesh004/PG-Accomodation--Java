package com.proj4.entities;



import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String username;
    private String password;
    
    
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public Admin() {
		super();
	}


	
	
	
	public Long getAdminId() {
		return adminId;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}

	

	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}

    
	
    
}
