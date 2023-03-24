package br.com.fiap.exception;

public class EntityNotFoundException extends Exception {

	public EntityNotFoundException() {
		super("Erro na busca");
	}
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}
	
}
