package br.edu.infnet.al.receitafacil.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbReceita")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String preparo;
    private int tempo;
    private int qtdePessoas;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idCozinheiro")
    private Cozinheiro cozinheiro;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Ingrediente> ingredientes;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

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

    public String getPreparo() {
        return preparo;
    }
    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    public int getTempo() {
        return tempo;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getQtdePessoas() {
        return qtdePessoas;
    }
    public void setQtdePessoas(int qtdePessoas) {
        this.qtdePessoas = qtdePessoas;
    }

    public Cozinheiro getCozinheiro() {
        return this.cozinheiro;
    }
    public void setCozinheiro(Cozinheiro cozinheiro) {
        this.cozinheiro = cozinheiro;
    }

    public List<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Receita() {}

    public Receita(String nome, String preparo,int tempo, int qtdePessoas) {
        this.nome = nome;
        this.preparo = preparo;
        this.tempo = tempo;
        this.qtdePessoas = qtdePessoas;
    }
}
