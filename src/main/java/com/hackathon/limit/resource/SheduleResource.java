package com.hackathon.limit.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.limit.model.DTO.SheduleDTO;
import com.hackathon.limit.model.DTO.SheduleReturnDTO;
import com.hackathon.limit.resource.exceptions.ObjectBadRequestException;
import com.hackathon.limit.service.SheduleService;

@RestController
@RequestMapping("/shedule")
public class SheduleResource {
	
	@Autowired
	private SheduleService service;
	
	@PostMapping
	public ResponseEntity<SheduleReturnDTO> requestPassword(@RequestBody SheduleDTO shedule){
		SheduleReturnDTO sheduleReturn = this.service.requestPassword(shedule);
		
		if(sheduleReturn == null) {
			throw new ObjectBadRequestException("Você Já Reservou esse horário");
		}
		
		if(sheduleReturn.getDate() == null) {
			throw new ObjectBadRequestException("Não há vagas para o horario informado!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sheduleReturn);
	}
	
	@PutMapping("/enable")
	public ResponseEntity<String> enablePassword(@RequestParam(name = "value") String password){
		
		boolean shedule = this.service.enablePassword(password);
		
		if(!shedule) {
			throw new ObjectBadRequestException("Senha inválida!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("Senha Ativada!");
	}
	
	@DeleteMapping("/disable")
	public ResponseEntity<?> disablePassword(@RequestParam(name = "value") String password){
		
		boolean shedule = this.service.disablePassword(password);
		
		if(!shedule) {
			throw new ObjectBadRequestException("Senha inválida!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("Senha Desativa!");
	}
	
}
