package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EnderecoDao;
import br.com.fiap.entity.Endereco;

public class EnderecoDaoImpl extends GenericDaoImpl<Endereco,Integer> implements EnderecoDao{

	public EnderecoDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
