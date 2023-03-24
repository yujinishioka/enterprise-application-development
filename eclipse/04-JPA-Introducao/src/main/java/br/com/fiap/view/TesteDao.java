package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.UsuarioDaoImpl;
import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public class TesteDao {

	public static void main(String[] args) throws EntityNotFoundException {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		UsuarioDaoImpl dao = new UsuarioDaoImpl(em);
		Usuario user = new Usuario("Tiago", "Fiap123", "17528457312", "thiago@fiap.com.br", 1.8f, TipoUsuario.ADMIN);
		
		try {
			dao.cadastrar(user);
			dao.commit();
			System.out.println("Usuario cadastrado com sucesso.");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Usuario busca = dao.pesquisar(1);
			System.out.println(busca.getNome());
		} catch(EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		user.setNome("Thiago");
		try {
			dao.atualizar(user);
			dao.commit();
			System.out.println("Usuario atualizado com sucesso.");
		} catch(EntityNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.deletar(4);
			dao.commit();
			System.out.println("Usuario removido com sucesso.");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
	}

}
