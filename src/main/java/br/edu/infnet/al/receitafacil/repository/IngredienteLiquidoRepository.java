package br.edu.infnet.al.receitafacil.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.al.receitafacil.domain.IngredienteLiquido;

public class IngredienteLiquidoRepository {
	private static Integer id = 1;
	
	private static Map<Integer, IngredienteLiquido> mapaIngredienteLiquido = new HashMap<Integer, IngredienteLiquido>();

    public static boolean incluir(IngredienteLiquido liquido) {
        liquido.setId(id++);

        try {
            mapaIngredienteLiquido.put(liquido.getId(), liquido);
            return true;
        } catch(Exception e) {            
            return false;
        }
    }

	public static IngredienteLiquido excluir(Integer key) {
		return mapaIngredienteLiquido.remove(key);
	}

    public static Collection<IngredienteLiquido> listar() {
        return mapaIngredienteLiquido.values();
    }

    public static IngredienteLiquido id(int id) {
        return mapaIngredienteLiquido.get(id);
    }
    public static int quantidade() {
        return mapaIngredienteLiquido.size();
    }
}
