package br.com.fiap.dao;

import br.com.fiap.anotacao.Tabela;

public class OrmDao {
	
	// Metodo que recebe um Object e exibe o comando SQL
	public void pesquisar(Object obj) {
		
		// Recuperar anotacao @Tabela da classe
		Tabela anotacao = obj.getClass().getAnnotation(Tabela.class);
		
		// Recuperar nome configurado da anotacao @Tabela
		String nomeTabela = anotacao.nome();
		
		System.out.println("SELECT * FROM " + nomeTabela);
	}
}
