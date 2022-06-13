package br.com.testeesigfullstack.exception;

public class VerificaUsuarioException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VerificaUsuarioException(String login) {
		super("Usuário já cadastrado para o login "+login);
	}

}
