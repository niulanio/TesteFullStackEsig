package br.com.testeesigfullstack.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Prioridade {
	
	ALTA(1, "Alta"), MEDIA(2, "Média"), BAIXA(3, "Baixa");
	
	
	private Integer cod;
	private String prioridade;
	
	
	private Prioridade(Integer cod, String prioridade) {
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
	
	
	public static Prioridade toEnum(Integer cod) {
		for(Prioridade p : Prioridade.values()) {
			if(cod.equals(p.cod)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	
	

}
