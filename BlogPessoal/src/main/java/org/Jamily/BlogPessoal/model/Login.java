package org.Jamily.BlogPessoal.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Login {

	@NotBlank(message = "Esse campo não deve fica em branco")
	private String usuario;

	@NotBlank(message = "Esse campo não deve fica em branco")
	private String senha;

	// private String Token;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	public Postagem postagem;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/*
	 * public String getToken() { return Token; }
	 * 
	 * public void setToken(String token) { Token = token; }
	 */

}
