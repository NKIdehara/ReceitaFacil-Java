package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReceitaFacilController {

    @GetMapping(value = "/")
    public String usuarioCadastro() {
        return "index";
    }
}
