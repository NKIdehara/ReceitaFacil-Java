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

import br.edu.infnet.al.receitafacil.model.domain.Cozinheiro;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.CozinheiroService;

@Controller
@SessionAttributes("usuario")
public class CozinheiroController {
    @Autowired
    private CozinheiroService cozinheiroService;

    @GetMapping(value = "/cozinheiro/cadastro")
    public String cozinheiroCadastro() {
        return "cozinheiro/cadastro";
    }

    @GetMapping(value = "/cozinheiro/lista")
    public String cozinheiroLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
        model.addAttribute("cozinheiros", cozinheiroService.listar(usuario));
        return "cozinheiro/lista";
    }

    @PostMapping(value = "/cozinheiro/incluir")
    public String cozinheiroIncluir(Model model, @RequestParam String nome, @RequestParam String cpf, @RequestParam String email, @SessionAttribute("usuario") Usuario usuario) {
        Cozinheiro cozinheiro = new Cozinheiro(nome, email, cpf);
        cozinheiro.setUsuario(usuario);
        cozinheiroService.incluir(cozinheiro);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", cozinheiro.getNome() + " foi incluído com sucesso.");

        return cozinheiroLista(model, usuario);
    }

	@GetMapping(value = "/cozinheiro/{id}/excluir")
	public String cozinheiroExcluir(Model model, @PathVariable Integer id, @SessionAttribute("usuario") Usuario usuario) {
        String cook = cozinheiroService.cozinheiro(id).getNome();
        try {
            Cozinheiro cozinheiro = cozinheiroService.excluir(id);
            model.addAttribute("opcao", "x");
            model.addAttribute("mensagem", cozinheiro.getNome() + " foi excluído com sucesso.");    
        } catch(Exception e) {
            model.addAttribute("opcao", "e");
            model.addAttribute("mensagem", "Impossível excluir o(a) cozinheiro(a) " + cook + "!");    
        }

        return cozinheiroLista(model, usuario);
	}
}