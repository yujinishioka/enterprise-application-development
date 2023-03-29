package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundException;

public interface GenericDao<E, K> {
	
	void salvar(E entidade);
	void deletar(K id) throws EntityNotFoundException;
	E buscar(K id) throws EntityNotFoundException;
	void commit() throws CommitException;
	
}
