package br.edu.infnet.al.receitafacil.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.Receita;

@Repository
public class ReceitaRepository {
	private static Integer id = 1;
	
	private static Map<Integer, Receita> mapaReceita = new HashMap<Integer, Receita>();

    public boolean incluir(Receita receita) {
        receita.setId(id++);

        try {
            mapaReceita.put(receita.getId(), receita);
            return true;
        } catch(Exception e) {            
            return false;
        }
    }

	public Receita excluir(Integer key) {
		return mapaReceita.remove(key);
	}

    public Collection<Receita> listar() {
        return mapaReceita.values();
    }

    public static Receita idReceita(int id) {
        return mapaReceita.get(id);
    }
    public static int quantidade() {
        return mapaReceita.size();
    }
}
