package br.edu.infnet.al.receitafacil.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.al.receitafacil.repository.UsuarioRepository;

@Controller
@SessionAttributes("usuario")
public class AcessoController {
    @GetMapping(value = "/login")
    public String telaLogin(Model model) {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String telaLogout(HttpSession session, SessionStatus status) {
        UsuarioRepository.setLogin(-1);
        if(session != null) {
            session.removeAttribute("usuario");
            session.invalidate();
            status.setComplete();
        }
        return "redirect:/";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email, @RequestParam String senha) {//Usuario userLogin) {
        // verifica id do usuário cadastrado
        int id = UsuarioRepository.cadastrado(email, senha);

        if(id > 0) { // cadastrado
            UsuarioRepository.setLogin(id); 
            model.addAttribute("usuario", UsuarioRepository.usuario(id));
            return "home";
        }
        else { //não cadastrado
            model.addAttribute("mensagem", "Login / Senha estão incorretas!");
            return "login";
        }
    }
}
