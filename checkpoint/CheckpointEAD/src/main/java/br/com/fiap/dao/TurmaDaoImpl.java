package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Turma;

public class TurmaDaoImpl extends GenericDaoImpl<Turma, Long> implements TurmaDao {

	public TurmaDaoImpl(EntityManager em) {
		super(em);
	}

}
