package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.Receita;
import br.edu.infnet.al.receitafacil.model.repository.ReceitaRepository;

@Service
public class ReceitaService {
    @Autowired
    ReceitaRepository receitaRepository;

    public boolean incluir(Receita receita) {
        return receitaRepository.incluir(receita);
    }

	public Receita excluir(Integer key) {
        return receitaRepository.excluir(key);
	}

    public Collection<Receita> listar() {
        return receitaRepository.listar();
    }    
}