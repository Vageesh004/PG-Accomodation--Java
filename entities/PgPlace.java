package com.proj4.entities;


import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pg_place")
public class PgPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pgId;

    private String pgName;
    private String city;
    private String locality;

    private String roomType;     // 1-sharing, 2-sharing, etc
    private int totalRooms;
    private double rent;

    private boolean foodAvailable;
    private String pgType;        // MEN / WOMEN / BOTH
    private boolean availability;
    private int visitorCount;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference   // 🔥 ADD THIS
    private Owner owner;


    @OneToMany(mappedBy = "pgPlace")
    @JsonManagedReference
    private List<Tenant> tenants;


	public PgPlace(String pgName, String city, String locality, String roomType, int totalRooms, double rent,
			boolean foodAvailable, String pgType, boolean availability, int visitorCount, Owner owner,
			List<Tenant> tenants) {
		super();
		this.pgName = pgName;
		this.city = city;
		this.locality = locality;
		this.roomType = roomType;
		this.totalRooms = totalRooms;
		this.rent = rent;
		this.foodAvailable = foodAvailable;
		this.pgType = pgType;
		this.availability = availability;
		this.visitorCount = visitorCount;
		this.owner = owner;
		this.tenants = tenants;
	}

	public PgPlace() {
		super();
	}
	
	
	

	public Long getPgId() {
		return pgId;
	}

	public String getPgName() {
		return pgName;
	}

	public String getCity() {
		return city;
	}

	public String getLocality() {
		return locality;
	}

	public String getRoomType() {
		return roomType;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public double getRent() {
		return rent;
	}

	public boolean isFoodAvailable() {
		return foodAvailable;
	}

	public String getPgType() {
		return pgType;
	}

	public boolean isAvailability() {
		return availability;
	}

	public int getVisitorCount() {
		return visitorCount;
	}

	public Owner getOwner() {
		return owner;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public void setFoodAvailable(boolean foodAvailable) {
		this.foodAvailable = foodAvailable;
	}

	public void setPgType(String pgType) {
		this.pgType = pgType;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}

	@Override
	public String toString() {
	    return "PgPlace [pgName=" + pgName +
	           ", city=" + city +
	           ", locality=" + locality +
	           ", roomType=" + roomType +
	           ", totalRooms=" + totalRooms +
	           ", rent=" + rent +
	           ", foodAvailable=" + foodAvailable +
	           ", pgType=" + pgType +
	           ", availability=" + availability +
	           ", visitorCount=" + visitorCount +
	           ", ownerId=" + (owner != null ? owner.getOwnerId() : null) +
	           "]";
	}

    // getters and setters
    
}
