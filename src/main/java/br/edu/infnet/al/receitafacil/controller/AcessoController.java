package br.edu.infnet.al.receitafacil.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

//import br.edu.infnet.al.receitafacil.model.repository.UsuarioRepository;
import br.edu.infnet.al.receitafacil.model.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class AcessoController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/login")
    public String telaLogin(Model model) {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String telaLogout(HttpSession session, SessionStatus status) {
        //UsuarioRepository.setLogin(-1);
        usuarioService.setLogin(-1);
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
        //int id = UsuarioRepository.cadastrado(email, senha);
        int id = usuarioService.cadastrado(email, senha);

        if(id > 0) { // cadastrado
            //UsuarioRepository.setLogin(id); 
            usuarioService.setLogin(id); 
            //model.addAttribute("usuario", UsuarioRepository.usuario(id));
            model.addAttribute("usuario", usuarioService.usuario(id));
            return "home";
        }
        else { //não cadastrado
            model.addAttribute("mensagem", "Login / Senha estão incorretas!");
            return "login";
        }
    }
}