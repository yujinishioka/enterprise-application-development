package br.com.fiap.dao;

import br.com.fiap.entity.Usuario;

public interface UsuarioDao {
	
	void cadastrar(Usuario usuario);
	Usuario pesquisar(int id);
	void atualizar(Usuario usuario);
	void deletar(int id);

}
