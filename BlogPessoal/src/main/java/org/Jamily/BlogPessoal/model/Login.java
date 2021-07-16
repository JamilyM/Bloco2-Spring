package org.Jamily.BlogPessoal.model;

import java.util.List;

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
	public List<Postagem> postagem;

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

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	/*
	 * public String getToken() { return Token; }
	 * 
	 * public void setToken(String token) { Token = token; }
	 */

}
