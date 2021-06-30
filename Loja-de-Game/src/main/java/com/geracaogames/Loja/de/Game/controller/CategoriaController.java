package com.geracaogames.Loja.de.Game.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geracaogames.Loja.de.Game.model.Categoria;
import com.geracaogames.Loja.de.Game.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	public CategoriaRepository categoriaR;

	@GetMapping("/todos")
	public ResponseEntity<List<Categoria>> buscartodasCategoria() {
		List<Categoria> listaDeCategoria = categoriaR.findAll();
		if (listaDeCategoria.isEmpty()) {
			return ResponseEntity.status(200).body(listaDeCategoria);
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/id/{id_Categoria}")
	public ResponseEntity<Categoria> pegarCategoriaPorId(@PathVariable(value = "id_Categoria") Long idCategoria) {
		return categoriaR.findById(idCategoria).map(categoria -> ResponseEntity.status(200).body(categoria))
				.orElse(ResponseEntity.status(204).build());
	}

	
	@PostMapping("/adicionar")
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaR.save(categoria));
	}

	@PutMapping("/editar/{id_Categoria}")
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria,
			@PathVariable(value = "id_Categoria") Long idCategoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaR.save(categoria));
	}
	
	@DeleteMapping("/excluir/{id_Categoria}")
	public void delete (@PathVariable (value = "id_Categoria") Long idCategoria){
		categoriaR.deleteById(idCategoria);
	}

}