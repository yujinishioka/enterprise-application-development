package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Treino;

public class TreinoDaoImpl extends GenericDaoImpl<Treino, Long> implements TreinoDao {

	public TreinoDaoImpl(EntityManager em) {
		super(em);
	}

}
