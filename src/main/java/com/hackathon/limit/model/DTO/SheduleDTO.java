package com.hackathon.limit.model.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SheduleDTO {
	
	private Long store;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm:ss")
	private LocalDateTime hour;
	
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

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalDateTime getHour() {
		return this.hour;
	}

	public void setHour(LocalDateTime hour) {
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
