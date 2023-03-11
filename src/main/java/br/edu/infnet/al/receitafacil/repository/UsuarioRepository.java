package br.edu.infnet.al.receitafacil.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.al.receitafacil.domain.Usuario;

public class UsuarioRepository {

    private static int login = -1;

	private static Integer id = 1;
	
	private static Map<Integer, Usuario> mapaUsuario = new HashMap<Integer, Usuario>();

    public static int getLogin() {
        return login;
    }
    public static void setLogin(int access) {
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

    public static Usuario usuario(int id) {
        return mapaUsuario.get(id);
    }
    public static int quantidade() {
        return mapaUsuario.size();
    }

    // verifica email cadastrado e retorna senha
    public static int cadastrado(String email, String senha) {
        for(Map.Entry<Integer, Usuario> usuario : mapaUsuario.entrySet()) {
            if(email.equalsIgnoreCase(usuario.getValue().getEmail()) && senha.equals(usuario.getValue().getSenha())) {
                return usuario.getValue().getId(); //encontrou usuário cadastrado
            }
        }
        return -1; //não encontrou usuário
    }
}
