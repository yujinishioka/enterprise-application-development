package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PEDIDO")
@SequenceGenerator(sequenceName = "SQ_T_PEDIDO", name = "pedido", allocationSize = 1)
public class Pedido {
	
	@Id	
	@Column(name="cd_pedido")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido", nullable = false, updatable = false)
	private Calendar dataPedido;
	
	@Column(name="vl_pedido", nullable = false, length = 10)
	private Float valorPedido;
	
	// mappedBy: Nome do atributo que mapeia a FK
	@OneToOne(mappedBy = "pedido")
	private NotaFiscal notaFiscal;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name="T_ITEM_PEDIDO", 
			joinColumns = @JoinColumn(name="cd_pedido"), 
			inverseJoinColumns = @JoinColumn(name="cd_produto")
	)
	private List<Produto> produtos;
	
	@ManyToOne
	@JoinColumn(name="cd_cliente", nullable = false)
	private Cliente cliente;
	
	public Pedido() {}
	
	public Pedido(Calendar dataPedido, Float valorPedido, Cliente cliente) {
		super();
		this.dataPedido = dataPedido;
		this.valorPedido = valorPedido;
		this.cliente = cliente;
	}
	
	public Pedido(Calendar dataPedido, Float valorPedido) {
		super();
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

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
