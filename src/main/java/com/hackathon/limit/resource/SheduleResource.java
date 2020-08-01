package com.hackathon.limit.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.limit.service.SheduleService;

@RestController
@RequestMapping("/shedule")
public class SheduleResource {
	
	@Autowired
	private SheduleService service;
	
	@PostMapping
	public ResponseEntity<?> requestPassword(){
		this.service.requestPassword();
		return null;
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