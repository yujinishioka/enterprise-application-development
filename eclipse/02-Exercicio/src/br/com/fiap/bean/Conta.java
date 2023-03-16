package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

/*
 * Classe Abstrata: Estrutura para as classes filhas
 * 1 - N�o pode ser instanciada
 * 2 - Pode conter m�todos abstratos
 */
public abstract class Conta {
	public int agencia, numero;
	public Calendar dataAbertura;
	public double saldo;
	
	public Conta(int agencia, int numero, Calendar dataAbertura, double saldo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.saldo = saldo;
	}
	
	// Metodos
	public void depositar(double valor) {
		saldo = saldo - valor;
	};
	
	public abstract void retirar(double valor) throws SaldoInsuficienteException;

	// Getters e Setters
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
