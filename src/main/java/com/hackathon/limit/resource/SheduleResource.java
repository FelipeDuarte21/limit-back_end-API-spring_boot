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
import com.hackathon.limit.service.SheduleService;

@RestController
@RequestMapping("/shedule")
public class SheduleResource {
	
	@Autowired
	private SheduleService service;
	
	@PostMapping
	public ResponseEntity<SheduleReturnDTO> requestPassword(@RequestBody SheduleDTO shedule){
		SheduleReturnDTO sheduleReturn = this.service.requestPassword(shedule);
		
		if(sheduleReturn != null) {
			return ResponseEntity.status(HttpStatus.OK).body(sheduleReturn);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PutMapping("/enable")
	public ResponseEntity<?> enablePassword(@RequestParam String password){
		return null;
	}
	
	@DeleteMapping("/disable")
	public ResponseEntity<?> disablePassword(@RequestParam String password){
		return null;
	}
	
}
