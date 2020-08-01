package com.hackathon.limit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.limit.model.Address;
import com.hackathon.limit.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	public Address save(Address address) {
		return this.repository.save(address);
	}
	
	public List<Address> findAll(){
		List<Address> address = this.repository.findAll();
		
		if(!address.isEmpty()) {
			return address;
		}
		
		return null;
	}
	
	public List<Address> findByCity(String city){
		
		List<Address> address = this.repository.findByCity(city);
		
		if(!address.isEmpty()) {
			return address;
		}
		
		return address;
	}
	
	public List<Address> findByNeighborhood(String neighborhood){
		List<Address> address = this.repository.findByNeighborhood(neighborhood);
		
		if(!address.isEmpty()) {
			return address;
		}
		
		return null;
	}
	
}
