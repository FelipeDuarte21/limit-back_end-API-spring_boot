package com.hackathon.limit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.limit.model.Funcionario;

import com.hackathon.limit.service.FuncionarioService;

@RestController
@RequestMapping("/teste")
public class TesteAPIResource {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public String primeiroRetorno() {
		return "Hello World!";
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Funcionario funcionario){
		Funcionario f = this.service.save(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(f);
	}
	
	
	
}
