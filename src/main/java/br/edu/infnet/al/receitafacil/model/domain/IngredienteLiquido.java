package br.edu.infnet.al.receitafacil.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbIngredienteLiquido")
public class IngredienteLiquido extends Ingrediente {
    private boolean quente;
    private boolean pacote;
    private float densidade;


    public boolean isQuente() {
        return this.quente;
    }
    public boolean getQuente() {
        return this.quente;
    }
    public void setQuente(boolean quente) {
        this.quente = quente;
    }

    public boolean isPacote() {
        return this.pacote;
    }
    public boolean getPacote() {
        return this.pacote;
    }
    public void setPacote(boolean pacote) {
        this.pacote = pacote;
    }

    public float getDensidade() {
        return this.densidade;
    }
    public void setDensidade(float densidade) {
        this.densidade = densidade;
    }

    public IngredienteLiquido() {}
 
    public IngredienteLiquido(String nome, float preco, float quantidade, String unidade, boolean quente, boolean pacote, float densidade) {
        super(nome, preco, quantidade, unidade);
        this.quente = quente;
        this.pacote = pacote;
        this.densidade = densidade;       
    }
}