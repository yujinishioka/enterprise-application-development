package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDaoImpl extends GenericDaoImpl<Pacote,Integer> implements PacoteDao{

	public PacoteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Pacote> listar() {
		TypedQuery<Pacote> query = em.createQuery("from Pacote", Pacote.class);
		return query.getResultList();
	}

	public List<Pacote> listarPorPrecoMaior(float preco) {
		
//		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.preco > :pre", Pacote.class);
//		query.setParameter("pre", preco);
//		return query.getResultList();
		
		return em.createQuery(
				"from Pacote p where p.preco > :pre", Pacote.class)
				.setParameter("pre", preco)
				.getResultList();
	}

	public List<Pacote> listarPorTransporte(Transporte transporte) {
		return em.createQuery(
				"from Pacote p where p.transporte = :t ", Pacote.class)
				.setParameter("t", transporte)
				.getResultList();
	}

}
