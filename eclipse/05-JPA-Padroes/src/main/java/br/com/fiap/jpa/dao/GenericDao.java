package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundedException;

public interface GenericDao<E, K> {
	
	E salvar(E entidade);
	void deletar(K id) throws EntityNotFoundedException;
	E pesquisar(K id) throws EntityNotFoundedException;
	void commit() throws CommitException;
	
}
