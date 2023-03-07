package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.al.receitafacil.domain.Usuario;
import br.edu.infnet.al.receitafacil.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @GetMapping(value = "/usuario")
    public String usuarioCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value = "/usuario/lista")
    public String usuarioLista(Model model) {
        model.addAttribute("usuarios", UsuarioRepository.listar());
        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String usuarioIncluido(Model model, Usuario usuario) {       
        UsuarioRepository.incluir(usuario);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", usuario.getNome() + " foi incluído com sucesso.");

        return usuarioLista(model);
    }

    @GetMapping(value = "/home")
    public String usuarioRetornar() {
        return "home";
    }
}
