package com.proj4.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;

    private String name;
    private String phone;
    private String email;
    private String designation;     // Student / Worker
    private String city;
    private String roomPreference;  // 1 / 2 / 3 sharing
    private int age;

    @ManyToOne(optional = true)
    @JoinColumn(name = "pg_id")
    @JsonBackReference
    private PgPlace pgPlace;

	public Tenant(String name, String phone, String email, String designation, String city, String roomPreference,
			int age, PgPlace pgPlace) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.designation = designation;
		this.city = city;
		this.roomPreference = roomPreference;
		this.age = age;
		this.pgPlace = pgPlace;
	}

	public Tenant() {
		super();
	}

	
	
	
	public Long getTenantId() {
		return tenantId;
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

	public String getDesignation() {
		return designation;
	}

	public String getCity() {
		return city;
	}

	public String getRoomPreference() {
		return roomPreference;
	}

	public int getAge() {
		return age;
	}

	public PgPlace getPgPlace() {
		return pgPlace;
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

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setRoomPreference(String roomPreference) {
		this.roomPreference = roomPreference;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPgPlace(PgPlace pgPlace) {
		this.pgPlace = pgPlace;
	}

	@Override
	public String toString() {
	    return "Tenant [name=" + name +
	           ", phone=" + phone +
	           ", email=" + email +
	           ", designation=" + designation +
	           ", city=" + city +
	           ", roomPreference=" + roomPreference +
	           ", age=" + age +
	           "]";
	}


	
	
	
	
    
}
