package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="professor", sequenceName = "SQ_TB_PROFESSOR", allocationSize = 1)
@Table(name="TB_PROFESSOR")
public class Professor {

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor")
    @Column(name="id_professor")
    private Long id;

    @Column(name="ds_nome", nullable = false, length = 50)
    private String nome;

    @Column(name="nm_cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name="nm_rg", length = 10)
    private String rg;

    @Column(name="ds_endereco", nullable = false, length = 100)
    private String endereco;

    @Column(name="nm_telefone", nullable = false, length = 20)
    private String telefone;

    @Column(name="ds_email", nullable = false, length = 100)
    private String email;

    @Column(name="ds_especialidade", nullable = false, length = 40)
    private String especialidade;
    
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Turma> turmas = new ArrayList<Turma>();

    public Professor() {}

	public Professor(Long id, String nome, String cpf, String rg, String endereco, String telefone, String email,
			String especialidade) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.especialidade = especialidade;
	}

	public Professor(String nome, String cpf, String endereco, String telefone, String email, String especialidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.especialidade = especialidade;
	}

	public Professor(String nome, String cpf, String rg, String endereco, String telefone, String email,
			String especialidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.especialidade = especialidade;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	} 

}
