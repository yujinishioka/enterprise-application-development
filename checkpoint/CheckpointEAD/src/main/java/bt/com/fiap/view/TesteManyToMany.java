package bt.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.*;
import br.com.fiap.entity.*;
import br.com.fiap.enums.TipoEquipamento;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteManyToMany {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ExercicioDao exercicioDao = new ExercicioDaoImpl(em);
		
		Calendar dataCompra = new GregorianCalendar(2023, Calendar.JANUARY, 1);
		Equipamento equipamento1 = new Equipamento("Barra Fixa", 3, "Ala B", TipoEquipamento.MUSCULACAO, dataCompra);
		Equipamento equipamento2 = new Equipamento("Aparelho Eliptico", 2, "Ala B", TipoEquipamento.CARDIO, dataCompra);
		Equipamento equipamento3 = new Equipamento("Plataforma Abdominal", 9, "Ala B", TipoEquipamento.CARDIO, dataCompra);
		
		Exercicio exercicio1 = new Exercicio("Rosca martelo", "Trabalha todo o músculo do bíceps", "Bíceps");
		Exercicio exercicio2 = new Exercicio("Corrida", "Trabalha os músculos cardiovasculares", "Coracao");
		
		exercicio1.addEquipamento(equipamento1);
		exercicio2.addEquipamento(equipamento2);
		exercicio2.addEquipamento(equipamento3);
		
		try {
			exercicioDao.salvar(exercicio1);
			exercicioDao.salvar(exercicio2);
			exercicioDao.commit();
			System.out.println("Equipamentos e Exercicios cadastrados com sucesso.");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		} 
	}
}
