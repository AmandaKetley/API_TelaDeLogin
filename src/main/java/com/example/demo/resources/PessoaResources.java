package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pessoa;
import com.example.demo.entities.LoginResponse;
import com.example.demo.services.PessoaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResources {

	@Autowired
	PessoaService pessoaService;
	LoginResponse loginResponse = new LoginResponse(null, null, null, null, null);
	
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = pessoaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa pessoa) {
		pessoa = pessoaService.insert(pessoa);
		return ResponseEntity.ok().body(pessoa);
	}

	
	@PostMapping(value = "/verificaUsuario")
	public LoginResponse buscaPorUsuario(@RequestBody Pessoa pessoa) {
		Boolean verificaEmail = verificaEmail(pessoa);
	
		if(verificaEmail.equals(true)) {
			Pessoa usuario = ValidaUsuiario(pessoa);
			
			if(usuario != null) {
				loginResponse.setEmail(usuario.getEmail());
				loginResponse.setSenha(usuario.getSenha());
				loginResponse.setNome(usuario.getNome());
				loginResponse.setExisteUsuario(verificaEmail);
				loginResponse.setUsuarioValido(true);
				return loginResponse;
			} else {
				loginResponse.setExisteUsuario(verificaEmail);
				loginResponse.setUsuarioValido(false);	
			}
		}
		
		loginResponse.setExisteUsuario(verificaEmail);
		loginResponse.setUsuarioValido(false);
		   return loginResponse;
		
	}

	public Boolean verificaEmail(Pessoa pessoa){
	Pessoa pessoaBanco = pessoaService.pegaEmail(pessoa.getEmail());
	if(pessoaBanco != null) {
		return true;
	}
	
		return false;	
	}
	
	public Pessoa ValidaUsuiario(Pessoa pessoa) {
		   Pessoa pessoaBanco = pessoaService.pegaEmail(pessoa.getEmail());
		   String emailDao = pessoaBanco.getEmail();
		   String senhaDao = pessoaBanco.getSenha();
		   String email = pessoa.getEmail();
		   String senha = pessoa.getSenha();
		   
		       if(email.equals(emailDao) && senha.equals(senhaDao)){
						return pessoaBanco;	
				}
			return null;	
	}
}
