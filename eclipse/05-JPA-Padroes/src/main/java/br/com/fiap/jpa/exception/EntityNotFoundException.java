package br.com.fiap.jpa.exception;

public class EntityNotFoundException extends Exception {
	
	public EntityNotFoundException() {
		super("Entidade nao encontrada");
	}
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}

}
