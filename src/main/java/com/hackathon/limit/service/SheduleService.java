package com.hackathon.limit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.limit.model.Shedule;
import com.hackathon.limit.repository.ClientRepository;
import com.hackathon.limit.repository.SheduleRepository;

@Service
public class SheduleService {
		
	@Autowired
	private SheduleRepository repository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public Shedule requestPassword(){
		
		//Aqui vai ter a logica pra controlar o agendamento
		
		return null;
	}
	
	public void enablePassword(String password){
		
	}
	
	public void disablePassword(String password){
		
	}
	
}
