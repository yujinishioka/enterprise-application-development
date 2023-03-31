package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_LIVRO")
@SequenceGenerator(sequenceName = "SQ_T_LIVRO", name="livro", allocationSize = 1)
public class Livro {
	
	public Livro() {}
	
	public Livro(String titulo, Genero genero, Integer pagina, Calendar dataLancamento) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.pagina = pagina;
		this.dataLancamento = dataLancamento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	@Id	
	@Column(name="cd_livro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
	private Integer codigo;
		
	@Column(name="ds_titulo", nullable = false, length = 50)
	private String titulo;
		
	@Column(name="ds_genero", nullable = false, length = 20)
	private Genero genero;

	@Column(name="nr_pagina", nullable = false, length = 5)
	private Integer pagina;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_lancamento", nullable = false, updatable = false)
	private Calendar dataLancamento;
	
}
