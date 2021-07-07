package org.Jamily.BlogPessoal.repository;

import java.util.List;

import org.Jamily.BlogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Integer> {
	List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	}
