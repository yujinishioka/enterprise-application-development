package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Equipamento;

public class EquipamentoDaoImpl extends GenericDaoImpl<Equipamento, Long> implements EquipamentoDao {

	public EquipamentoDaoImpl(EntityManager em) {
		super(em);
	}

}
