package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pessoa;
import com.example.demo.repository.PessoaDao;

@Service
public class PessoaService {
	
	@Autowired
	PessoaDao pessoaDao;
	
	public List<Pessoa> findAll() {
		return pessoaDao.findAll();
	}

	
	public Pessoa pegaEmail(String email){
		Pessoa pessoa = pessoaDao.buscaPorEmail(email);
		return pessoaDao.buscaPorEmail(email);	 
	}
	
	public Pessoa insert(Pessoa pessoa) {
		return pessoaDao.save(pessoa);
	}

}
