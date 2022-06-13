package br.com.testeesigfullstack.resource;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.testeesigfullstack.enums.Prioridade;
import br.com.testeesigfullstack.enums.Status;
import br.com.testeesigfullstack.model.Tarefa;
import br.com.testeesigfullstack.repository.TarefaRepository;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaResource {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tarefa save(@RequestBody @Valid Tarefa tarefa) {

		return tarefaRepository.save(tarefa);
	}
	
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updtadeTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaUpdated) {
		tarefaRepository.findById(id).map(tarefa ->{
			tarefaUpdated.setId(tarefa.getId());
			return tarefaRepository.save(tarefaUpdated);
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public List<Tarefa> findAllTarefas(){
		return tarefaRepository.findAll();
	}
	
	
	@GetMapping("{id}")
	public Tarefa findById(@PathVariable Long id) throws Exception{
		return tarefaRepository.findById(id).orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada"));
	}
	
	@GetMapping("/status/{status}")
	public List<Tarefa> findByStatus(@PathVariable Integer status) throws Exception{
		Optional<List<Tarefa>> list = tarefaRepository.findByStatus(Status.toEnum(status));
		
		return list.orElseThrow(()-> new Exception("Erro ao consultar Tarefa"));
		
	}
	
	@GetMapping("/prioridade/{prioridade}")
	public List<Tarefa> findByPrioridade(@PathVariable Integer prioridade) throws Exception{
		Optional<List<Tarefa>> list = tarefaRepository.findByPrioridade(Prioridade.toEnum(prioridade));
		
		return list.orElseThrow(()-> new Exception("Erro ao consultar Tarefa"));
		
	}
	
	@GetMapping("/responsavel/{id_responsavel}")
	public List<Tarefa> findByResponsavel(@PathVariable Long id_responsavel) throws Exception{
		Optional<List<Tarefa>> list = tarefaRepository.findByResponsavel(id_responsavel);
		
		return list.orElseThrow(()-> new Exception("Erro ao consultar Tarefa"));
		
	}
	@GetMapping("/titulo/{titulo}")
	public List<Tarefa> findByTitulo(@PathVariable String titulo) throws Exception{
		Optional<List<Tarefa>> list = tarefaRepository.findByTitulo("%"+titulo+"%");
		
		return list.orElseThrow(()-> new Exception("Erro ao consultar Tarefa"));
		
	}
	
	@GetMapping("/tarefaAvancada")
	public List<Tarefa> findByTarefasPersonalizado(
			@RequestParam(value="titulo", required = false, defaultValue = "")String titulo,
			@RequestParam(value="id_responsavel", required = false)Long id_responsavel,
			@RequestParam(value = "prioridade",required=false) Integer prioridade,
			@RequestParam(value="status",required = false)Integer status
			){
		
		if(prioridade!= null && status == null) {
			return tarefaRepository.findByTituloAndResponsavelAndPrioridade("%"+titulo+"%",id_responsavel,Prioridade.toEnum(prioridade));
		}else if(prioridade== null && status != null) {
			return tarefaRepository.findByTituloAndResponsavelAndStatus("%"+titulo+"%",id_responsavel,Status.toEnum(status));
		}else if(prioridade== null && status == null) {
			return tarefaRepository.findByTituloAndResponsavel("%"+titulo+"%",id_responsavel);
		}
		
		return tarefaRepository.findByTituloAndResponsavelAndPrioridadeAndStatus("%"+titulo+"%",id_responsavel,Prioridade.toEnum(prioridade),Status.toEnum(status));
		
	}
	
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTarefa(@PathVariable Long id) {
		tarefaRepository.findById(id).map(tarefa -> {
			tarefaRepository.delete(tarefa);
			return Void.TYPE;
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
