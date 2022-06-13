package br.com.testeesigfullstack.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.testeesigfullstack.enums.Prioridade;
import br.com.testeesigfullstack.enums.Status;


@Entity
@Table(name = "tarefas")
@Data
public class Tarefa implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false, length = 50)
	@NotNull(message = "O campo titulo é obrigatorio")
	private String titulo;
	
	@Column(nullable = false, length = 500)
	@NotNull(message = "O campo descricao é obrigatorio")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo prioridade é obrigatorio")
	private Prioridade prioridade;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo prioridade é obrigatorio")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "id_responsavel")
	@NotNull(message = "O campo responsavel é obrigatorio")
	private Responsavel responsavel;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "O campo data limite é obrigatorio")
	private LocalDate dataFinal;
	
	@PrePersist
	public void prePersist() {
		setDataCriacao(LocalDate.now());
	}
	
}
