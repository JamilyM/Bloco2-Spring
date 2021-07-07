package org.Jamily.BlogPessoal.Service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.Jamily.BlogPessoal.model.Login;
import org.Jamily.BlogPessoal.model.Usuario;
import org.Jamily.BlogPessoal.repository.UsuarioRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Object> CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return repository.findByUsuario(usuario.getUsuario()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repository.save(usuario));
		});
	}
	
	public Optional<Login> Logar(Optional<Login> login){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(login.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(encoder.matches(login.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = login.get().getUsuario() + ":" + login.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String (encodedAuth);
				
				//login.get().setToken(authHeader);
				login.get().setUsuario(usuario.get().getNome());
				
				return login;
			}
		}
	            return null;
	}
}
