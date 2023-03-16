package br.edu.infnet.al.receitafacil.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private int login = -1;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public int getLogin() {
        return login;
    }
    public void setLogin(int access) {
        login = access;
    }

    public boolean incluir(Usuario usuario) {
        return usuarioRepository.incluir(usuario);
    }

    public Usuario excluir(Integer key) {
        return usuarioRepository.excluir(key);
    }

    public Collection<Usuario> listar() {
        return usuarioRepository.listar();
    }

    public Usuario usuario(int id) {
        return usuarioRepository.usuario(id);
        // return mapaUsuario.get(id);
    }

    public int cadastrado(String email, String senha) {
        return usuarioRepository.cadastrado(email, senha);
    }
}