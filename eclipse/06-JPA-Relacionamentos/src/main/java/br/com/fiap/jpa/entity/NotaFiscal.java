package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NOTA_FISCAL")
@SequenceGenerator(sequenceName = "SQ_T_NOTA_FISCAL", name = "nota_fiscal", allocationSize = 1)
public class NotaFiscal {
	
	public NotaFiscal() {}
	
	public NotaFiscal(Calendar dataNota, Float valorNota) {
		this.dataNota = dataNota;
		this.valorNota = valorNota;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataNota() {
		return dataNota;
	}

	public void setDataNota(Calendar dataNota) {
		this.dataNota = dataNota;
	}

	public Float getValorNota() {
		return valorNota;
	}

	public void setValorNota(Float valorNota) {
		this.valorNota = valorNota;
	}

	@Id	
	@Column(name="cd_nota")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_fiscal")
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_nota", nullable = false, updatable = false)
	private Calendar dataNota;
	
	@Column(name="vl_nota", nullable = false, length = 10)
	private Float valorNota;
	
	// FK
	@OneToOne
	@JoinColumn(name="cd_pedido", nullable = false)
	private Pedido pedido;

}
