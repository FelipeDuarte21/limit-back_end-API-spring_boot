package com.hackathon.limit.model.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SheduleReturnDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String cpf;
	private String password;
	private LocalDate date;
	private LocalDateTime start;
	
	public SheduleReturnDTO() {
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	
}
