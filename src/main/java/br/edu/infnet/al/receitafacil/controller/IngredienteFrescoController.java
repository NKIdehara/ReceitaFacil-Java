package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.al.receitafacil.domain.IngredienteFresco;
import br.edu.infnet.al.receitafacil.repository.IngredienteFrescoRepository;
import br.edu.infnet.al.receitafacil.repository.UsuarioRepository;

@Controller
@SessionAttributes("usuario")
public class IngredienteFrescoController {
    @GetMapping(value = "/ingrediente/fresco/cadastro")
    public String ingredienteFrescoCadastro() {
        return "ingrediente/fresco/cadastro";
    }

    @GetMapping(value = "/ingrediente/fresco/lista")
    public String ingredienteFrescoLista(Model model) {
        model.addAttribute("ingredientes", IngredienteFrescoRepository.listar());
        return "ingrediente/fresco/lista";
    }

    @PostMapping(value = "/ingrediente/fresco/incluir")
    public String ingredienteFrescoIncluir(Model model,
        @RequestParam String nome, 
        @RequestParam float preco, 
        @RequestParam float quantidade, 
        @RequestParam String unidade, 
        @RequestParam(required = false) boolean refrigerado,
        @RequestParam(required = false) boolean comCasca, 
        @RequestParam int pedacos) {

        IngredienteFresco fresco = new IngredienteFresco(nome, UsuarioRepository.getLogin(), preco, quantidade, unidade, refrigerado, comCasca, pedacos);
        IngredienteFrescoRepository.incluir(fresco);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", fresco.getNome() + " foi incluído com sucesso.");

        return ingredienteFrescoLista(model);
    }

	@GetMapping(value = "/ingrediente/fresco/{id}/excluir")
	public String ingredienteFrescoExcluir(Model model, @PathVariable Integer id) {
        IngredienteFresco fresco = IngredienteFrescoRepository.excluir(id);
		
        model.addAttribute("opcao", "x");
        model.addAttribute("mensagem", fresco.getNome() + " foi excluído com sucesso.");

        return ingredienteFrescoLista(model);
	}
}