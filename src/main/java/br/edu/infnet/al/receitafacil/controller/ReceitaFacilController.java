package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.al.receitafacil.domain.Usuario;
import br.edu.infnet.al.receitafacil.repository.UsuarioRepository;

@Controller
public class ReceitaFacilController {

    @GetMapping(value = "/")
    public String usuarioCadastro() {
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
            
        return "index";
    }

    @GetMapping(value = "/home")
    public String usuarioRetornar(Model model) {
        // se não estiver logado, retorna para página de login
        if (UsuarioRepository.getLogin() < 0) return "index";

        // se estiver logado, vai para página inicial
        model.addAttribute("usuario", UsuarioRepository.usuario(UsuarioRepository.getLogin()));
        return "home";
    }
}