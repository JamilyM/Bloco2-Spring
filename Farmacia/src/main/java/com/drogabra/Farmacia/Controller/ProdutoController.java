package com.drogabra.Farmacia.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.drogabra.Farmacia.model.Produto;
import com.drogabra.Farmacia.repository.ProdutoRepository;
import com.drogabra.Farmacia.service.CategoriaService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	public ProdutoRepository produtoR;
	public CategoriaService services;

	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> buscarTodos() {
		List<Produto> listaDeProduto = produtoR.findAll();
		if (listaDeProduto.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeProduto);
		}
	}

	@GetMapping("/{id_produto}")
	public ResponseEntity<Produto> buscarporproduto(@Valid @PathVariable(value = "id_produto") Long idProduto) {
		return produtoR.findById(idProduto).map(produto -> ResponseEntity.status(200).body(produto))
				.orElse(ResponseEntity.status(204).build());
	}

	@PostMapping("/adicionar/{id_produto}")
	public ResponseEntity<Object> criarCategoria(@PathVariable(value = "id_produto") Long idProduto,
			@Valid @RequestBody Produto produto) {
		return services.adicionarProduto(idProduto, produto)
				.map(produtoCriado -> ResponseEntity.status(201).body(produtoCriado))
				.orElse(ResponseEntity.badRequest().build());
	}

	@PutMapping("/editar/{id_produto}/produto")
	public ResponseEntity<Produto> editarDescricao(@PathVariable(value = "id_produto") Long idProduto, Produto produto) {
		return services.alterarDescricao(idProduto, produto)
				.map(usuarioInscrito -> ResponseEntity.status(201).body(usuarioInscrito))
				.orElse(ResponseEntity.badRequest().build());

	}
	
	@DeleteMapping ("/excluir/{id_produto}")
	public void delete (@PathVariable(value = "id_produto") Long idProduto){
		 produtoR.deleteById(idProduto);
	}

}
