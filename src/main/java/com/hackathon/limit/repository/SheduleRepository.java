package com.hackathon.limit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.limit.model.Shedule;
import com.hackathon.limit.model.Store;

@Repository
public interface SheduleRepository extends JpaRepository<Shedule,Long> {
	
	public List<Shedule> findByStoreAndDateAndHour(Store store,Date date,Date hour);

}
