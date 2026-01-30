package com.proj4.entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    private String name;
    private String phone;
    private String email;
    private int age;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PgPlace> pgPlaces;
    
	public Owner(String name, String phone, String email, int age, List<PgPlace> pgPlaces) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.pgPlaces = pgPlaces;
	}

	public Owner() {
		super();
	}
	

	public Long getOwnerId() {
		return ownerId;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public List<PgPlace> getPgPlaces() {
		return pgPlaces;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPgPlaces(List<PgPlace> pgPlaces) {
		this.pgPlaces = pgPlaces;
	}

	@Override
	public String toString() {
		return "Owner [name=" + name + ", phone=" + phone + ", email=" + email + ", age=" + age + "]";
	}

    // getters and setters
    
    
}

