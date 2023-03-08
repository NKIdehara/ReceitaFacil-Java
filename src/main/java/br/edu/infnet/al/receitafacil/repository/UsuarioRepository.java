package br.edu.infnet.al.receitafacil.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.al.receitafacil.domain.Usuario;

public class UsuarioRepository {

    private static boolean login = false;

	private static Integer id = 1;
	
	private static Map<Integer, Usuario> mapaUsuario = new HashMap<Integer, Usuario>();

    public static boolean isLogin() {
        return login;
    }
    public static void setLogin(boolean access) {
        login = access;
    }

    public static boolean incluir(Usuario usuario) {
        usuario.setId(id++);

        try {
            mapaUsuario.put(usuario.getId(), usuario);
            return true;
        } catch(Exception e) {            
            return false;
        }
    }

	public static Usuario excluir(Integer key) {
		return mapaUsuario.remove(key);
	}

    public static Collection<Usuario> listar() {
        return mapaUsuario.values();
    }

    public static int quantidade() {
        return mapaUsuario.size();
    }
}
