package br.edu.infnet.al.receitafacil.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.al.receitafacil.model.domain.Cozinheiro;
import br.edu.infnet.al.receitafacil.model.domain.Ingrediente;
import br.edu.infnet.al.receitafacil.model.domain.Receita;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.CozinheiroService;
import br.edu.infnet.al.receitafacil.model.service.IngredienteService;
import br.edu.infnet.al.receitafacil.model.service.ReceitaService;
import br.edu.infnet.al.receitafacil.model.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CozinheiroService cozinheiroService;

    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping(value = "/usuario/listar")
    public Collection<Usuario> usuarioListar() {
        return usuarioService.listar();
    }
    @GetMapping(value = "/cozinheiro/listar")
    public Collection<Cozinheiro> cozinheiroListar() {
        return cozinheiroService.listar();
    }
    @GetMapping(value = "/receita/listar")
    public Collection<Receita> receitaListar() {
        return receitaService.listar();
    }
    @GetMapping(value = "/ingrediente/listar")
    public Collection<Ingrediente> ingredienteListar() {
        return ingredienteService.listar();
    }

    @PostMapping(value = "/usuario/incluir")
    public void usuarioIncluir(@RequestBody Usuario usuario) {
        usuarioService.incluir(usuario);
    }
    @PostMapping(value = "/cozinheiro/incluir")
    public void cozinheiroIncluir(@RequestBody Cozinheiro cozinheiro) {
        cozinheiroService.incluir(cozinheiro);
    }
    @PostMapping(value = "/receita/incluir")
    public void receitaIncluir(@RequestBody Receita receita) {
        receitaService.incluir(receita);
    }

    @DeleteMapping(value = "/usuario/{id}/excluir")
    public void usuarioExcluir(@PathVariable Integer id) {
        usuarioService.excluir(id);
    }
    @DeleteMapping(value = "/cozinheiro/{id}/excluir")
    public void cozinheiroExcluir(@PathVariable Integer id) {
        cozinheiroService.excluir(id);
    }
    @DeleteMapping(value = "/receita/{id}/excluir")
    public void receitaExcluir(@PathVariable Integer id) {
        receitaService.excluir(id);
    }
    @DeleteMapping(value = "/ingrediente/{id}/excluir")
    public void ingredienteExcluir(@PathVariable Integer id) {
        ingredienteService.excluir(id);
    }
}