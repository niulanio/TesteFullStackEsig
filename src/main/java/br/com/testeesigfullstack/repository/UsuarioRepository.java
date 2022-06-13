package br.com.testeesigfullstack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testeesigfullstack.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	public Optional<Usuario> findByLogin(String login);
	
	boolean existsByLogin(String login);
}
