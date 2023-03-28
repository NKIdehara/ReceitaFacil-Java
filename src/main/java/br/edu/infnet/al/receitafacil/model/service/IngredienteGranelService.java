package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteGranel;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.repository.IngredienteGranelRepository;

@Service
public class IngredienteGranelService {
    @Autowired
    IngredienteGranelRepository ingredienteGranelRepository;

    public boolean incluir(IngredienteGranel ingrediente) {
        IngredienteGranel granel = ingredienteGranelRepository.save(ingrediente);
        return (granel != null) ? true : false;
    }

    public IngredienteGranel excluir(Integer key) {
        IngredienteGranel granel = ingredienteGranelRepository.findById(key).get();
        ingredienteGranelRepository.deleteById(key);
        return granel;
    }

    public Collection<IngredienteGranel> listar() {
        return (Collection<IngredienteGranel>) ingredienteGranelRepository.findAll();
    }
    public Collection<IngredienteGranel> listar(Usuario usuario) {
        return (Collection<IngredienteGranel>) ingredienteGranelRepository.listar(usuario.getId());
    }

    public IngredienteGranel fresco(int id) {
        return ingredienteGranelRepository.findById(id).get();
    }

/*
    public boolean incluir(IngredienteGranel granel) {
        return ingredienteGranelRepository.incluir(granel);
    }

	public IngredienteGranel excluir(Integer key) {
		return ingredienteGranelRepository.excluir(key);
	}

    public Collection<IngredienteGranel> listar() {
        return ingredienteGranelRepository.listar();
    }
*/
}
