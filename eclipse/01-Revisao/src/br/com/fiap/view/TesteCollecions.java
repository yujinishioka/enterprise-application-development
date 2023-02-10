package br.com.fiap.view;

import java.util.Scanner;

public class TesteCollecions {
	public static void main(String[] args) {
		String palavra;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Digite uma palavra (ou 'sair' para sair): ");
			palavra = sc.next();
			System.out.println("Palavra digitada: " + palavra);			
		} while (!palavra.equals("sair"));
		
		System.out.println("Saindo...");
		sc.close();
	}
}
