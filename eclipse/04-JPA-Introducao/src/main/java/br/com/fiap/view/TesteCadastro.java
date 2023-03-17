package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;

public class TesteCadastro {

	public static void main(String[] args) {
		// Instanciar Usuario()
		Usuario user = new Usuario("Vinicius Yuji", "Fiap123", "41857996836", "yuu.nishioka@outlook.com", 1.78f, TipoUsuario.ADMIN);
		
		// Fabrica de Entity Manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		// Utilizando a fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// Cadastro do Usuario
		em.persist(user);
		
		// Transacao
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
	
}
