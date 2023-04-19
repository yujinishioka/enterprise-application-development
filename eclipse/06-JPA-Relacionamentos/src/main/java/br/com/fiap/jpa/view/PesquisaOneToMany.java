package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ClienteDao;
import br.com.fiap.jpa.dao.ClienteDaoImpl;
import br.com.fiap.jpa.exception.EntityNotFoundedException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class PesquisaOneToMany {

	public static void main(String[] args) throws EntityNotFoundedException {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		
		System.out.println(clienteDao.pesquisar(1).getNomeCliente());
	}
}
