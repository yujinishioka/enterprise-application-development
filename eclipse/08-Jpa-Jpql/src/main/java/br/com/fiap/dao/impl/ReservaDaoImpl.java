package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDao;
import br.com.fiap.entity.Reserva;

public class ReservaDaoImpl extends GenericDaoImpl<Reserva,Integer> implements ReservaDao {

	public ReservaDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
