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
        Usuario user = usuarioRepository.save(usuario);
        return (user != null) ? true : false;
    }

    public Usuario excluir(Integer key) {
        Usuario user = usuarioRepository.findById(key).get();
        usuarioRepository.deleteById(key);
        return user;
    }

    public Collection<Usuario> listar() {
        return (Collection<Usuario>) usuarioRepository.listar();
        //return (Collection<Usuario>) usuarioRepository.findAll();
    }

    public Usuario usuario(int id) {
        return usuarioRepository.findById(id).get();
    }

    // Retorna Id se encontrar usuário com email/senha
    // Retorna -1 caso contrário
    public int cadastrado(String email, String senha) {
        Usuario user = usuarioRepository.autenticar(email, senha);

        if(user == null) return -1; //não encontrou usuário
        return user.getId();        //encontrou usuário cadastrado
    }
}