package bt.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ProfessorDao;
import br.com.fiap.dao.ProfessorDaoImpl;
import br.com.fiap.entity.Professor;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteProfessor {

	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		ProfessorDao professorDao = new ProfessorDaoImpl(em);

		Professor professor = new Professor("Thagi", "11676853855", "Rua Augusto Paulino", "11960481297",
				"thiago@fiap.com", "Treino Funcional");
		
		// Cadastro
				try {
					professorDao.salvar(professor);
					professorDao.commit();
				} catch (Exception ex) {
					ex.getMessage();
				}

				// Busca
				Professor professorBanco = null;
				try {
					professorBanco = professorDao.buscar(1L);
					System.out.println(professor.getNome());
				} catch (Exception ex) {
					ex.getMessage();
				}

				// Atualização
				try {
					professorBanco.setEspecialidade("Treinamento de idosos");
					professorDao.salvar(professorBanco);
					professorDao.commit();
				} catch (Exception ex) {
					ex.getMessage();
				}

				// Deleção
				try {
					professorDao.deletar(1L);
					professorDao.commit();
				} catch (Exception ex) {
					ex.getMessage();
				}
	}
}
