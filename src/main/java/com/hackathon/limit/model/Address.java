package com.hackathon.limit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	//Variables
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String State;
	private String city;
	private String neighborhood;
	private String address;
	private Store Store;
	
	//constructor
	
	public Address() {
		
	}
	
	// getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Store getStore() {
		return Store;
	}

	public void setStore(Store store) {
		Store = store;
	}
	
	
	
	

}
