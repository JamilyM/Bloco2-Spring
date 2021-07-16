package com.geracaogames.Loja.de.Game.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.geracaogames.Loja.de.Game.model.Usuario;
import com.geracaogames.Loja.de.Game.repository.UsuarioRepository;
import com.geracaogames.Loja.de.Game.secutiry.UserDetailsImpl;

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
