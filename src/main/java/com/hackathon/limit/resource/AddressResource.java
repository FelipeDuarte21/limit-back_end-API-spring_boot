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
import com.hackathon.limit.resource.exceptions.ObjectNotFoundException;
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
		
		throw new ObjectNotFoundException("Não há endereços cadastrados!");
	}
	
	@GetMapping("/city")
	public ResponseEntity<List<Address>> findByCity(@RequestParam(name = "value") String city){
		
		List<Address> address = this.service.findByCity(city);
		
		if(!address.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(address);
		}
		
		throw new ObjectNotFoundException("Não há endereços cadastrados para a cidade informada!");
	}
	
	@GetMapping("/neighborhood")
	public ResponseEntity<List<Address>> findByNeighborhood(@RequestParam(name = "value") String neighborhood){
		
		List<Address> address = this.service.findByNeighborhood(neighborhood);
		
		if(!address.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(address);
		}
		
		throw new ObjectNotFoundException("Não há endereços cadastrados para o bairro informado!");
		
	}
	
}
