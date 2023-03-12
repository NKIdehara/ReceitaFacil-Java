package br.edu.infnet.al.receitafacil.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.al.receitafacil.domain.Receita;

public class ReceitaRepository {
	private static Integer id = 1;
	
	private static Map<Integer, Receita> mapaReceita = new HashMap<Integer, Receita>();

    public static boolean incluir(Receita receita) {
        receita.setId(id++);

        try {
            mapaReceita.put(receita.getId(), receita);
            return true;
        } catch(Exception e) {            
            return false;
        }
    }

	public static Receita excluir(Integer key) {
		return mapaReceita.remove(key);
	}

    public static Collection<Receita> listar() {
        return mapaReceita.values();
    }

    public static Receita idReceita(int id) {
        return mapaReceita.get(id);
    }
    public static int quantidade() {
        return mapaReceita.size();
    }
}
