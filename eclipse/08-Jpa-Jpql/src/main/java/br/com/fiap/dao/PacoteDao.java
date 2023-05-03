package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pacote;

public interface PacoteDao extends GenericDao<Pacote,Integer>{
	
	List<Pacote> listar();
	
	List<Pacote> listarPorPrecoMaior(float preco);

}
