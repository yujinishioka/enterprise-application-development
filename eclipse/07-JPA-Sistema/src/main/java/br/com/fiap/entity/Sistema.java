package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PEDIDO")
@SequenceGenerator(sequenceName = "SQ_T_PEDIDO", name = "sistema", allocationSize = 1)
public class Sistema {
	
	@Id
	@Column(name="cd_sistema")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sistema")
	private Integer id;
	
	@Column(name="nome_sistema", nullable=false, length=80)
	private String nome;
	
	public Sistema() {}

	public Sistema(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

}
