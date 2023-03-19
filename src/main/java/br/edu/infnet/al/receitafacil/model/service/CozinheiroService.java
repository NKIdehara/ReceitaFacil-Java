package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.Cozinheiro;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.repository.CozinheiroRepository;

@Service
public class CozinheiroService {
    @Autowired
    private CozinheiroRepository cozinheiroRepository;

    public boolean incluir(Cozinheiro cozinheiro) {
        Cozinheiro cook = cozinheiroRepository.save(cozinheiro);
        return (cook != null) ? true : false;
    }

    public Cozinheiro excluir(Integer key) {
        Cozinheiro cook = cozinheiroRepository.findById(key).get();
        cozinheiroRepository.deleteById(key);
        return cook;
    }

    public Collection<Cozinheiro> listar() {
        return (Collection<Cozinheiro>) cozinheiroRepository.findAll();
    }
    public Collection<Cozinheiro> listar(Usuario usuario) {
        return (Collection<Cozinheiro>) cozinheiroRepository.listar(usuario.getId());
    }

    public Cozinheiro cozinheiro(int id) {
        return cozinheiroRepository.findById(id).get();
    }
}