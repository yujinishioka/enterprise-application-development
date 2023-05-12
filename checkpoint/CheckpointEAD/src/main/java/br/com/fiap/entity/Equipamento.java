package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.enums.TipoEquipamento;

@Entity
@SequenceGenerator(name="equipamento", sequenceName = "SQ_TB_EQUIPAMENTO", allocationSize = 1)
@Table(name = "TB_EQUIPAMENTO")
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipamento")
	@Column(name = "id_equipamento")
	private Long id;

	@Column(name = "ds_nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "ds_descricao", length = 80)
	private String descricao;

	@Column(name = "qt_disponivel", nullable = false, precision = 3)
	private Integer quantidadeDisponivel;

	@Column(name = "ds_localizacao", nullable = false, length = 40)
	private String localizacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_equipamento", nullable = false, length = 10)
	private TipoEquipamento tipo;
	
	@Column(name="dt_compra", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataCompra;
	
	@ManyToMany(mappedBy = "equipamentos", cascade = CascadeType.ALL)
	private List<Exercicio> exercicios = new ArrayList<Exercicio>();
	
	public void addExercicio(Exercicio novoExercicio) {
		novoExercicio.addEquipamentoFromEquipamento(this);
		exercicios.add(novoExercicio);
	}
	
	public void addExercicioFromExercicio(Exercicio novoExercicio) {
		exercicios.add(novoExercicio);
	}

	public Equipamento() {
	}

	public Equipamento(String nome, Integer quantidadeDisponivel, String localizacao, TipoEquipamento tipo, Calendar dataCompra) {
		this.nome = nome;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.localizacao = localizacao;
		this.tipo = tipo;
		this.dataCompra = dataCompra;
	}

	public Equipamento(Long id, String nome, String descricao, Integer quantidadeDisponivel, String localizacao, TipoEquipamento tipo, Calendar dataCompra) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.localizacao = localizacao;
		this.tipo = tipo;
		this.dataCompra = dataCompra;
	}

	public Long getId() {
		return id;
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

	public Integer getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public TipoEquipamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEquipamento tipo) {
		this.tipo = tipo;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

}
