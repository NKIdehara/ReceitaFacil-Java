package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping(value = "/usuario")
    public String usuarioCadastro() {
        return "usuario/cadastro";
    }
}
