package br.edu.infnet.al.receitafacil.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbUsuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private long telefone;
    private int cep;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Cozinheiro> cozinheiros;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Ingrediente> ingredientes;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Receita> receitas;
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public long getTelefone() {
        return this.telefone;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public int getCep() {
        return this.cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }

    public List<Cozinheiro> getCozinheiros() {
        return this.cozinheiros;
    }
    public void setCozinheiros(List<Cozinheiro> cozinheiros) {
        this.cozinheiros = cozinheiros;
    }

    public List<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Receita> getReceitas() {
        return this.receitas;
    }
    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, long telefone, int cep) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cep = cep;
    }
}