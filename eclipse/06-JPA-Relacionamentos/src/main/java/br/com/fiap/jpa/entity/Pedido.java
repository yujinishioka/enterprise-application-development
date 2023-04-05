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
@Table(name="T_PEDIDO")
@SequenceGenerator(sequenceName = "SQ_T_PEDIDO", name = "pedido", allocationSize = 1)
public class Pedido {
	
	public Pedido() {}
	
	public Pedido(Integer codigo, Calendar dataPedido, Float valorPedido) {
		super();
		this.codigo = codigo;
		this.dataPedido = dataPedido;
		this.valorPedido = valorPedido;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Float getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Float valorPedido) {
		this.valorPedido = valorPedido;
	}

	@Id	
	@Column(name="cd_pedido")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido", nullable = false, updatable = false)
	private Calendar dataPedido;
	
	@Column(name="vl_pedido", nullable = false, length = 10)
	private Float valorPedido;

}
