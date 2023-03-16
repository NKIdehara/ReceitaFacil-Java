package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteLiquido;
import br.edu.infnet.al.receitafacil.model.repository.IngredienteLiquidoRepository;

@Service
public class IngredienteLiquidoService {
    @Autowired
    IngredienteLiquidoRepository ingredienteLiquidoRepository;
    
    public boolean incluir(IngredienteLiquido liquido) {
        return ingredienteLiquidoRepository.incluir(liquido);
    }

	public IngredienteLiquido excluir(Integer key) {
		return ingredienteLiquidoRepository.excluir(key);
	}

    public Collection<IngredienteLiquido> listar() {
        return ingredienteLiquidoRepository.listar();
    }
}