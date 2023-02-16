package br.com.fiap.model;

// ENUM - Conjunto de constantes
public enum Genero {
	
	MASCULINO("Masculino"), 
	FEMININO("Feminino"), 
	OUTROS("Outros genêros");
	
	private String label;
	
	Genero(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
