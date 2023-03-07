package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @GetMapping(value = "/usuario")
    public String usuarioCadastro() {
        return "usuario/cadastro";
    }

    @PostMapping(value = "/usuario/incluir")
    public String usuarioIncluido() {
        return "redirect:/";
    }

}
