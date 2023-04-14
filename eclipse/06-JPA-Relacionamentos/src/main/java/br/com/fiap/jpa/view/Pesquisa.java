package br.com.fiap.jpa.view;

import java.text.DecimalFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaFiscalDao;
import br.com.fiap.jpa.dao.NotaFiscalDaoImpl;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {
		
		float taxa = 0.1f;
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		NotaFiscalDao notaFiscalDao = new NotaFiscalDaoImpl(em);
		
		try {
			NotaFiscal nota = notaFiscalDao.pesquisar(2);
			System.out.println(
				"----------------------------------" +
				"\n            Mercadinho            " +
				"\n----------------------------------" +
				"\nGerente: Vinicius Yuji" +
				"\nData: " + nota.getDataNota().getTime() +
				"\nTaxa: " + taxa + "%" +
				"\n----------------------------------" +
				"\nValor do Pedido: R$ " + new DecimalFormat(".##").format(nota.getPedido().getValorPedido()) +
				"\nValor da Nota: R$ " + new DecimalFormat(".##").format(nota.getValorNota()) +
				"\nValor Total: R$ " + new DecimalFormat(".##").format(nota.getValorNota()*(1 + taxa)) +
				"\n----------------------------------"
			);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
