package br.com.fiap.view;

import java.util.Calendar;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Teste {
	public static void main(String[] args) {
		Calendar data = Calendar.getInstance();
		
		ContaCorrente cc = new ContaCorrente(1, 12345, data, 2000, TipoConta.COMUN);
		ContaPoupanca cp = new ContaPoupanca(1, 12345, data, 500, 1.1f);
		
		System.out.println("Saldo da Conta Corrente: R$ " + cc.getSaldo());
		try {
			cc.retirar(500);			
		} catch (SaldoInsuficienteException e) {
			
		}
		System.out.println("Novo saldo da Conta Corrente: R$ " + cc.getSaldo());
	}
}
