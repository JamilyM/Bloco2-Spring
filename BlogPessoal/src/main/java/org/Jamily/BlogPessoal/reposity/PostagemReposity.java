package org.Jamily.BlogPessoal.reposity;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.Jamily.BlogPessoal.model.Postagem;

@Repository
public interface PostagemReposity extends JpaRepository<Postagem, Long> {
	List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);

}