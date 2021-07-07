package org.Jamily.BlogPessoal.Service;

import java.util.Optional;

import org.Jamily.BlogPessoal.model.Usuario;
import org.Jamily.BlogPessoal.repository.UsuarioRepository;
import org.Jamily.BlogPessoal.secutiry.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername (String userName) throws UsernameNotFoundException {
		
		Optional<Usuario> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException (userName + "not found."));
		
		return user.map(UserDetailsImpl::new).get();
	}
	
	

	
}
