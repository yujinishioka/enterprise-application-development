package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.LivroDao;
import br.com.fiap.jpa.dao.LivroDaoImpl;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) throws CommitException, EntityNotFoundException {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		LivroDao dao = new LivroDaoImpl(em);
		
		List<String> lista = new ArrayList<String>();
		
		Livro livro = new Livro("It", Genero.HORROR, 1138, new GregorianCalendar(15, Calendar.SEPTEMBER, 1986));
		
		try {
			dao.salvar(livro);
			dao.commit();
			System.out.println("Livro cadastrado");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		dao.buscar(1);
		
	}

}
