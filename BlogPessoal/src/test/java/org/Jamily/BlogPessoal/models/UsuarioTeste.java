package org.Jamily.BlogPessoal.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.Jamily.BlogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioTeste {

	public Usuario usuario;
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validador = factory.getValidator();
	
    @BeforeEach
    public void start() {
    	usuario = new Usuario( "jamily", "Jamily Melo", "jamilymelo23@email.com", "123456");
    }
    
	@Test
	void testValidaAtributoCorreto() {
	Set<ConstraintViolation<Usuario>> validacao = validador.validate(usuario);
	assertTrue(validacao.isEmpty());
	}
	
	@Test
	void testValidaAtributoIncorreto() {
		Usuario usuarioErro = new Usuario();
		usuarioErro.setNome("jamily");
	    usuarioErro.setEmail("jamilymeloemail.com");
	    usuarioErro.setUsuario("jamilymeloemail.com");
	    usuarioErro.setSenha("123456");
		Set<ConstraintViolation<Usuario>> validacao = validador.validate(usuario); 
	    assertFalse(validacao.isEmpty());
	}

}
//serve.port=8081 - inserir qual porta deve ser usada