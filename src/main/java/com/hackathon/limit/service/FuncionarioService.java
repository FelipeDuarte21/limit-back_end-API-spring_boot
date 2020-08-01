package com.hackathon.limit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.limit.model.Funcionario;
import com.hackathon.limit.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired	
	private FuncionarioRepository repository;
	
	public Funcionario save(Funcionario funcionario) {
		return this.repository.save(funcionario);
	}

}
