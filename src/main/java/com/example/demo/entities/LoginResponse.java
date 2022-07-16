package com.example.demo.entities;

public class LoginResponse {
	
	
	private String email;
	private String senha;
	private String nome;
	private Boolean existeUsuario;
	private Boolean UsuarioValido;
	
	public LoginResponse( String email, String senha, String nome,Boolean existeUsuario, Boolean UsuarioValido ) {
		super();
		
		this.email = null;
		this.senha = null;
		this.nome = null;
		this.UsuarioValido = null;
		this.existeUsuario = null;
	}
	
	public Boolean getUsuarioValido() {
		return UsuarioValido;
	}
	public void setUsuarioValido(Boolean usuarioValido) {
		UsuarioValido = usuarioValido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getExisteUsuario() {
		return existeUsuario;
	}
	public void setExisteUsuario(Boolean existeUsuario) {
		this.existeUsuario = existeUsuario;
	}


}
