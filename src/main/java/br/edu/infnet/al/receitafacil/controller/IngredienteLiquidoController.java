package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.al.receitafacil.domain.IngredienteLiquido;
import br.edu.infnet.al.receitafacil.repository.IngredienteLiquidoRepository;
import br.edu.infnet.al.receitafacil.repository.UsuarioRepository;

@Controller
@SessionAttributes("usuario")
public class IngredienteLiquidoController {
    @GetMapping(value = "/ingrediente/liquido/cadastro")
    public String ingredienteLiquidoCadastro() {
        return "ingrediente/liquido/cadastro";
    }

    @GetMapping(value = "/ingrediente/liquido/lista")
    public String ingredienteLiquidoLista(Model model) {
        model.addAttribute("ingredientes", IngredienteLiquidoRepository.listar());
        return "ingrediente/liquido/lista";
    }

    @PostMapping(value = "/ingrediente/liquido/incluir")
    public String ingredienteLiquidoIncluir(Model model,
        @RequestParam String nome, 
        @RequestParam float preco, 
        @RequestParam float quantidade, 
        @RequestParam String unidade, 
        @RequestParam(required = false) boolean quente,
        @RequestParam(required = false) boolean pacote,
        @RequestParam float densidade) {

        IngredienteLiquido liquido = new IngredienteLiquido(nome, UsuarioRepository.getLogin(), preco, quantidade, unidade, quente, pacote, densidade);
        IngredienteLiquidoRepository.incluir(liquido);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", liquido.getNome() + " foi incluído com sucesso.");

        return ingredienteLiquidoLista(model);
    }

	@GetMapping(value = "/ingrediente/liquido/{id}/excluir")
	public String ingredienteLiquidoExcluir(Model model, @PathVariable Integer id) {
        IngredienteLiquido liquido = IngredienteLiquidoRepository.excluir(id);
		
        model.addAttribute("opcao", "x");
        model.addAttribute("mensagem", liquido.getNome() + " foi excluído com sucesso.");

        return ingredienteLiquidoLista(model);
	}
}