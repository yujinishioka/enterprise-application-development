package br.com.fiap.dao;

import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public interface UsuarioDao {
	
	void cadastrar(Usuario usuario);
	Usuario pesquisar(int id) throws EntityNotFoundException;
	void atualizar(Usuario usuario) throws EntityNotFoundException;
	void deletar(int id) throws EntityNotFoundException;
	void commit() throws CommitException;

}