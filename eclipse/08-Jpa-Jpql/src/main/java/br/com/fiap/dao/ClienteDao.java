package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDao extends GenericDao<Cliente,Integer>{
	
	List<Cliente> listarPorNome(String busca);
	
	List<Cliente> listarPorEstado(String uf);
	
	List<Cliente> listarPorEstados(List<String> uf);
	
	List<Cliente> listarPorDiaReserva(int dias);
	
	List<Cliente> listarPorParteNomeCidade(String nome, String cidade);

}
