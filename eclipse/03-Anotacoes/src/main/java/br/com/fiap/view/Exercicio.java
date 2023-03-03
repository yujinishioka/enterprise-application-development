package br.com.fiap.view;

import br.com.fiap.dao.OrmDao;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Animal;

public class Exercicio {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		
		OrmDao ormDao = new OrmDao();
		
		ormDao.pesquisar(aluno);
		
		Animal animal = new Animal();
		
		ormDao.pesquisar(animal);
	}
}
