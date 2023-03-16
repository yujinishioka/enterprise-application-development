package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Usuario;

public class TesteAtualizacao {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario user = em.find(Usuario.class, 1);
		em.merge(user).setAltura(1.8f);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
	}

}
