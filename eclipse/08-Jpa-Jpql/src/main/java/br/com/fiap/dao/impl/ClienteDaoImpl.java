package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente,Integer> implements ClienteDao{

	public ClienteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Cliente> listarPorNome(String busca) {
		return em.createQuery("from Cliente where upper(nome) like :b ", Cliente.class)
				.setParameter("b", "%" + busca.toUpperCase() + "%")
				.getResultList();
	}

	public List<Cliente> listarPorEstado(String uf) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :e", Cliente.class)
				.setParameter("e", uf)
				.getResultList();
	}
	
	public List<Cliente> listarPorEstados(List<String> uf) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf in :es", Cliente.class)
				.setParameter("es", uf)
				.getResultList();
	}

	public List<Cliente> listarPorDiaReserva(int dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d", Cliente.class)
				.setParameter("d", dias)
				.getResultList();
	}

	public List<Cliente> listarPorParteNomeCidade(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :nom and c.endereco.cidade.nome like :cid", Cliente.class)
				.setParameter("nom", "%" + nome + "%")
				.setParameter("cid", "%" + cidade + "%")
				.getResultList();
	}

}
