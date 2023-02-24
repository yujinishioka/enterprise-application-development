package br.com.fiap.bean;

public interface ContaInvestimento {
	public default double calculaRetornoInvestimento() {
		return 0;
	}
}
