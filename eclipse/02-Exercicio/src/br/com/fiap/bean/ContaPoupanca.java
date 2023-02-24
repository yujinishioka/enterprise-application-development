package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento{
	
	public static final float RENDIMENTO = 0.05f; // "f" no final para definir o tipo float.
	private float taxa;
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}
	
	public double calculaRetornoInvestimento() {
		return RENDIMENTO * saldo;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if(saldo < valor + taxa) {
			throw new SaldoInsuficienteException("Saldo insuficiente.");
		}
		saldo -= valor + taxa;
	}
}
