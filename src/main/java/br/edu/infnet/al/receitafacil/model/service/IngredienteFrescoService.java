package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteFresco;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.repository.IngredienteFrescoRepository;

@Service
public class IngredienteFrescoService {
    @Autowired
    IngredienteFrescoRepository ingredienteFrescoRepository;

    public boolean incluir(IngredienteFresco ingrediente) {
        IngredienteFresco fresco = ingredienteFrescoRepository.save(ingrediente);
        return (fresco != null) ? true : false;
    }

    public IngredienteFresco excluir(Integer key) {
        IngredienteFresco fresco = ingredienteFrescoRepository.findById(key).get();
        ingredienteFrescoRepository.deleteById(key);
        return fresco;
    }

    public Collection<IngredienteFresco> listar() {
        return (Collection<IngredienteFresco>) ingredienteFrescoRepository.findAll();
    }
    public Collection<IngredienteFresco> listar(Usuario usuario) {
        return (Collection<IngredienteFresco>) ingredienteFrescoRepository.listar(usuario.getId());
    }

    public IngredienteFresco fresco(int id) {
        return ingredienteFrescoRepository.findById(id).get();
    }

/*
    public boolean incluir(IngredienteFresco fresco) {
        return ingredienteFrescoRepository.incluir(fresco);
    }

	public IngredienteFresco excluir(Integer key) {
		return ingredienteFrescoRepository.excluir(key);
	}

    public Collection<IngredienteFresco> listar() {
        return ingredienteFrescoRepository.listar();
    }
*/
}
