package br.com.fiap.view;

import br.com.fiap.model.Aluno;

public class Teste {
	// Main
	public static void main(String[] args) {
		// Instancia o aluno
		Aluno aluno1 = new Aluno("Vinicius Yuji Nishioka", 26, 92895);
		
		// Imprime os dados do aluno
		System.out.println(
				" Nome: " + aluno1.getNome() +
				" | Idade: " + aluno1.getIdade() +
				" | Matricula: " + aluno1.getMatricula()
		);
		
		aluno1.descansar();
	}
}
