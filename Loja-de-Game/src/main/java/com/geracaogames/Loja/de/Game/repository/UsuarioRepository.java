package com.geracaogames.Loja.de.Game.repository;

import java.util.Optional;

import javax.validation.Valid;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geracaogames.Loja.de.Game.model.Login;
import com.geracaogames.Loja.de.Game.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsuario(String usuario);

	void deleteByUsuario(String usuario);

	Object save(@Valid Login login);
}
