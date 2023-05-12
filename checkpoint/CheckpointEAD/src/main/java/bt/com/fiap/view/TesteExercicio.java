package bt.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ExercicioDao;
import br.com.fiap.dao.ExercicioDaoImpl;
import br.com.fiap.entity.Equipamento;
import br.com.fiap.entity.Exercicio;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteExercicio {

	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		ExercicioDao exercicioDao = new ExercicioDaoImpl(em);

		Exercicio exercicio = new Exercicio("Rosca martelo", "Trabalha todo o músculo do bíceps", "Bíceps");
		
		// Cadastro
				try {
					exercicioDao.salvar(exercicio);
					exercicioDao.commit();
				} catch (Exception ex) {
					ex.getMessage();
				}

				// Busca
				Exercicio exercicioBanco = null;
				try {
					exercicioBanco = exercicioDao.buscar(1L);
					System.out.println(exercicio.getNome());
				} catch (Exception ex) {
					ex.getMessage();
				}

				// Atualização
				try {
					exercicioBanco.setNome("Rosca direto");
					exercicioDao.salvar(exercicioBanco);
					exercicioDao.commit();
				} catch (Exception ex) {
					ex.getMessage();
				}

				// Deleção
				try {
					exercicioDao.deletar(1L);
					exercicioDao.commit();
				} catch (Exception ex) {
					ex.getMessage();
				}
	}

}
