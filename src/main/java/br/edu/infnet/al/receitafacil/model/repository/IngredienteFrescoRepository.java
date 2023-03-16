package br.edu.infnet.al.receitafacil.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteFresco;

@Repository
public class IngredienteFrescoRepository {
	private static Integer id = 1;
	
	private static Map<Integer, IngredienteFresco> mapaIngredienteFresco = new HashMap<Integer, IngredienteFresco>();

    public boolean incluir(IngredienteFresco fresco) {
        fresco.setId(id++);

        try {
            mapaIngredienteFresco.put(fresco.getId(), fresco);
            return true;
        } catch(Exception e) {            
            return false;
        }
    }

	public IngredienteFresco excluir(Integer key) {
		return mapaIngredienteFresco.remove(key);
	}

    public Collection<IngredienteFresco> listar() {
        return mapaIngredienteFresco.values();
    }

    public static IngredienteFresco id(int id) {
        return mapaIngredienteFresco.get(id);
    }
    public static int quantidade() {
        return mapaIngredienteFresco.size();
    }
}
