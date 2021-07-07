package org.Jamily.BlogPessoal.Controller;

import java.util.List;

import org.Jamily.BlogPessoal.model.Tema;
import org.Jamily.BlogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RequestMapping("/tema")
public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Tema> GetById(@PathVariable int id){
		return repository.findById(id)
        .map(resp -> ResponseEntity.ok(resp))
        .orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> GetByTitulo(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	@PostMapping("/adicionar")
	public ResponseEntity<Tema> post (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	@PostMapping("/editar")
	public ResponseEntity<Tema> put (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	@DeleteMapping("/{id}")
	public void delete (@PathVariable int id){
		repository.deleteById(id);
	}
}
