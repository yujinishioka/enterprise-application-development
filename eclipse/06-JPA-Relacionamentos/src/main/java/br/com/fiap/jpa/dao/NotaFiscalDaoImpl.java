package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundedException;

public class NotaFiscalDaoImpl extends GenericDaoImpl<NotaFiscal, Integer> implements NotaFiscalDao {
	
	private EntityManager em;

	public NotaFiscalDaoImpl(EntityManager em) {
		super(em);
		this.em = em;
	}
	
	public void salvar(NotaFiscal notaFiscal) {
		em.persist(notaFiscal);
	}

	public void deletar(Integer id) throws EntityNotFoundedException {
		NotaFiscal notaFiscal = buscar(id);
		em.remove(notaFiscal);
	}

	public NotaFiscal buscar(Integer id) throws EntityNotFoundedException {
		NotaFiscal notaFiscal = em.find(NotaFiscal.class, id);
		if (notaFiscal == null) {
			throw new EntityNotFoundedException();
		}
		return notaFiscal;
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
