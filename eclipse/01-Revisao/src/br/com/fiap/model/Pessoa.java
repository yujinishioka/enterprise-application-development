package br.com.fiap.model;

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
	
	// Constructor
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
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
}
