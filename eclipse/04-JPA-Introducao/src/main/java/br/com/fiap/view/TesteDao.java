package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.UsuarioDaoImpl;
import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.EntityNotFoundException;

public class TesteDao {

	public static void main(String[] args) throws EntityNotFoundException {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		UsuarioDaoImpl user = new UsuarioDaoImpl(em);
		Usuario novoUser = new Usuario("Thiago", "Fiap123", "17528457312", "thiago@fiap.com.br", 1.8f, TipoUsuario.ADMIN);
		
		user.cadastrar(novoUser);
		
		user.pesquisar(1);
		
		user.atualizar(novoUser);
		
		user.deletar(2);
		
	}

}
