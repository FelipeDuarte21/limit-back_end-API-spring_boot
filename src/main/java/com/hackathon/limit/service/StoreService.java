package com.hackathon.limit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.limit.model.Store;
import com.hackathon.limit.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository repository;
	
	public Store register(Store store) {
		return this.repository.save(store);
	}
	
	public List<Store> findByNeighborhood(String neighborhood){
		
		List<Store> storesAll = this.repository.findAll();
		
		List<Store> storesReturn = new ArrayList<>();
		
		storesAll.forEach(store -> {
			if(store.getAddress().getNeighborhood().equals(neighborhood)) {
				storesReturn.add(store);			}
		});
		
		if(!storesReturn.isEmpty()) {
			return storesReturn;
		}
		
		return null;
	}
	
}
