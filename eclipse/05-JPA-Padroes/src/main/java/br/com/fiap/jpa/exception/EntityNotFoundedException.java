package br.com.fiap.jpa.exception;

public class EntityNotFoundedException extends Exception {
	
	public EntityNotFoundedException() {
		super("Entidade nao encontrada");
	}
	
	public EntityNotFoundedException(String msg) {
		super(msg);
	}

}
