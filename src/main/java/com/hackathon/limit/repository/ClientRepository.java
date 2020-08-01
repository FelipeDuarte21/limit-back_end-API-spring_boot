package com.hackathon.limit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.limit.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
