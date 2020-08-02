package com.hackathon.limit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Store implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Variables
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cnpj;
	private String name;
	private Float metreage;
	private Integer maximumCapacity;
	private String hourOpen;
	private String hourClose;
	private String dayOpen;
	private String dayClose;
	private String login;
	private String password;
	private Integer rangeTime;
	private Integer mediumTime;
	private Integer bigTime;
	
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@JsonIgnore	
	@OneToMany(mappedBy = "store")
	private List<Shedule> shedules;
	
	//constructor
	
	public Store(){
		
	}
	
	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Float getMetreage() {
		return metreage;
	}

	public void setMetreage(Float metreage) {
		this.metreage = metreage;
	}
	
	public Integer getMaximumCapacity() {
		return maximumCapacity;
	}

	public void setMaximumCapacity(Integer maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
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
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Shedule> getShedule() {
		return this.shedules;
	}

	public void setShedule(List<Shedule> shedule) {
		this.shedules = shedule;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
