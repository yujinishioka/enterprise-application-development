package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDao;
import br.com.fiap.entity.Cidade;

public class CidadeDaoImpl extends GenericDaoImpl<Cidade,Integer> implements CidadeDao{

	public CidadeDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
