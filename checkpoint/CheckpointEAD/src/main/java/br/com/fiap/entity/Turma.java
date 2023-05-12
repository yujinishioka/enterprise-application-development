package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="turma", sequenceName = "SQ_TB_TURMA", allocationSize = 1)
@Table(name="TB_TURMA")
public class Turma {

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turma")
    @Column(name="id_turma")
    private Long id;

    @Column(name="ds_nome", nullable = false, length = 40)
    private String nome;

    @Column(name="ds_descricao", length = 80)
    private String descricao;

    @Column(name="ds_horario", length = 12)
    private String horario;
    
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<Aluno> alunos = new ArrayList<Aluno>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_professor", nullable = false)
    private Professor professor;
    
    @OneToOne(mappedBy = "turma", cascade = CascadeType.ALL)
    private Treino treino;
    
    public void addAluno(Aluno novoAluno) {
    	novoAluno.setTurma(this);
    	alunos.add(novoAluno);
    }

    public Turma() {}

	public Turma(Long id, String nome, String descricao, String horario) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.horario = horario;
	}

	public Turma(String nome, String descricao, String horario) {
		this.nome = nome;
		this.descricao = descricao;
		this.horario = horario;
	}

	public Turma(String nome, String descricao, String horario, Professor professor) {
		this.nome = nome;
		this.descricao = descricao;
		this.horario = horario;
		this.professor = professor;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}
	
}
