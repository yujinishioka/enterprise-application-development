package br.com.fiap.model;

import java.util.Calendar;

public class Pessoa {
	
	// Modificadores de Acesso
	// private - somente a classe
	// default/package - pacote
	// protected - pacote e classes filhas
	// public - todas
	//
	// Classes: tipo de referencia (padrão null)
	// Primitivo: char, boolean, byte, short, int, long, float, double (padrão 0 / false)
	
	private String nome;
	private int idade;
	private Genero genero;
	private Calendar dataNascimento;

	// Constructor
	public Pessoa(String nome, Genero genero, Calendar dataNascimento) {
		this.nome = nome;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.idade = Calendar.getInstance().getWeekYear() - dataNascimento.getWeekYear() - 
				(dataNascimento.after(Calendar.getInstance()) ? 0 : 1);
	}
	
	// Métodos
	public void descansar() {
		System.out.println(" Pessoa descansa.");
	}
	
	// Getters e Setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
