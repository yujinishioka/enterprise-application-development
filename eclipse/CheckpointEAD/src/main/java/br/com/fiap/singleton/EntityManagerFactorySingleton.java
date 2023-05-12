package br.com.fiap.singleton;

import java.util.Objects;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory emFactory;
	
	private EntityManagerFactorySingleton() {}
	
	public static EntityManagerFactory getInstance() {
		if (Objects.isNull(emFactory)) {
			emFactory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emFactory;	
	}
}
