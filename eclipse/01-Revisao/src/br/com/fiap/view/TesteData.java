package br.com.fiap.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteData {
	public static void main(String[] args) {
		// Cria um objeto do tipo Calendar com a data atual
		Calendar dataHoje = Calendar.getInstance();
		
		Calendar data = new GregorianCalendar(2023, Calendar.NOVEMBER, 30);
		
		// Formata a String da Data
		SimpleDateFormat formatado = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		// Exibe a Data
		System.out.println(formatado.format(dataHoje.getTime()));
		
		System.out.println(formatado.format(data.getTime()));
	}
}
