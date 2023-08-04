package br.com.fiap.view;

import java.util.ArrayList;
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
		
		// Listar clientes com limites
		clientes = clienteDao.listar(1, 2);
		System.out.println("Clientes");
		for(Cliente c: clientes) {
			System.out.println(c.getNome());
		}
		
		// Buscar por parte do nome
		String busca = "A";
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
		
		int qtd = 10;
		List<Cliente> clientesPorDiasReserva = clienteDao.listarPorDiaReserva(qtd);
		System.out.println("Clientes por dias de Reserva: ");
		for(Cliente c: clientesPorDiasReserva) {
			System.out.println(c.getNome());
		}
		
		String nome = "ia";
		String cidade = "or";
		clientes = clienteDao.listarPorParteNomeCidade(nome, cidade);
		System.out.println("Clientes por parte do Nome e parte da Cidade: ");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		List<String> estados = new ArrayList<String>();
		estados.add(uf);
		estados.add("SP");
		clientes = clienteDao.listarPorEstados(estados);
		System.out.println("Cidades por Estados");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome()));
		
		long qtd1 = clienteDao.contarPorEstado("PR");
		System.out.println("Quantidade de clientes: " + qtd1);
	}
}
