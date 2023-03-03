package br.com.fiap.model;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;

@Tabela(nome = "TAB_ANIMAL")
public class Animal {
	
	@Coluna(nome = "nm_raca", tamanho = 15, obrigatorio = true)
	private String raca;
	
	@Coluna(nome = "nr_peso")
	private float peso;
	
	@Coluna(nome = "nr_idade")
	private int idade;

	@Coluna(nome = "")
	public void andar() {
		System.out.println("Animal andando");
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
