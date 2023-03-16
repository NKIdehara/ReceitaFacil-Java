package br.edu.infnet.al.receitafacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteFresco;
import br.edu.infnet.al.receitafacil.model.service.IngredienteFrescoService;
// import br.edu.infnet.al.receitafacil.model.repository.IngredienteFrescoRepository;
// import br.edu.infnet.al.receitafacil.model.repository.UsuarioRepository;
import br.edu.infnet.al.receitafacil.model.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class IngredienteFrescoController {
    @Autowired
    private IngredienteFrescoService ingredienteFrescoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/ingrediente/fresco/cadastro")
    public String ingredienteFrescoCadastro() {
        return "ingrediente/fresco/cadastro";
    }

    @GetMapping(value = "/ingrediente/fresco/lista")
    public String ingredienteFrescoLista(Model model) {
        model.addAttribute("ingredientes", ingredienteFrescoService.listar());
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

        IngredienteFresco fresco = new IngredienteFresco(nome, usuarioService.getLogin(), preco, quantidade, unidade, refrigerado, comCasca, pedacos);
        ingredienteFrescoService.incluir(fresco);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", fresco.getNome() + " foi incluído com sucesso.");

        return ingredienteFrescoLista(model);
    }

	@GetMapping(value = "/ingrediente/fresco/{id}/excluir")
	public String ingredienteFrescoExcluir(Model model, @PathVariable Integer id) {
        IngredienteFresco fresco = ingredienteFrescoService.excluir(id);
		
        model.addAttribute("opcao", "x");
        model.addAttribute("mensagem", fresco.getNome() + " foi excluído com sucesso.");

        return ingredienteFrescoLista(model);
	}
}