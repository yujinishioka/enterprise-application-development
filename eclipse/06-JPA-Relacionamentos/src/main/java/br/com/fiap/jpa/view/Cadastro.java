package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaFiscalDao;
import br.com.fiap.jpa.dao.NotaFiscalDaoImpl;
import br.com.fiap.jpa.dao.PedidoDao;
import br.com.fiap.jpa.dao.PedidoDaoImpl;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	public static void main(String[] args) {
	
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		EntityManager em = fabrica.createEntityManager();
		
		PedidoDao pedidoDao = new PedidoDaoImpl(em);
		NotaFiscalDao notaFiscalDao = new NotaFiscalDaoImpl(em);
		
		Pedido pedido = new Pedido(Calendar.getInstance(), 50.0f);
		
		pedidoDao.salvar(pedido);
		
		NotaFiscal notaFiscal = new NotaFiscal(Calendar.getInstance(), 50.0f);
		
		notaFiscalDao.salvar(notaFiscal);
		
	}
}
