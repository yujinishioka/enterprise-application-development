package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUTO")
@SequenceGenerator(sequenceName = "SQ_T_PRODUTO", name = "produto", allocationSize = 1)
public class Produto {
	
	@Id	
	@Column(name="cd_nota")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_fiscal")
	private Integer codigo;
	
	@Column(name="nm_produto", nullable = false, length = 30)
	private String nomeProduto;
	
	@Column(name="vl_produto", nullable = false, length = 10)
	private Float valorProduto;
	
	@Column(name="qt_estoque", length = 5)
	private Integer qtdEstoque;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Pedido> pedidos;

	public Produto(String nomeProduto, Float valorProduto, Integer qtdEstoque) {
		super();
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Float valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
