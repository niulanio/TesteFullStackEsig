package br.com.testeesigfullstack.exception;



import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrors {
	
	@Getter
	private List<String> errors;
	
	
	
	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public ApiErrors(String messege) {
		this.errors = Arrays.asList(messege);
	}
}
