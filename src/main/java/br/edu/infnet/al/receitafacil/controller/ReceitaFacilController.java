package br.edu.infnet.al.receitafacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.al.receitafacil.model.service.UsuarioService;

@Controller
// @RestController
public class ReceitaFacilController {
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/test")
    public String init() {
        System.out.println("Teste de sistema.");
        return "index";
    }

    @GetMapping(value = "/")
    public String appInicio() {
        return "index";
    }

    @GetMapping(value = "/home")
    public String appHome(Model model) {
        // se não estiver logado, retorna para página de login
        //if (UsuarioRepository.getLogin() < 0) return "index";
        if (usuarioService.getLogin() < 0) return "index";

        // se estiver logado, vai para página inicial
        //model.addAttribute("usuario", UsuarioRepository.usuario(UsuarioRepository.getLogin()));
        model.addAttribute("usuario", usuarioService.usuario(usuarioService.getLogin()));
        return "home";
    }
}