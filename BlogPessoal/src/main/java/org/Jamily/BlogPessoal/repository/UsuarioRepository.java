package org.Jamily.BlogPessoal.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.Jamily.BlogPessoal.model.Login;
import org.Jamily.BlogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsuario(String usuario);

	void deleteByUsuario(String usuario);

	Object save(@Valid Login login);
}
