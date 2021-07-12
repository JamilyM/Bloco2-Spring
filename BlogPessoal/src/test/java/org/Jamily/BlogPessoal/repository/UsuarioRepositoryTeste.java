package org.Jamily.BlogPessoal.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.Jamily.BlogPessoal.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UsuarioRepositoryTeste {

	@Autowired
	private UsuarioRepository repositorio;
	
	@Test
	public void findByUsuarioRetornaUsuario() throws Exception {

		Usuario usuario = repositorio.findByUsuario("jamily").get();
		assertTrue(usuario.getUsuario().equals("jamily"));
	}

}
