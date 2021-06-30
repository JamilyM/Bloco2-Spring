package com.geracaogames.Loja.de.Game.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geracaogames.Loja.de.Game.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
      List<Categoria>findByCategoriasContainingIgnoreCase (String categorias);
}
