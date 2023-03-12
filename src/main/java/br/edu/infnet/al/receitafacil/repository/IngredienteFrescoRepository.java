package br.edu.infnet.al.receitafacil.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.al.receitafacil.domain.IngredienteFresco;

public class IngredienteFrescoRepository {
	private static Integer id = 1;
	
	private static Map<Integer, IngredienteFresco> mapaIngredienteFresco = new HashMap<Integer, IngredienteFresco>();

    public static boolean incluir(IngredienteFresco fresco) {
        fresco.setId(id++);

        try {
            mapaIngredienteFresco.put(fresco.getId(), fresco);
            return true;
        } catch(Exception e) {            
            return false;
        }
    }

	public static IngredienteFresco excluir(Integer key) {
		return mapaIngredienteFresco.remove(key);
	}

    public static Collection<IngredienteFresco> listar() {
        return mapaIngredienteFresco.values();
    }

    public static IngredienteFresco id(int id) {
        return mapaIngredienteFresco.get(id);
    }
    public static int quantidade() {
        return mapaIngredienteFresco.size();
    }
}
