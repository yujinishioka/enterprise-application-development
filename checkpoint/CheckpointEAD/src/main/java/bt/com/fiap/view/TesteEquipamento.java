package bt.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.EquipamentoDao;
import br.com.fiap.dao.EquipamentoDaoImpl;
import br.com.fiap.entity.Equipamento;
import br.com.fiap.enums.TipoEquipamento;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteEquipamento {

	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		EquipamentoDao equipDao = new EquipamentoDaoImpl(em);

		Calendar dataCompra = new GregorianCalendar(2023, Calendar.JANUARY, 1);

		Equipamento equip = new Equipamento("Barra Fixa", 3, "Ala B", TipoEquipamento.MUSCULACAO, dataCompra);

		// Cadastro
		try {
			equipDao.salvar(equip);
			equipDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}

		// Busca
		Equipamento equipBanco = null;
		try {
			equipBanco = equipDao.buscar(1L);
			System.out.println(equip.getNome());
		} catch (Exception ex) {
			ex.getMessage();
		}

		// Atualização
		try {
			equipBanco.setNome("Cadeira Adutora");
			equipDao.salvar(equipBanco);
			equipDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}

		// Deleção
		try {
			equipDao.deletar(1L);
			equipDao.commit();
		} catch (Exception ex) {
			ex.getMessage();
		}

	}
}
