package com.drogabra.Farmacia.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.drogabra.Farmacia.model.Categoria;
import com.drogabra.Farmacia.repository.CategoriaRepository;
import com.drogabra.Farmacia.service.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	public CategoriaRepository categoriaR;
	public CategoriaService services;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Categoria>> buscarTodos(){
		List<Categoria> listaDasCategorias = categoriaR.findAll();
		if (listaDasCategorias.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(200).body(listaDasCategorias);
		}
	}
	
	@GetMapping("/{id_categoria}")
	public ResponseEntity<Categoria> buscarporcategoria(@Valid @PathVariable(value = "id_categoria") Long idCategoria){
		return categoriaR.findById(idCategoria).map(categoria -> ResponseEntity.status(200).body(categoria))
				.orElse(ResponseEntity.status(204).build());	
   }
	@PostMapping("/adicionar")
	public ResponseEntity<Object> criarCategoria(@Valid @RequestBody Categoria categoria) {
		return services.adicionarCategoria(categoria)
				.map(produtoCriado -> ResponseEntity.status(201).body(produtoCriado))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	@DeleteMapping("/excluir/{id_Categoria}")
	public void delete (@PathVariable (value = "id_Categoria") Long idCategoria){
		categoriaR.deleteById(idCategoria);
	}
}
