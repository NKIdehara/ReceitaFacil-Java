package br.edu.infnet.al.receitafacil.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteGranel;

@Repository
public class IngredienteGranelRepository {
	private static Integer id = 1;
	
	private static Map<Integer, IngredienteGranel> mapaIngredienteGranel = new HashMap<Integer, IngredienteGranel>();

    public boolean incluir(IngredienteGranel granel) {
        granel.setId(id++);

        try {
            mapaIngredienteGranel.put(granel.getId(), granel);
            return true;
        } catch(Exception e) {            
            return false;
        }
    }

	public IngredienteGranel excluir(Integer key) {
		return mapaIngredienteGranel.remove(key);
	}

    public Collection<IngredienteGranel> listar() {
        return mapaIngredienteGranel.values();
    }

    public static IngredienteGranel id(int id) {
        return mapaIngredienteGranel.get(id);
    }
    public static int quantidade() {
        return mapaIngredienteGranel.size();
    }
}
