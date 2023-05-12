package bt.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TreinoDao;
import br.com.fiap.dao.TreinoDaoImpl;
import br.com.fiap.entity.Turma;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.Treino;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteOneToOne {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		TreinoDao treinoDao = new TreinoDaoImpl(em);
		
		Professor professor = new Professor("Thiago", "11676853855", "Rua Augusto Paulino", "11960481297", "thiago@fiap.com.br", "Treino Funcional");
		Turma turma = new Turma("Turma iniciantes manhã", "Dedicada para alunos da manhã nos primeiros meses", "11h - 13h", professor);
		Treino treino = new Treino("Funcional Noite", "Treino funcional para iniciantes", "18h", 90, turma);
		
		try {
			treinoDao.salvar(treino);
			treinoDao.commit();
			System.out.println("Treino cadastrado com sucesso.");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
	}
}
