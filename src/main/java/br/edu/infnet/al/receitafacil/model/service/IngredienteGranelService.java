package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteGranel;
import br.edu.infnet.al.receitafacil.model.repository.IngredienteGranelRepository;

@Service
public class IngredienteGranelService {
    @Autowired
    IngredienteGranelRepository ingredienteGranelRepository;
   
    public boolean incluir(IngredienteGranel granel) {
        return ingredienteGranelRepository.incluir(granel);
    }

	public IngredienteGranel excluir(Integer key) {
		return ingredienteGranelRepository.excluir(key);
	}

    public Collection<IngredienteGranel> listar() {
        return ingredienteGranelRepository.listar();
    }
}
