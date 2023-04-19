package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao {

	public ClienteDaoImpl(EntityManager em) {
		super(em);
	}
}
