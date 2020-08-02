package com.hackathon.limit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.limit.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{
	
	public List<Address> findByCity(String city);
	
	public List<Address> findByNeighborhood(String neighborhood);
	
}
