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
@Table(name="T_USUARIO")
//sequenceName -> nome da sq no Banco, name-> usado generator, allocationSize -> incremento 
@SequenceGenerator(sequenceName = "SQ_T_USUARIO", name="usuario", allocationSize = 1)
public class Usuario {

	@Id	
	@Column(name="cd_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private int codigo;
	
	@Column(name="nm_usuario", nullable = false, length = 30)
	private String nome;
	
	@Column(name="vl_senha", nullable = false, length = 20)
	private String senha;
	
	@Temporal(TemporalType.TIMESTAMP) //Grava data e hora no banco
	@Column(name="dt_criacao", nullable = false, updatable = false)
	private Calendar dataCriacao;
	
	@Column(name="nr_cpf", length = 11, updatable = false)
	private String cpf;
	
	@Column(name="ds_email", nullable = false, length = 30)
	private String email;
	
	@Column(name="vl_altura", precision = 1 , scale = 2)
	private Float altura;
	
	@Transient //Não será uma coluna na tabela
	private String token;
	
	@Lob //Mapeia um campo do tipo BLOB, que recebe arquivos (foto)
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)//Grava o texto da constante e não a posicao
	@Column(name="ds_tipo", length = 20)
	private TipoUsuario tipo;
	
}