package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ClienteDao;
import br.com.fiap.jpa.dao.ClienteDaoImpl;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.exception.EntityNotFoundedException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class PesquisaOneToMany {

	public static void main(String[] args) throws EntityNotFoundedException {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		
		try {
			Cliente cliente = clienteDao.pesquisar(1);
			System.out.println(cliente.getNomeCliente());
			System.out.println("Pedidos");
			for(Pedido pedido : cliente.getPedidos()) {
				System.out.println(pedido.getValorPedido());
				System.out.println("Produtos");
				for(Produto produto : pedido.getProdutos()) {
					System.out.println(produto.getNomeProduto());
				}
			}
		} catch(EntityNotFoundedException e) {
			e.printStackTrace();
		}
	}
}
