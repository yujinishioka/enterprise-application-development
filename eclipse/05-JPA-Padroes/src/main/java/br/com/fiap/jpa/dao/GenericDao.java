package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundedException;

public interface GenericDao<E, K> {
	
	void salvar(E entidade);
	void deletar(K id) throws EntityNotFoundedException;
	E buscar(K id) throws EntityNotFoundedException;
	void commit() throws CommitException;
	
}
