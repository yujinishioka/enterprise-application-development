package br.com.fiap.entity;
import javax.persistence.*;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {

    @Id
    @Column(name="id_aluno")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
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
    
    @ManyToOne()
    @JoinColumn(name="id_turma")
    private Turma turma;

    public Aluno() {}

	public Aluno(Long id, String nome, String cpf, String rg, String endereco, String telefone, String email, Turma turma) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.turma = turma;
	}

	public Aluno(String nome, String cpf, String rg, String endereco, String telefone, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Aluno(String nome, String cpf, String rg, String endereco, String telefone, String email, Turma turma) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.turma = turma;
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
