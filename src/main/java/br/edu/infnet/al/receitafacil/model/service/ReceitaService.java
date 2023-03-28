package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.Receita;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.repository.ReceitaRepository;

@Service
public class ReceitaService {
    @Autowired
    ReceitaRepository receitaRepository;

    public boolean incluir(Receita receita) {
        Receita recipe = receitaRepository.save(receita);
        return (recipe != null) ? true : false;
    }

    public Receita excluir(Integer key) {
        Receita recipe = receitaRepository.findById(key).get();
        receitaRepository.deleteById(key);
        return recipe;
    }

    public Collection<Receita> listar() {
        return (Collection<Receita>) receitaRepository.findAll();
    }
    public Collection<Receita> listar(Usuario usuario) {
        return (Collection<Receita>) receitaRepository.listar(usuario.getId());
    }

    public Receita cozinheiro(int id) {
        return receitaRepository.findById(id).get();
    }

/*
    public boolean incluir(Receita receita) {
        return receitaRepository.incluir(receita);
    }

	public Receita excluir(Integer key) {
        return receitaRepository.excluir(key);
	}

    public Collection<Receita> listar() {
        return receitaRepository.listar();
    }    
*/
}