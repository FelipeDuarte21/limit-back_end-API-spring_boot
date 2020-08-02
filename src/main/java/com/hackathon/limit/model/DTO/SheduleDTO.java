package com.hackathon.limit.model.DTO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SheduleDTO {
	
	private Long store;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@JsonFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	private Date hour;
	
	private Integer rangeTime;
	private String name;
	private String cpf;
	
	public SheduleDTO() {
		
	}

	public Long getStore() {
		return store;
	}

	public void setStore(Long store) {
		this.store = store;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getHour() {
		return this.hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	public Integer getRangeTime() {
		return rangeTime;
	}

	public void setRangeTime(Integer rangeTime) {
		this.rangeTime = rangeTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
