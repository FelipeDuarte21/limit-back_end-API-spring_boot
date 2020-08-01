package com.hackathon.limit.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.limit.model.Store;
import com.hackathon.limit.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreResource {
	
	@Autowired
	private StoreService service;
	
	@PostMapping
	public ResponseEntity<Store> register(@RequestBody Store store){
		
		Store s = this.service.register(store);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(s);
	}
	
	@GetMapping("/neighborhood")
	public ResponseEntity<List<Store>> findByNeighborhood(@RequestParam String neighborhood){
		
		List<Store> stores = this.service.findByNeighborhood(neighborhood);
		
		if(!stores.isEmpty()){
			return ResponseEntity.status(HttpStatus.OK).body(stores);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
}