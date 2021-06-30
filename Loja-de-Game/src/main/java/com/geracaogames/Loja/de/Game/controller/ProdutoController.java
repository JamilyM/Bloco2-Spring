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
import com.geracaogames.Loja.de.Game.model.Produto;
import com.geracaogames.Loja.de.Game.repository.ProdutoRepository;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	public ProdutoRepository produtoR;

	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> buscartodosProduto() {
		List<Produto> listaDeProduto = produtoR.findAll();
		if (listaDeProduto.isEmpty()) {
			return ResponseEntity.status(200).body(listaDeProduto);
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/id/{id_Produto}")
	public ResponseEntity<Produto> pegarProdutoPorId(@PathVariable(value = "id_Produto") Long idProduto) {
		return produtoR.findById(idProduto).map(produto -> ResponseEntity.status(200).body(produto))
				.orElse(ResponseEntity.status(204).build());
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoR.save(produto));
	}

	@PutMapping("/editar/{id_Produto}")
	public ResponseEntity<Produto> put(@RequestBody Produto produto,
			@PathVariable(value = "id_Produto") Long idProduto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoR.save(produto));
	}
	
	@DeleteMapping("/excluir/{id_Produto}")
	public void delete (@PathVariable (value = "id_Produto") Long idProduto){
		produtoR.deleteById(idProduto);
	}

}

