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
import br.com.fiap.jpa.exception.EntityNotFoundedException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) throws CommitException, EntityNotFoundedException {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		LivroDao dao = new LivroDaoImpl(em);
		
		List<String> lista = new ArrayList<String>();
		
		//Livro livro = new Livro("It", Genero.HORROR, 1138, new GregorianCalendar(15, Calendar.SEPTEMBER, 1986));
		Livro livro = new Livro("Tomie", Genero.HORROR, 1138, new GregorianCalendar(01, Calendar.APRIL, 1987));
		
		try {
			dao.salvar(livro);
			dao.commit();
			System.out.println("Livro cadastrado");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Livro busca = dao.pesquisar(1);
			System.out.println(busca.getTitulo());
		} catch(EntityNotFoundedException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			livro.setPagina(376);
			dao.salvar(livro);
			dao.commit();
			System.out.println("Livro atualizado com sucesso.");
		} catch(CommitException e) {
			System.err.println(e.getMessage());
		}
		
		/*
		try {
			dao.deletar(2);
			dao.commit();
			System.out.println("Livro deletado com sucesso.");
		} catch(CommitException e) {
			System.err.println(e.getMessage());
		}
		*/
		
	}

}
