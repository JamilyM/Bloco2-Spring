package org.Jamily.BlogPessoal.Controller;

import javax.validation.Valid;

import org.Jamily.BlogPessoal.model.Login;
import org.Jamily.BlogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class LoginController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PutMapping("/editar/{usuario}")
	public ResponseEntity<Object> put (@Valid @PathVariable(value = "usuario") String usuario, @Valid @RequestBody Login login){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(login));
	}
	
	@DeleteMapping("/login/{usuario}")
	public void delete (@PathVariable String usuario){
		repository.deleteByUsuario(usuario);
	}
	


}
