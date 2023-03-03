package br.com.fiap.view;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.model.Animal;

public class Teste {

	public static void main(String[] args) {
		//Instanciar um animal
		Animal animal = new Animal();
		
		//Recuperar o nome da Classe
		String nome = animal.getClass().getName();
		System.out.println(nome);
		
		//Recuperar os métodos da Classe
		Method[] metodos =animal.getClass().getDeclaredMethods();
		//Exibir o nome dos métodos
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
		//Recuperar os atributos da Classe
		Field[] atributos = animal.getClass().getDeclaredFields();
		
		//Exibir o nome e o tipo do atributo
		for (int i = 0; i < atributos.length; i++) {
			System.out.println(atributos[i].getName()
						+ " " + atributos[i].getType());
			//Recuperar a anotação @Coluna
			Coluna anotacao = atributos[i].getAnnotation(Coluna.class);
			//Exibir os parametros configurados na anotação
			System.out.println(anotacao.nome() 
					+ " " + anotacao.tamanho() + " " + anotacao.obrigatorio());
		}
		
	}
}





