package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private EntityManager em;

	public UsuarioDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Usuario usuario) {
		em.persist(usuario);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	public Usuario pesquisar(int id) {
		Usuario user = em.find(Usuario.class, id);
		return user;
	}

	public void atualizar(Usuario usuario) {
		em.merge(usuario);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	public void deletar(int id) {
		Usuario user = em.find(Usuario.class, id);
		em.remove(user);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

}
