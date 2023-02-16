package br.com.fiap.model;

import java.util.Calendar;

public class Aluno extends Pessoa {
	
	int matricula;

	// Sobrecarga: Adicionar métodos com mesmo nome, mas parametros diferentes
	public Aluno(String nome, Genero genero, Calendar dataNascimento) {
		super(nome, genero, dataNascimento);
		setMatricula(11111);
	}
	
	public Aluno(String nome, Genero genero, Calendar dataNascimento, int matricula) {
		super(nome, genero, dataNascimento);
		this.matricula = matricula;
	}
	
	// Sobrescrita de método pai implementado na filha
	@Override
	public void descansar() {
		System.out.println(" Aluno estuda.");
		super.descansar();
	}
	
	public void imprimirAluno(Aluno aluno) {
		System.out.println(
				"NOME: " + aluno.getNome() + 
				"\nGENERO: " + aluno.getGenero() + 
				"\nIDADE: " + aluno.getIdade() + " anos."
		);
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
}
