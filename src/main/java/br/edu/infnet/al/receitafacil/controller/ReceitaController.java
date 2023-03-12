package br.edu.infnet.al.receitafacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.al.receitafacil.domain.Receita;
import br.edu.infnet.al.receitafacil.repository.ReceitaRepository;
import br.edu.infnet.al.receitafacil.repository.UsuarioRepository;

@Controller
@SessionAttributes("usuario")
public class ReceitaController {
    @GetMapping(value = "/receita/cadastro")
    public String receitaCadastro() {
        return "receita/cadastro";
    }

    @GetMapping(value = "/receita/lista")
    public String receitaLista(Model model) {
        model.addAttribute("receitas", ReceitaRepository.listar());
        return "receita/lista";
    }

    @PostMapping(value = "/receita/incluir")
    public String receitaIncluir(Model model, @RequestParam String nome, @RequestParam String preparo, @RequestParam int tempo, @RequestParam int qtdePessoas) {
        Receita receita = new Receita(nome, UsuarioRepository.getLogin(), preparo, tempo, qtdePessoas);
        ReceitaRepository.incluir(receita);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", receita.getNome() + " foi incluído com sucesso.");

        return receitaLista(model);
    }

	@GetMapping(value = "/receita/{id}/excluir")
	public String receitaExcluir(Model model, @PathVariable Integer id) {
        Receita receita = ReceitaRepository.excluir(id);
		
        model.addAttribute("opcao", "x");
        model.addAttribute("mensagem", receita.getNome() + " foi excluído com sucesso.");

        return receitaLista(model);
	}
}