package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Usuario;

public class TestePesquisa {

	public static void main(String[] args) {
		// Fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		// Criar o Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		// Pesquisar o usuario pela PK
		Usuario user = em.find(Usuario.class, 1);
		
		// Exibir
		System.out.println(user.toString());
	}

}
