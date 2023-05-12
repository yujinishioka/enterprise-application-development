package bt.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.TurmaDao;
import br.com.fiap.dao.TurmaDaoImpl;
import br.com.fiap.entity.Turma;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteTurma {
	
	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		TurmaDao turmaDao = new TurmaDaoImpl(em);

		Turma turma = new Turma("Turma iniciantes manhã", "Dedicada para alunos da manhã nos primeiros meses", "11h");

		// Cadastro
		try {
			turmaDao.salvar(turma);
			turmaDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}

		// Busca
		Turma turmaBanco = null;
		try {
			turmaBanco = turmaDao.buscar(1L);
			System.out.println(turma.getNome());
		} catch (Exception ex) {
			ex.getMessage();
		}

		// Atualização
		try {
			turmaBanco.setDescricao("Turma dedicada para os sedentários q n fazem nada");
			turmaDao.salvar(turmaBanco);
			turmaDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}

		// Deleção
		try {
			turmaDao.deletar(1L);
			turmaDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}

	}
}
