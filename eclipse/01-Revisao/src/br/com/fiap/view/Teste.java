package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.model.Aluno;
import br.com.fiap.model.Genero;

public class Teste {
	// Main
	public static void main(String[] args) {
		Calendar data = new GregorianCalendar(1996, Calendar.MAY, 16);
		// Instancia o aluno
		Aluno aluno1 = new Aluno("Vinicius Yuji Nishioka", Genero.MASCULINO, data, 92895);
		
		// Imprime os dados do aluno
		System.out.println(
				" Nome: " + aluno1.getNome() +
				" | Idade: " + aluno1.getIdade() +
				" | Matricula: " + aluno1.getMatricula()
		);
		
		aluno1.descansar();
		
		if (aluno1.getNome() == "Vinicius Yuji Nishioka")
			System.out.println(" Sim");
		else
			System.out.println(" Não");
	}
}
