package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TransporteDao;
import br.com.fiap.entity.Transporte;

public class TransporteDaoImpl extends GenericDaoImpl<Transporte,Integer> implements TransporteDao{

	public TransporteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
