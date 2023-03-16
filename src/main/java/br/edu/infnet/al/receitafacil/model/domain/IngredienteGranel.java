package br.edu.infnet.al.receitafacil.model.domain;

public class IngredienteGranel extends Ingrediente {
    private boolean perecivel;
    private boolean fracionado;
    private float densidade;


    public boolean isPerecivel() {
        return this.perecivel;
    }
    public boolean getPerecivel() {
        return this.perecivel;
    }
    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }
    
    public boolean isFracionado() {
        return this.fracionado;
    }
    public boolean getFracionado() {
        return this.fracionado;
    }
    public void setFracionado(boolean fracionado) {
        this.fracionado = fracionado;
    }

    public float getDensidade() {
        return this.densidade;
    }
    public void setDensidade(float densidade) {
        this.densidade = densidade;
    }
 
    public IngredienteGranel(String nome, int idUsuario, float preco, float quantidade, String unidade, boolean perecivel, boolean fracionado, float densidade) {
        super(nome, idUsuario, preco, quantidade, unidade);
        this.perecivel = perecivel;
        this.fracionado = fracionado;
        this.densidade = densidade;       
    }
}