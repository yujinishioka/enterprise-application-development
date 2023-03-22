package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private EntityManager em;

	public UsuarioDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Usuario usuario) {
		em.persist(usuario);
	}

	public Usuario pesquisar(int id) throws EntityNotFoundException {
		Usuario user = em.find(Usuario.class, id);
		if (user == null) {
			throw new EntityNotFoundException();
		}
		return user;
	}

	public void atualizar(Usuario user) throws EntityNotFoundException {
		// Verificar se o usuario existe
		pesquisar(user.getCodigo());
		em.merge(user);
	}

	public void deletar(int id) throws EntityNotFoundException {
		Usuario user = pesquisar(id);
		em.remove(user);
	}
	
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			// Lancar uma Exception
			throw new CommitException();
		}
	}

}
