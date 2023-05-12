package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="exercicio", sequenceName = "SQ_TB_EXERCICIO", allocationSize = 1)
@Table(name="TB_EXERCICIO")
public class Exercicio {

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercicio")
    @Column(name="id_exercicio")
    private Long id;

    @Column(name="ds_nome", length = 40, nullable = false)
    private String nome;

    @Column(name="ds_descricao", length = 100)
    private String descricao;

    @Column(name="ds_musculo_trabalhado", length = 40, nullable = false)
    private String musculo_trabalhado;
    
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="T_EQUIPAMENTO_EXERCICIO",
			joinColumns = @JoinColumn(name="id_exercicio"),
			inverseJoinColumns = @JoinColumn(name="id_equipamento"))
	private List<Equipamento> equipamentos = new ArrayList<Equipamento>();
	
	@ManyToMany(mappedBy="exercicios", cascade = CascadeType.ALL)
	private List<Treino> treinos;
	
	public void addEquipamento(Equipamento novoEquipamento) {
		novoEquipamento.addExercicioFromExercicio(this);
		equipamentos.add(novoEquipamento);
	}
	
	public void addEquipamentoFromEquipamento(Equipamento novoEquipamento) {
		equipamentos.add(novoEquipamento);
	}

    public Exercicio() {}

	public Exercicio(Long id, String nome, String descricao, String musculo_trabalhado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.musculo_trabalhado = musculo_trabalhado;
	}

	public Exercicio(String nome, String descricao, String musculo_trabalhado) {
		this.nome = nome;
		this.descricao = descricao;
		this.musculo_trabalhado = musculo_trabalhado;
	}

	public Exercicio(String nome, String musculo_trabalhado) {
		this.nome = nome;
		this.musculo_trabalhado = musculo_trabalhado;
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

	public String getMusculo_trabalhado() {
		return musculo_trabalhado;
	}

	public void setMusculo_trabalhado(String musculo_trabalhado) {
		this.musculo_trabalhado = musculo_trabalhado;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

}
