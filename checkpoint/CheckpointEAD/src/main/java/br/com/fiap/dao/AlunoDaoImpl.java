package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Aluno;

public class AlunoDaoImpl extends GenericDaoImpl<Aluno, Long> implements AlunoDao {

	public AlunoDaoImpl(EntityManager em) {
		super(em);
	}

}
