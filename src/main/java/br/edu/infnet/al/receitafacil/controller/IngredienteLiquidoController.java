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

import br.edu.infnet.al.receitafacil.model.domain.IngredienteLiquido;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.IngredienteLiquidoService;

@Controller
@SessionAttributes("usuario")
public class IngredienteLiquidoController {
    @Autowired
    private IngredienteLiquidoService ingredienteLiquidoService;

    @GetMapping(value = "/ingrediente/liquido/cadastro")
    public String ingredienteLiquidoCadastro() {
        return "ingrediente/liquido/cadastro";
    }

    @GetMapping(value = "/ingrediente/liquido/lista")
    public String ingredienteLiquidoLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
        model.addAttribute("ingredientes", ingredienteLiquidoService.listar(usuario));
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
        @RequestParam float densidade,
        @SessionAttribute("usuario") Usuario usuario) {

        IngredienteLiquido liquido = new IngredienteLiquido(nome, preco, quantidade, unidade, quente, pacote, densidade);
        liquido.setUsuario(usuario);
        ingredienteLiquidoService.incluir(liquido);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", liquido.getNome() + " foi incluído com sucesso.");

        return ingredienteLiquidoLista(model, usuario);
    }

	@GetMapping(value = "/ingrediente/liquido/{id}/excluir")
	public String ingredienteLiquidoExcluir(Model model, @PathVariable Integer id, @SessionAttribute("usuario") Usuario usuario) {
        IngredienteLiquido liquido = ingredienteLiquidoService.excluir(id);
		
        model.addAttribute("opcao", "x");
        model.addAttribute("mensagem", liquido.getNome() + " foi excluído com sucesso.");

        return ingredienteLiquidoLista(model, usuario);
	}
}