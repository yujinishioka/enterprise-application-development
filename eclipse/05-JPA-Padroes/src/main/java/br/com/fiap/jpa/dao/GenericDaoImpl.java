package br.com.fiap.jpa.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundedException;

public class GenericDaoImpl<E, K> implements GenericDao<E, K>{
	
	private EntityManager em;
	
	private Class<E> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		// obter ".class" do E em tempo de execucao.
		this.clazz = (Class<E>) ((ParameterizedType)getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public E salvar(E entidade) {
		return em.merge(entidade);
	}

	public void deletar(K id) throws EntityNotFoundedException {
		E entidade = pesquisar(id);
		em.remove(entidade);
	}

	public E pesquisar(K id) throws EntityNotFoundedException {
		E entidade = em.find(clazz, id);
		if (entidade == null) {
			throw new EntityNotFoundedException();
		}
		return entidade;
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}
