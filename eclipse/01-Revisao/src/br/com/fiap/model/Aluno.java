package br.com.fiap.model;

public class Aluno extends Pessoa {
	
	int matricula;

	// Sobrecarga: Adicionar métodos com mesmo nome, mas parametros diferentes
	public Aluno(String nome, int idade) {
		super(nome, idade);
		setMatricula(11111);
	}
	
	public Aluno(String nome, int idade, int matricula) {
		super(nome, idade);
		this.matricula = matricula;
	}
	
	// Sobrescrita de método pai implementado na filha
	@Override
	public void descansar() {
		System.out.println(" Aluno estuda.");
		super.descansar();
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
}
