package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Exercicio;

public class ExercicioDaoImpl extends GenericDaoImpl<Exercicio, Long> implements ExercicioDao {

	public ExercicioDaoImpl(EntityManager em) {
		super(em);
	}

}
