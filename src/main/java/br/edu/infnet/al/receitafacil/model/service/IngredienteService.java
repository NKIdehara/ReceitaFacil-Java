package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.Ingrediente;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.repository.IngredienteRepository;

@Service
public class IngredienteService {
    @Autowired
    IngredienteRepository ingredienteRepository;


    public Ingrediente excluir(Integer key) {
        Ingrediente ingrediente = ingredienteRepository.findById(key).get();
        ingredienteRepository.deleteById(key);
        return ingrediente;
    }

    public Collection<Ingrediente> listar() {
        return (Collection<Ingrediente>) ingredienteRepository.findAll();
    }
    public Collection<Ingrediente> listar(Usuario usuario) {
        return (Collection<Ingrediente>) ingredienteRepository.listar(usuario.getId());
    }
}
