package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.TransporteDao;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.dao.impl.TransporteDaoImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pacotes {
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		PacoteDao pacoteDao = new PacoteDaoImpl(em);
		
		List<Pacote> pacotes = pacoteDao.listar();
		System.out.println("Pacotes");
		for(Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getPreco());
		}
		
		pacotes = pacoteDao.listarPorPrecoMaior(2100);
		System.out.println("\nMaiores de R$: 2100");
		for(Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getPreco());
		}
		
		TransporteDao transporteDao = new TransporteDaoImpl(em);
		
		Transporte transporte = transporteDao.pesquisar(1);
		pacotes = pacoteDao.listarPorTransporte(transporte);
		System.out.println("Pacotes pelo transporte: " + transporte.getEmpresa());
		for(Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getTransporte().getEmpresa());
		}
		
		Calendar dataInicio = new GregorianCalendar(2020, Calendar.DECEMBER, 1);
		Calendar dataSaida = new GregorianCalendar(2021, Calendar.DECEMBER, 31);
		pacotes = pacoteDao.listarPorDatas(dataInicio, dataSaida);
		System.out.println("Pesquisar pacotes por Data");
		pacotes.forEach(p -> System.out.println(p.getDescricao()));
		
		double preco = pacoteDao.somarPrecosPorTransporte(transporte);
		System.out.println(preco);
	}
}
