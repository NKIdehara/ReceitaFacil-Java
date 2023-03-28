package br.edu.infnet.al.receitafacil.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbIngredienteFresco")
public class IngredienteFresco extends Ingrediente {
    private boolean refrigerado;
    private boolean comCasca;
    private int pedacos;

    public boolean isRefrigerado() {
        return this.refrigerado;
    }
    public boolean getRefrigerado() {
        return this.refrigerado;
    }
    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }
    
    public boolean isComCasca() {
        return this.comCasca;
    }
    public boolean getComCasca() {
        return this.comCasca;
    }
    public void setComCasca(boolean comCasca) {
        this.comCasca = comCasca;
    }

    public int getPedacos() {
        return this.pedacos;
    }
    public void setPedacos(int pedacos) {
        this.pedacos = pedacos;
    }
 
    public IngredienteFresco() {}
    
    public IngredienteFresco(String nome, float preco, float quantidade, String unidade, boolean refrigerado, boolean comCasca, int pedacos) {
        super(nome, preco, quantidade, unidade);
        this.refrigerado = refrigerado;
        this.comCasca = comCasca;
        this.pedacos = pedacos;       
    }
}