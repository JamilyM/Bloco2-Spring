package org.Jamily.BlogPessoal.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.Jamily.BlogPessoal.model.Postagem;
import org.Jamily.BlogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class PostagemTeste {
	
	@Disabled
	@Test
	void deveRetornarListadeUsuarioRetornaStatus200() {
		ResponseEntity<?> resposta = TestRestTemplate.withBasicAuth("jamily", "123456")
				.exchange("/usuario/todos", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
}