package br.edu.infnet.al.receitafacil.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbIngrediente")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private float preco;
    private float quantidade;
    private String unidade;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToMany(mappedBy = "ingredientes")
    @JsonIgnore
    private List<Receita> receitas;

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return this.preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getQuantidade() {
        return this.quantidade;
    }
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return this.unidade;
    }
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
 
    public Usuario getUsuario() {
        return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Receita> getReceitas() {
        return this.receitas;
    }
    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public Ingrediente() {}

    public Ingrediente(String nome, float preco, float quantidade, String unidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }
}