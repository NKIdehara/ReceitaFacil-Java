package br.edu.infnet.al.receitafacil.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.al.receitafacil.domain.Usuario;

public class UsuarioRepository {

    private static List<Usuario> listaUsuario = new ArrayList<Usuario>();

    public static boolean incluir(Usuario usuario) {
        try {
            listaUsuario.add(usuario);
            return true;
        } catch(Exception e) {            
            return false;
        }
    }

    public static List<Usuario> listar() {
        return listaUsuario;
    }

    public static int quantidade() {
        return listaUsuario.size();
    }
}
