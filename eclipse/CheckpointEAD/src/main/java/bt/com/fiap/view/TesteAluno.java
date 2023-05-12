package bt.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.AlunoDaoImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteAluno {

	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		AlunoDao alunoDao = new AlunoDaoImpl(em);

		Aluno aluno = new Aluno("Leandro", "45715089808", "553381672", "Rua Cândido Fontoura", "11982769048", "lbraga@avla.com");

		// Cadastro
		try {
			alunoDao.salvar(aluno);
			alunoDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		//Busca
		Aluno alunoBanco = null;
		try {
			alunoBanco = alunoDao.buscar(1L);
			System.out.println(aluno.getNome());
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		//Atualização
		try {
			alunoBanco.setNome("Churros");
			alunoDao.salvar(alunoBanco);
			alunoDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		//Deleção
		try {
			alunoDao.deletar(1L);
			alunoDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
	
	}
}
