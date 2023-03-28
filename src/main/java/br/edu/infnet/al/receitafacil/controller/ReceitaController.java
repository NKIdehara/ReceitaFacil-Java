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

import br.edu.infnet.al.receitafacil.model.domain.Receita;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.ReceitaService;

@Controller
@SessionAttributes("usuario")
public class ReceitaController {
    @Autowired
    private ReceitaService receitaService;

    @GetMapping(value = "/receita/cadastro")
    public String receitaCadastro() {
        return "receita/cadastro";
    }

    @GetMapping(value = "/receita/lista")
    public String receitaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
        model.addAttribute("receitas", receitaService.listar(usuario));
        return "receita/lista";
    }

    @PostMapping(value = "/receita/incluir")
    public String receitaIncluir(Model model, @RequestParam String nome, @RequestParam String preparo, @RequestParam int tempo, @RequestParam int qtdePessoas, @SessionAttribute("usuario") Usuario usuario) {
        Receita receita = new Receita(nome, preparo, tempo, qtdePessoas);
        receita.setUsuario(usuario);
        receitaService.incluir(receita);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", receita.getNome() + " foi incluído com sucesso.");

        return receitaLista(model, usuario);
    }

	@GetMapping(value = "/receita/{id}/excluir")
	public String receitaExcluir(Model model, @PathVariable Integer id, @SessionAttribute("usuario") Usuario usuario) {
        Receita receita = receitaService.excluir(id);
		
        model.addAttribute("opcao", "x");
        model.addAttribute("mensagem", receita.getNome() + " foi excluído com sucesso.");

        return receitaLista(model, usuario);
	}
}