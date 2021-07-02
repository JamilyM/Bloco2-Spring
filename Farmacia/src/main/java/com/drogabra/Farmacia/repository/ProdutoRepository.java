package com.drogabra.Farmacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.drogabra.Farmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Optional<Produto> findByNomeContainingIgnoreCase (String nomeProduto);


}
