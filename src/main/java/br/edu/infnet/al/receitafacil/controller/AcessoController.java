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

    @PostMapping(value = "/login")
    public String login(Model model, Usuario userLogin) {
        if(userLogin.getEmail().equalsIgnoreCase(userLogin.getSenha())) {
            // inclusão temporária para testes
            if(UsuarioRepository.quantidade() == 0) {
                Usuario user1 = new Usuario("João da Silva", "jsilva@email.com", "123456");
                Usuario user2 = new Usuario("Maria Joaquina", "mjoaquina@email.com", "123456");
                Usuario user3 = new Usuario("Pedro Pereira", "ppereira@email.com", "123456");
                Usuario user4 = new Usuario("Sofia Oliveira", "soliveira@email.com", "123456");
                UsuarioRepository.incluir(user1);
                UsuarioRepository.incluir(user2);
                UsuarioRepository.incluir(user3);
                UsuarioRepository.incluir(user4);
            }

            return "home";
        }
        else {
            model.addAttribute("mensagem", "Login / Senha estão incorretas!");
            return "login";
        }
    }
}
