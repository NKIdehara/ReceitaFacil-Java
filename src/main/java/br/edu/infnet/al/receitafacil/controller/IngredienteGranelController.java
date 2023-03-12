package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.al.receitafacil.domain.IngredienteGranel;
import br.edu.infnet.al.receitafacil.repository.IngredienteGranelRepository;
import br.edu.infnet.al.receitafacil.repository.UsuarioRepository;

@Controller
@SessionAttributes("usuario")
public class IngredienteGranelController {
    @GetMapping(value = "/ingrediente/granel/cadastro")
    public String ingredienteGranelCadastro() {
        return "ingrediente/granel/cadastro";
    }

    @GetMapping(value = "/ingrediente/granel/lista")
    public String ingredienteGranelLista(Model model) {
        model.addAttribute("ingredientes", IngredienteGranelRepository.listar());
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
        @RequestParam float densidade) {

        IngredienteGranel granel = new IngredienteGranel(nome, UsuarioRepository.getLogin(), preco, quantidade, unidade, perecivel, fracionado, densidade);
        IngredienteGranelRepository.incluir(granel);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", granel.getNome() + " foi incluído com sucesso.");

        return ingredienteGranelLista(model);
    }

	@GetMapping(value = "/ingrediente/granel/{id}/excluir")
	public String ingredienteGranelExcluir(Model model, @PathVariable Integer id) {
        IngredienteGranel granel = IngredienteGranelRepository.excluir(id);
		
        model.addAttribute("opcao", "x");
        model.addAttribute("mensagem", granel.getNome() + " foi excluído com sucesso.");

        return ingredienteGranelLista(model);
	}
}