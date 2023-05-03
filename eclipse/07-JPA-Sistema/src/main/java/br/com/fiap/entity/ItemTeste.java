package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_ITEM_TESTE")
@SequenceGenerator(sequenceName="SQ_TAB_ITEM_TESTE", name="itemTeste", allocationSize=1)
public class ItemTeste {
	
	@Id
	@Column(name="cd_item_teste")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itemTeste")
	private Integer id;
	
	@Column(name="descricao_item_teste", nullable=false, length=500)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="cod_caso_teste")
	private CasoTeste casoTeste;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="TAB_ITEM_TESTE_USUARIO",
			joinColumns = @JoinColumn(name="cod_item_teste"),
			inverseJoinColumns = @JoinColumn(name="cod_usuario"))
	private List<Usuario> usuarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CasoTeste getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(CasoTeste casoTeste) {
		this.casoTeste = casoTeste;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
