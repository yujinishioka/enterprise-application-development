package br.com.fiap.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import br.com.fiap.exception.CommitException;

public abstract class GenericDaoImpl<E,K> implements GenericDao<E, K>{

	private EntityManager em;
	
	private Class<E> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType) 
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	public void salvar(E entidade) {
		em.persist(entidade);
	}
	
	public void alterar(E entity) {
		em.merge(entity);
	}

	public void deletar(K id) throws EntityNotFoundException {
		E entidade = buscar(id);
		if (entidade == null){
			throw new EntityNotFoundException("Entidade nao encontrada");
		}
		em.remove(entidade);
	}

	public E buscar(K id) throws EntityNotFoundException {
		E entidade = em.find(clazz, id);
		if (Objects.isNull(entidade)) {
			throw new EntityNotFoundException("Entidade nao encontrada");
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
	
	public List<E> listar() {
		return em.createQuery("from " + clazz.getName(), clazz)
				.getResultList();
	}

}
