package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Pessoa;

	@Repository
	public interface PessoaDao extends JpaRepository<Pessoa, Long>{
		
		@Query("SELECT obj FROM Pessoa obj WHERE obj.email = :email")
		Pessoa buscaPorEmail(@Param("email") String email);
		
}

