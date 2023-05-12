package bt.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TurmaDao;
import br.com.fiap.dao.TurmaDaoImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.Turma;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteOneToMany {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		TurmaDao turmaDao = new TurmaDaoImpl(em);
		
		Professor professor1 = new Professor("Thiago", "11676853855", "Rua Augusto Paulino", "11960481297", "thiago@fiap.com.br", "Treino Funcional");
		Turma turma1 = new Turma("Turma iniciantes manhã", "Dedicada para alunos da manhã nos primeiros meses", "11h - 13h", professor1);
		Aluno aluno1 = new Aluno("Vinicius", "41857996836", "536200671", "R. Nossa Senhora Mae dos Homens", "11971373425", "rm92895@fiap.com.br", turma1);
		Aluno aluno2 = new Aluno("Leandro", "45715089808", "553381672", "Rua Cândido Fontoura", "11982769048", "lbraga@avla.com", turma1);

		turma1.addAluno(aluno1);
		turma1.addAluno(aluno2);
		
		try {
			turmaDao.salvar(turma1);
			turmaDao.commit();
			System.out.println("Turma e alunos cadastrados com sucesso.");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
	}
}
