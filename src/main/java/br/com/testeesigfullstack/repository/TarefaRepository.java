package br.com.testeesigfullstack.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.testeesigfullstack.enums.Prioridade;
import br.com.testeesigfullstack.enums.Status;
import br.com.testeesigfullstack.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
	
	@Query("select t from Tarefa t where t.status= :cod")
	public Optional<List<Tarefa>> findByStatus(Status cod);
	
	@Query("select t from Tarefa t where t.prioridade= :cod")
	public Optional<List<Tarefa>> findByPrioridade(Prioridade cod);
	
	@Query("select t from Tarefa t where t.responsavel.id= :id_responsavel")
	public Optional<List<Tarefa>> findByResponsavel(Long id_responsavel);
	
	@Query("select t from Tarefa t  where upper(t.titulo) like upper(:titulo)")
	public Optional<List<Tarefa>> findByTitulo(String titulo);
	
	
	@Query("select t from Tarefa t  where upper(t.titulo) like upper(:titulo) and t.responsavel.id= :id_responsavel and t.prioridade= :prioridade and t.status= :status")
	public List<Tarefa> findByTituloAndResponsavelAndPrioridadeAndStatus(@Param("titulo")String titulo, @Param("id_responsavel")Long id_responsavel,
			@Param("prioridade")Prioridade prioridade, @Param("status")Status status);
	
	@Query("select t from Tarefa t  where upper(t.titulo) like upper(:titulo) and t.responsavel.id= :id_responsavel and t.prioridade= :prioridade")
	public List<Tarefa> findByTituloAndResponsavelAndPrioridade(@Param("titulo")String titulo, @Param("id_responsavel")Long id_responsavel,
			@Param("prioridade")Prioridade prioridade);
	
	@Query("select t from Tarefa t  where upper(t.titulo) like upper(:titulo) and t.responsavel.id= :id_responsavel and t.status= :status")
	public List<Tarefa> findByTituloAndResponsavelAndStatus(@Param("titulo")String titulo, @Param("id_responsavel")Long id_responsavel,
			@Param("status")Status status);
	
	@Query("select t from Tarefa t  where upper(t.titulo) like upper(:titulo) and t.responsavel.id= :id_responsavel")
	public List<Tarefa> findByTituloAndResponsavel(@Param("titulo")String titulo, @Param("id_responsavel")Long id_responsavel);
}
