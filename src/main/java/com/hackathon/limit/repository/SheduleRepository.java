package com.hackathon.limit.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.limit.model.Shedule;
import com.hackathon.limit.model.Store;

@Repository
public interface SheduleRepository extends JpaRepository<Shedule,Long> {
	
	public List<Shedule> findByStoreAndDateAndHour(Store store,LocalDate date,LocalDateTime hour);
	
	public List<Shedule> findByCpf(String cpf);
	
	public List<Shedule> findByPassword(String password);
	
	public List<Shedule> findByStatusAndPassword(Integer status,String password);

}
