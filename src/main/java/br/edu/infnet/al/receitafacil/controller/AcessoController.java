package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.al.receitafacil.domain.Usuario;
import br.edu.infnet.al.receitafacil.repository.UsuarioRepository;

@Controller
public class AcessoController {
    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }
    @GetMapping(value = "/logout")
    public String telaLogout() {
        UsuarioRepository.setLogin(false);
        return "index";
    }

    @PostMapping(value = "/login")
    public String login(Model model, Usuario userLogin) {
        if(userLogin.getEmail().equalsIgnoreCase(userLogin.getSenha())) {
            UsuarioRepository.setLogin(true);
            return "home";
        }
        else {
            model.addAttribute("mensagem", "Login / Senha estão incorretas!");
            return "login";
        }
    }
}
