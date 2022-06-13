package br.com.testeesigfullstack.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.testeesigfullstack.model.Responsavel;
import br.com.testeesigfullstack.repository.ResponsavelRepository;


@RestController
@RequestMapping("/api/responsavel")
public class ResponsavelResource {

	

	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Responsavel saveResponsavel(@RequestBody @Valid Responsavel responsavel) {
		
		return responsavelRepository.save(responsavel);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updtadeResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavelUpdated) {
		responsavelRepository.findById(id).map(responsavel ->{
			responsavelUpdated.setId(responsavel.getId());
			return responsavelRepository.save(responsavelUpdated);
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public List<Responsavel> findAllResponsavel(){
		return responsavelRepository.findAll();
	}
	
	
	@GetMapping("{id}")
	public Responsavel findById(@PathVariable Long id) throws Exception{
		return responsavelRepository.findById(id).orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Responsável não encontrado"));
	}
		
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteResponsavel(@PathVariable Long id) {
		responsavelRepository.findById(id).map(responsavel -> {
			responsavelRepository.delete(responsavel);
			return Void.TYPE;
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	
}
