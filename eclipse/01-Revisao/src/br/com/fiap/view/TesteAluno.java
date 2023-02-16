package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.model.Aluno;
import br.com.fiap.model.Genero;

public class TesteAluno {
	public static void main(String[] args) {
		
		Calendar data = new GregorianCalendar(1996, Calendar.MAY, 16);
		
		Aluno aluno1 = new Aluno("Vinicius Yuji Nishioka", Genero.MASCULINO, data, 92895);
		
		aluno1.imprimirAluno(aluno1);
	}
}
