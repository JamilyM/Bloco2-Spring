package org.Jamily.BlogPessoal.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.Jamily.BlogPessoal.Service.UsuarioService;
import org.Jamily.BlogPessoal.model.Login;
import org.Jamily.BlogPessoal.model.Usuario;
import org.Jamily.BlogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	private UsuarioRepository repository;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Usuario>> pegarTodos(){
		List<Usuario> listaDeUsuario = repository.findAll();
		if (!listaDeUsuario.isEmpty()) {
			return ResponseEntity.status(200).body(listaDeUsuario);
		} else {			
			return ResponseEntity.status(204).build();
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Login> Autentication(@RequestBody Optional<Login> login) {
		return service.Logar(login).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());

	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> post(@Valid @RequestBody Usuario usuario) {
		Optional<Object> cadastrarUsuario = service.CadastrarUsuario(usuario);
		if (cadastrarUsuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existente!");

		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado.");

		}
	}
}
