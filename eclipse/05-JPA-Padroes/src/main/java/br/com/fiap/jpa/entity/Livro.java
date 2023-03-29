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
