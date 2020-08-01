package com.hackathon.limit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	
	//Variables
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String cnpj;
	private String name;
	private float metreage;
	private String hourOpen;
	private String hourClose;
	private String dayOpen;
	private String dayClose;
	private String login;
	private String password;
	private Integer rangeTime;
	private Integer mediumTime;
	private Integer bigTime;
	private Address Address;
	private Shedule Shedule;
	
	//constructor
	
	public Store(){
		
	}
	
	// getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMetreage() {
		return metreage;
	}

	public void setMetreage(float metreage) {
		this.metreage = metreage;
	}

	public String getHourOpen() {
		return hourOpen;
	}

	public void setHourOpen(String hourOpen) {
		this.hourOpen = hourOpen;
	}

	public String getHourClose() {
		return hourClose;
	}

	public void setHourClose(String hourClose) {
		this.hourClose = hourClose;
	}

	public String getDayOpen() {
		return dayOpen;
	}

	public void setDayOpen(String dayOpen) {
		this.dayOpen = dayOpen;
	}

	public String getDayClose() {
		return dayClose;
	}

	public void setDayClose(String dayClose) {
		this.dayClose = dayClose;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRangeTime() {
		return rangeTime;
	}

	public void setRangeTime(Integer rangeTime) {
		this.rangeTime = rangeTime;
	}

	public Integer getMediumTime() {
		return mediumTime;
	}

	public void setMediumTime(Integer mediumTime) {
		this.mediumTime = mediumTime;
	}

	public Integer getBigTime() {
		return bigTime;
	}

	public void setBigTime(Integer bigTime) {
		this.bigTime = bigTime;
	}

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
	}

	public Shedule getShedule() {
		return Shedule;
	}

	public void setShedule(Shedule shedule) {
		Shedule = shedule;
	}
	
	
	
	
	
	
	
	
	
}
