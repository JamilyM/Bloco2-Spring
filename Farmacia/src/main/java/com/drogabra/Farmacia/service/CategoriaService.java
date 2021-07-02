package com.drogabra.Farmacia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drogabra.Farmacia.model.Categoria;
import com.drogabra.Farmacia.model.Produto;
import com.drogabra.Farmacia.repository.CategoriaRepository;
import com.drogabra.Farmacia.repository.ProdutoRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaR;
	private ProdutoRepository produtoR;

	
	public Optional<Object> adicionarProduto(Long idProduto, Produto novoProduto){
		return produtoR.findByNomeContainingIgnoreCase(novoProduto.getNome()).map(produtoExistente ->{
		return Optional.empty();
		}).orElseGet(() ->{
			return Optional.ofNullable(produtoR.save(novoProduto));
		});
	}
	public Optional<Object> adicionarCategoria(Categoria categoria) {
		return categoriaR.findByCategoriasContainingIgnoreCase(categoria.getCategorias()).map(CategoriaExistente ->{
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(categoriaR.save(categoria));
		});
	}
	
	public Optional<Produto> alterarDescricao(Long idProduto, Produto alterardescricao){
		return produtoR.findById(alterardescricao.getIdProduto()).map(ProdutoExistente -> {
		ProdutoExistente.setDescricao(alterardescricao.getDescricao());
		return Optional.ofNullable(produtoR.save(ProdutoExistente));
		}).orElseGet(() -> { return Optional.empty();});	
	}
	
	public Optional<Categoria> excluirProdutos (Long idCategoria){
		Optional<Produto> excluirProduto = produtoR.findById(idCategoria);
		if (excluirProduto.isPresent()) {
			return categoriaR.findById(idCategoria).map(ProdutoExistente -> {
				ProdutoExistente.getProduto().remove(excluirProduto.get());
				return Optional.ofNullable(categoriaR.save(ProdutoExistente));
				}).orElseGet(()->{
					return Optional.empty();
				});
		}else {
			return Optional.empty();						
		}	

	}
	
}
