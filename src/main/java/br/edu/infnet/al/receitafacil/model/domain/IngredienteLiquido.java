package br.edu.infnet.al.receitafacil.model.domain;

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
 
    public IngredienteLiquido(String nome, int idUsuario, float preco, float quantidade, String unidade, boolean quente, boolean pacote, float densidade) {
        super(nome, idUsuario, preco, quantidade, unidade);
        this.quente = quente;
        this.pacote = pacote;
        this.densidade = densidade;       
    }
}