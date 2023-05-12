package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Professor;

public class ProfessorDaoImpl extends GenericDaoImpl<Professor, Long> implements ProfessorDao {

	public ProfessorDaoImpl(EntityManager em) {
		super(em);
	}

}
