package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundedException;

public class PedidoDaoImpl extends GenericDaoImpl<Pedido, Integer> implements PedidoDao {
	
	private EntityManager em;

	public PedidoDaoImpl(EntityManager em) {
		super(em);
		this.em = em;
	}

	public Pedido salvar(Pedido pedido) {
		return em.merge(pedido);
	}

	public void deletar(Integer id) throws EntityNotFoundedException {
		Pedido pedido = pesquisar(id);
		em.remove(pedido);
	}

	public Pedido pesquisar(Integer id) throws EntityNotFoundedException {
		Pedido pedido = em.find(Pedido.class, id);
		if (pedido == null) {
			throw new EntityNotFoundedException();
		}
		return pedido;
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}
