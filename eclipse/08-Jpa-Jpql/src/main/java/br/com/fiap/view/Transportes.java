package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TransporteDao;
import br.com.fiap.dao.impl.TransporteDaoImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Transportes {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		TransporteDao transporteDao = new TransporteDaoImpl(em);
	}
}
