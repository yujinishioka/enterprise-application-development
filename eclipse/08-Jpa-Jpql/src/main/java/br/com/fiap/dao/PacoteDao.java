package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDao extends GenericDao<Pacote,Integer>{
	
	List<Pacote> listar();
	
	List<Pacote> listarPorPrecoMaior(float preco);
	
	List<Pacote> listarPorTransporte(Transporte transporte);
	
	List<Pacote> listarPorDatas(Calendar inicio, Calendar fim);

}
