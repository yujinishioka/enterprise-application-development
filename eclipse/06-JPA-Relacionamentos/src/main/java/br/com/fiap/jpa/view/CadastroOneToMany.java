package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ClienteDao;
import br.com.fiap.jpa.dao.ClienteDaoImpl;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroOneToMany {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		
		Cliente cliente = new Cliente("Guilherme", new GregorianCalendar(2002, Calendar.APRIL, 22));
		Pedido pedido1 = new Pedido(Calendar.getInstance(), 35.80f, cliente);
		Pedido pedido2 = new Pedido(Calendar.getInstance(), 60.0f, cliente);
		
		cliente.addPedido(pedido1);
		cliente.addPedido(pedido2);
		
		try {
			clienteDao.salvar(cliente);
			clienteDao.commit();
			System.out.println("Cliente e Pedido cadastrados com sucesso.");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
	}
}
