package com.geracaogames.Loja.de.Game.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geracaogames.Loja.de.Game.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findByProdutosContainingIgnoreCase (String produtos);

}
