package com.hackathon.limit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.limit.model.Store;
import com.hackathon.limit.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository repository;
	
	@Autowired
	private AddressService addressService;
	
	public Store register(Store store) {
		
		Store s = this.repository.findByCnpj(store.getCnpj());
		
		if(s != null) return null;
		
		store.setAddress(this.addressService.save(store.getAddress()));
		
		return this.repository.save(store);
	}
	
	public List<Store> findByNeighborhood(String neighborhood){
		
		List<Store> storesAll = this.repository.findAll();
		
		List<Store> storesReturn = new ArrayList<>();
		
		storesAll.forEach(store -> {
			if(store.getAddress().getNeighborhood().equals(neighborhood)) {
				storesReturn.add(store);			
			}
		});
		
		if(!storesReturn.isEmpty()) {
			return storesReturn;
		}
		
		return null;
	}
	
	public Store findById(Long id) {
		Optional<Store> s = this.repository.findById(id);
		
		if(s.isPresent()) {
			return s.get();
		}
		
		return null;
	}
	
}
