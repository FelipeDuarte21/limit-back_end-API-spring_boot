package com.hackathon.limit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.limit.model.Shedule;

@Repository
public interface SheduleRepository extends JpaRepository<Shedule,Long> {

}
