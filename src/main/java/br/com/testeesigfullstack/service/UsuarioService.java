package br.com.testeesigfullstack.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.testeesigfullstack.exception.VerificaUsuarioException;
import br.com.testeesigfullstack.model.Usuario;
import br.com.testeesigfullstack.repository.UsuarioRepository;


@Service
public class UsuarioService implements UserDetailsService{
	

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByLogin(login).orElseThrow(()->new UsernameNotFoundException("Login inválido"));
		
		return User.builder().username(user.getLogin()).password(user.getSenha()).roles("USER").build();
	}
	
	public Usuario save(Usuario usuario) {
		
		boolean exists = usuarioRepository.existsByLogin(usuario.getLogin());
		
		if(exists) {
			throw new VerificaUsuarioException(usuario.getLogin());
		}
		
		return usuarioRepository.save(usuario);
	}

}
