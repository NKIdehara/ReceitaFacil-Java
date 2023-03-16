package br.edu.infnet.al.receitafacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// import br.edu.infnet.al.receitafacil.model.domain.Usuario;
// import br.edu.infnet.al.receitafacil.model.repository.UsuarioRepository;
import br.edu.infnet.al.receitafacil.model.service.UsuarioService;

@Controller
public class ReceitaFacilController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/")
    public String usuarioCadastro() {
        return "index";
    }

    @GetMapping(value = "/home")
    public String usuarioRetornar(Model model) {
        // se não estiver logado, retorna para página de login
        //if (UsuarioRepository.getLogin() < 0) return "index";
        if (usuarioService.getLogin() < 0) return "index";

        // se estiver logado, vai para página inicial
        //model.addAttribute("usuario", UsuarioRepository.usuario(UsuarioRepository.getLogin()));
        model.addAttribute("usuario", usuarioService.usuario(usuarioService.getLogin()));
        return "home";
    }
}