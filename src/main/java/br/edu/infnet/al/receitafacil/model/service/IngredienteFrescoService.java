package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteFresco;
import br.edu.infnet.al.receitafacil.model.repository.IngredienteFrescoRepository;

@Service
public class IngredienteFrescoService {
    @Autowired
    IngredienteFrescoRepository ingredienteFrescoRepository;
    
    public boolean incluir(IngredienteFresco fresco) {
        return ingredienteFrescoRepository.incluir(fresco);
    }

	public IngredienteFresco excluir(Integer key) {
		return ingredienteFrescoRepository.excluir(key);
	}

    public Collection<IngredienteFresco> listar() {
        return ingredienteFrescoRepository.listar();
    }
}
