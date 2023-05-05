package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.impl.ClienteDaoImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Clientes {
	public static void main(String[] args){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		
		// Listar clientes
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("Clientes");
		for(Cliente c: clientes) {
			System.out.println(c.getNome());
		}
		
		// Buscar por parte do nome
		String busca = "Th";
		List<Cliente> clientesPorNome = clienteDao.listarPorNome(busca);
		System.out.println("Clientes buscados: " + busca);
		for(Cliente c: clientesPorNome) {
			System.out.println(c.getNome());
		}
		
		String uf = "PR";
		List<Cliente> clientesPorEstado = clienteDao.listarPorEstado(uf);
		System.out.println("Clientes do estado: " + uf);
		for(Cliente c: clientesPorEstado) {
			System.out.println(c.getNome());
		}
	}
}
