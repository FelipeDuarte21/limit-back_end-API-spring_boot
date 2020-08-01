package com.hackathon.limit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.limit.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{

}
