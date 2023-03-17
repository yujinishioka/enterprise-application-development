package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;

public class TesteAtualizacao {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario user = new Usuario("Alan", "Fiap@123", "17493857211", "alanzoka@gmail.com", 1.71f, TipoUsuario.DEFAULT);
		user.setCodigo(2);
		
		em.merge(user);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
	}

}
