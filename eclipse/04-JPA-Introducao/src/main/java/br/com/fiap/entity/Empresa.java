package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="T_EMPRESA")
@SequenceGenerator(sequenceName = "SQ_T_EMPRESA", name="empresa", allocationSize = 1)
public class Empresa {
	
	@Id	
	@Column(name="cd_empresa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
	private Integer codigo;
	
	@Column(name="nm_empresa", nullable = false, length = 20)
	private String nome;
	
	@Column(name="nm_cnpj", nullable = false, length = 14, updatable = false)
	private String cnpj;

	@Column(name="ds_email", nullable = false, length = 50)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fundacao", nullable = false, updatable = false)
	private Calendar dataFundacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_status", length = 10)
	private StatusEmpresa status;
	
	@Column(name="nr_funcionarios", length = 5)
	private Integer funcionarios;
	
	@Lob
	@Column(name="fl_logo")
	private byte[] logo;
	
	@Column(name="vl_faturamento", length = 10, precision = 2)
	private Float faturamento;
	
	@Column(name="ds_estatal")
	private Boolean estatal;
	
	@Transient
	private Integer anoFuncionamento;

}
