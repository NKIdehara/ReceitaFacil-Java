package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteLiquido;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.repository.IngredienteLiquidoRepository;

@Service
public class IngredienteLiquidoService {
    @Autowired
    IngredienteLiquidoRepository ingredienteLiquidoRepository;

    public boolean incluir(IngredienteLiquido ingrediente) {
        IngredienteLiquido granel = ingredienteLiquidoRepository.save(ingrediente);
        return (granel != null) ? true : false;
    }

    public IngredienteLiquido excluir(Integer key) {
        IngredienteLiquido granel = ingredienteLiquidoRepository.findById(key).get();
        ingredienteLiquidoRepository.deleteById(key);
        return granel;
    }

    public Collection<IngredienteLiquido> listar() {
        return (Collection<IngredienteLiquido>) ingredienteLiquidoRepository.findAll();
    }
    public Collection<IngredienteLiquido> listar(Usuario usuario) {
        return (Collection<IngredienteLiquido>) ingredienteLiquidoRepository.listar(usuario.getId());
    }

    public IngredienteLiquido fresco(int id) {
        return ingredienteLiquidoRepository.findById(id).get();
    }

/*
    public boolean incluir(IngredienteLiquido liquido) {
        return ingredienteLiquidoRepository.incluir(liquido);
    }

	public IngredienteLiquido excluir(Integer key) {
		return ingredienteLiquidoRepository.excluir(key);
	}

    public Collection<IngredienteLiquido> listar() {
        return ingredienteLiquidoRepository.listar();
    }
*/
}