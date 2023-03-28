package br.edu.infnet.al.receitafacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteGranel;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.IngredienteGranelService;

@Controller
@SessionAttributes("usuario")
public class IngredienteGranelController {
    @Autowired
    private IngredienteGranelService ingredienteGranelService;

    @GetMapping(value = "/ingrediente/granel/cadastro")
    public String ingredienteGranelCadastro() {
        return "ingrediente/granel/cadastro";
    }

    @GetMapping(value = "/ingrediente/granel/lista")
    public String ingredienteGranelLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
        model.addAttribute("ingredientes", ingredienteGranelService.listar(usuario));
        return "ingrediente/granel/lista";
    }

    @PostMapping(value = "/ingrediente/granel/incluir")
    public String ingredienteGranelIncluir(Model model,
        @RequestParam String nome, 
        @RequestParam float preco, 
        @RequestParam float quantidade, 
        @RequestParam String unidade, 
        @RequestParam(required = false) boolean perecivel, 
        @RequestParam(required = false) boolean fracionado, 
        @RequestParam float densidade,
        @SessionAttribute("usuario") Usuario usuario) {

        IngredienteGranel granel = new IngredienteGranel(nome, preco, quantidade, unidade, perecivel, fracionado, densidade);
        granel.setUsuario(usuario);
        ingredienteGranelService.incluir(granel);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", granel.getNome() + " foi incluído com sucesso.");

        return ingredienteGranelLista(model, usuario);
    }

	@GetMapping(value = "/ingrediente/granel/{id}/excluir")
	public String ingredienteGranelExcluir(Model model, @PathVariable Integer id, @SessionAttribute("usuario") Usuario usuario) {
        IngredienteGranel granel = ingredienteGranelService.excluir(id);
		
        model.addAttribute("opcao", "x");
        model.addAttribute("mensagem", granel.getNome() + " foi excluído com sucesso.");

        return ingredienteGranelLista(model, usuario);
	}
}