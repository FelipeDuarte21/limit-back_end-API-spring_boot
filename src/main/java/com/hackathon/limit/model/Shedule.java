package com.hackathon.limit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shedule {
	
	//Variables
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date date;
	private Integer range;
	private String password;
	private Client Client;
	private Store Store;
	
	//constructor
	
	public Shedule() {
		
	}
	
	// getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public Store getStore() {
		return Store;
	}

	public void setStore(Store store) {
		Store = store;
	}
	
	
	

}
