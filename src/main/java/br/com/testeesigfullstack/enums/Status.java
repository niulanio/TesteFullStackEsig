package br.com.testeesigfullstack.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {

	ANDAMENTO(1, "Em andamento"), CONCLUIDA(2, "Concluída");
	
	
	private Integer cod;
	private String prioridade;
	
	
	private Status(Integer cod, String prioridade) {
		this.cod = cod;
		this.prioridade = prioridade;
	}

	@JsonValue
	public Integer getCod() {
		return cod;
	}


	public void setCod(Integer cod) {
		this.cod = cod;
	}


	public String getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
	
	public static Status toEnum(Integer cod) {
		for(Status status : Status.values()) {
			if(cod.equals(status.cod)) {
				return status;
			}
		}
		return null;
	}
}
