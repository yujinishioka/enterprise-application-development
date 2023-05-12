package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="treino", sequenceName = "SQ_TB_TREINO", allocationSize = 1)
@Table(name="TB_TREINO")
public class Treino {

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treino")
    @Column(name="id_treino")
    private Long id;

    @Column(name="ds_nome", nullable = false, length = 40)
    private String nome;

    @Column(name="ds_descricao", length = 80)
    private String descricao;

    @Column(name="ds_horario", nullable = false, length = 12)
    private String horario;

    @Column(name="nm_duracao_minutos", nullable = false, precision = 3)
    private Integer duracao;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    		name = "T_EXERCICIO_TREINO",
    		joinColumns = @JoinColumn(name="id_treino"),
    		inverseJoinColumns = @JoinColumn(name="id_exercicio"))
    private List<Exercicio> exercicios = new ArrayList<Exercicio>();
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma")
    private Turma turma;

    public Treino() {}

	public Treino(Long id, String nome, String descricao, String horario, Integer duracao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.horario = horario;
		this.duracao = duracao;
	}
	
	public Treino(String nome, String descricao, String horario, Integer duracao, Turma turma) {
		this.nome = nome;
		this.descricao = descricao;
		this.horario = horario;
		this.duracao = duracao;
		this.turma = turma;
	}

	public Treino(String nome, String descricao, String horario, Integer duracao) {
		this.nome = nome;
		this.descricao = descricao;
		this.horario = horario;
		this.duracao = duracao;
	}

	public Treino(String nome, String horario, Integer duracao) {
		this.nome = nome;
		this.horario = horario;
		this.duracao = duracao;
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
}
