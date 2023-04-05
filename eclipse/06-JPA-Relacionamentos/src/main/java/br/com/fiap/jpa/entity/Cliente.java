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
@Table(name="T_CLIENTE")
@SequenceGenerator(sequenceName = "SQ_T_CLIENTE", name = "cliente", allocationSize = 1)
public class Cliente {
	
	public Cliente() {}
	
	public Cliente(String nomeCliente, Calendar dataNascimento) {
		super();
		this.nomeCliente = nomeCliente;
		this.dataNascimento = dataNascimento;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Id	
	@Column(name="cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private Integer codigo;
	
	@Column(name="nm_cliente", nullable = false, length = 50)
	private String nomeCliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_nascimento", nullable = false, updatable = false)
	private Calendar dataNascimento;

}
