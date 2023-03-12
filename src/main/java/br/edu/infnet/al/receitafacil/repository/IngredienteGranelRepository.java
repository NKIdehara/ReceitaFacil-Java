package br.edu.infnet.al.receitafacil.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.al.receitafacil.domain.IngredienteGranel;

public class IngredienteGranelRepository {
	private static Integer id = 1;
	
	private static Map<Integer, IngredienteGranel> mapaIngredienteGranel = new HashMap<Integer, IngredienteGranel>();

    public static boolean incluir(IngredienteGranel granel) {
        granel.setId(id++);

        try {
            mapaIngredienteGranel.put(granel.getId(), granel);
            return true;
        } catch(Exception e) {            
            return false;
        }
    }

	public static IngredienteGranel excluir(Integer key) {
		return mapaIngredienteGranel.remove(key);
	}

    public static Collection<IngredienteGranel> listar() {
        return mapaIngredienteGranel.values();
    }

    public static IngredienteGranel id(int id) {
        return mapaIngredienteGranel.get(id);
    }
    public static int quantidade() {
        return mapaIngredienteGranel.size();
    }
}
