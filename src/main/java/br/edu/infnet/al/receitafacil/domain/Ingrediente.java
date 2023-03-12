package br.edu.infnet.al.receitafacil.domain;

public abstract class Ingrediente {
    private Integer id;
    private String nome;
    private Integer idUsuario;
    private float preco;
    private float quantidade;
    private String unidade;

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

    public Integer getUsuario() {
        return idUsuario;
    }
    public void setUsuario(Integer id) {
        this.idUsuario = id;
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
    
    public Ingrediente(String nome, int idUsuario, float preco, float quantidade, String unidade) {
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.preco = preco;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }
}