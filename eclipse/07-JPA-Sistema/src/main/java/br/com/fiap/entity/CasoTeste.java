package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_CASO_TESTE")
@SequenceGenerator(sequenceName="SQ_TAB_CASO_TESTE", name="casoTeste", allocationSize=1)
public class CasoTeste {
	
	@Id
	@Column(name="cd_caso_teste")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="casoTeste")
	private Integer id;
	
	@Column(name="nome_caso_teste", nullable=false, length=80)
	private String nome;
	
	@Column(name="descricao_caso_teste", length=500)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="cd_sistema", nullable=false)
	private Sistema sistema;
	
	public CasoTeste() {}
	
	public CasoTeste(Integer id, String nome, String descricao, Sistema sistema) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setCdSistema(Sistema sistema) {
		this.sistema = sistema;
	}

}
