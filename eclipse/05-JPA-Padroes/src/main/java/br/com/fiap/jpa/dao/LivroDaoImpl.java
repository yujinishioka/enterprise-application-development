package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Livro;

public class LivroDaoImpl extends GenericDaoImpl<Livro, Integer> implements LivroDao {

	public LivroDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
