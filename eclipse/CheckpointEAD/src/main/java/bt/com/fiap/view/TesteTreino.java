package bt.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.TreinoDao;
import br.com.fiap.dao.TreinoDaoImpl;
import br.com.fiap.entity.Treino;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteTreino {

	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		TreinoDao treinoDao = new TreinoDaoImpl(em);

		Treino treino = new Treino("Funcional Noite", "Treino funcional para iniciantes", "18h", 90);

		// Cadastro
		try {
			treinoDao.salvar(treino);
			treinoDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}

		// Busca
		Treino treinoBanco = null;
		try {
			treinoBanco = treinoDao.buscar(1L);
			System.out.println(treino.getNome());
		} catch (Exception ex) {
			ex.getMessage();
		}

		// Atualização
		try {
			treinoBanco.setDescricao("Treino funcional para churros");
			treinoDao.salvar(treinoBanco);
			treinoDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}

		// Deleção
		try {
			treinoDao.deletar(1L);
			treinoDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
}
