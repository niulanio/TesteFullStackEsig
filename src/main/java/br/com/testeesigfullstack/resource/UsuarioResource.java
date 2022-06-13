package br.com.testeesigfullstack.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.testeesigfullstack.exception.VerificaUsuarioException;
import br.com.testeesigfullstack.model.Usuario;
import br.com.testeesigfullstack.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody @Valid Usuario usuario) {
		try {
			usuarioService.save(usuario);
		} catch (VerificaUsuarioException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
