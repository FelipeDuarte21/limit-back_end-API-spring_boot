package com.hackathon.limit.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.limit.model.Address;
import com.hackathon.limit.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressResource {
	
	@Autowired
	private AddressService service;
	
	@GetMapping
	public ResponseEntity<List<Address>> findAll(){
		
		List<Address> address = this.service.findAll();
		
		if(!address.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(address);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(address);
	}
	
	@GetMapping("/city")
	public ResponseEntity<List<Address>> findByCity(@RequestParam String city){
		
		List<Address> address = this.service.findByCity(city);
		
		if(!address.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(address);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(address);
	}
	
	@GetMapping("/neighborhood")
	public ResponseEntity<List<Address>> findByNeighborhood(String neighborhood){
		
		List<Address> address = this.service.findByNeighborhood(neighborhood);
		
		if(!address.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(address);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(address);
		
	}
	
}
