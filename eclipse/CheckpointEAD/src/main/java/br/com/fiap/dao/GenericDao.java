package br.com.fiap.dao;

import javax.persistence.EntityNotFoundException;

import br.com.fiap.exception.CommitException;

//GenericDao<Cliente, String> dao =
//GenericDao<Produto, Integer> dao2 = 

public interface GenericDao<E,K> {

	void salvar(E entidade);
	void deletar(K id) throws EntityNotFoundException;
	E buscar(K id) throws EntityNotFoundException;
	void commit() throws CommitException;
	
}