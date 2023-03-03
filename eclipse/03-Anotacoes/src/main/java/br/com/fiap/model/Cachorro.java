package br.com.fiap.model;

public class Cachorro extends Animal {

	@SuppressWarnings("all") //Retirar o alerta do código
	@Override //Garantir que o metodo está sobrescrevendo
	//@Deprecated //Método está obsoleto, não deve ser utilizado
	public void andar() {
		System.out.println("Cachorro andando");
		int x = 123;
	}
	
}