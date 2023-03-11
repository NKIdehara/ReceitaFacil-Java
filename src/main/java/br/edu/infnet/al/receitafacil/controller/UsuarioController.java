package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.al.receitafacil.domain.Usuario;
import br.edu.infnet.al.receitafacil.repository.UsuarioRepository;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @GetMapping(value = "/usuario/cadastro")
    public String usuarioCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value = "/usuario/lista")
    public String usuarioLista(Model model) {
        if (UsuarioRepository.getLogin() < 0) return "index";
        model.addAttribute("usuarios", UsuarioRepository.listar());
        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String usuarioIncluir(Model model, @RequestParam String nome, @RequestParam String senha, @RequestParam String email) {
        Usuario usuario = new Usuario(nome, email, senha);
        UsuarioRepository.incluir(usuario);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", usuario.getNome() + " foi incluído com sucesso.");

        if (UsuarioRepository.getLogin() > 0)
            return usuarioLista(model);
        else {
            UsuarioRepository.setLogin(usuario.getId());
            model.addAttribute("usuario", usuario);
            return "home";
        }
    }

	@GetMapping(value = "/usuario/{id}/excluir")
	public String usuarioExcluir(Model model, @PathVariable Integer id) {
		Usuario usuario = UsuarioRepository.excluir(id);
		
        model.addAttribute("opcao", "x");
        model.addAttribute("mensagem", usuario.getNome() + " foi excluído com sucesso.");

        return usuarioLista(model);
	}

}
