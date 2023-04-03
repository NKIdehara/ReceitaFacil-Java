package br.edu.infnet.al.receitafacil.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.multipart.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.google.gson.Gson;

import br.edu.infnet.al.receitafacil.model.domain.Endereco;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.AmazonS3Service;
import br.edu.infnet.al.receitafacil.model.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AmazonS3Service amazonS3Service;

    @GetMapping(value = "/usuario/cadastro")
    public String usuarioCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value = "/usuario/lista")
    public String usuarioLista(Model model) {
        if (usuarioService.getLogin() < 0) return "index";
        model.addAttribute("usuarios", usuarioService.listar());
        return "usuario/lista";
    }
    
    @PostMapping(value = "/usuario/incluir")
    public String usuarioIncluir(Model model, @RequestParam String nome, @RequestParam String senha, @RequestParam String email, @RequestParam String telefone, @RequestParam String cep, @RequestParam MultipartFile file) {
        String foto = file.getOriginalFilename();
        // File arquivo = new File("C:\\Users\\Admin\\Downloads\\" + foto);
        // String imagem = amazonS3Service.uploadImage("receitafacil", foto, arquivo);

        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(file.getSize());
        String imagem = amazonS3Service.uploadImage("receitafacil", foto, file, meta);

        Usuario usuario = new Usuario(nome, email, senha, telefone, cep, false, imagem);
        usuarioService.incluir(usuario);

        model.addAttribute("opcao", "i");
        model.addAttribute("mensagem", usuario.getNome() + " foi incluído com sucesso.");

        if (usuarioService.getLogin() > 0)
            return usuarioLista(model);
        else {
            usuarioService.setLogin(usuario.getId());
            model.addAttribute("usuario", usuario);
            return "home";
        }
    }

	@GetMapping(value = "/usuario/{id}/excluir")
	public String usuarioExcluir(Model model, @PathVariable Integer id) {
        String user = usuarioService.usuario(id).getNome();
        try {
            Usuario usuario = usuarioService.excluir(id);		
            model.addAttribute("opcao", "x");
            model.addAttribute("mensagem", usuario.getNome() + " foi excluído(a) com sucesso.");
        } catch(Exception e) {
            model.addAttribute("opcao", "e");
            model.addAttribute("mensagem", "Impossível excluir o(a) usuário(a) " + user + "!");
        }
        return usuarioLista(model);
	}

    @GetMapping(value = "/usuario/{id}/verificar")
	public String usuarioVerificar(Model model, @PathVariable Integer id) {
		Usuario usuario = usuarioService.usuario(id);
        Endereco endereco = new Endereco();
        try {
            endereco = buscaCep(usuario.getCep());
        } catch (Exception e) {
        }

        model.addAttribute("selecionado", usuario);
        model.addAttribute("endereco", endereco);

        return "usuario/verificar";
	}

    public String Json2String(BufferedReader buffereReader) throws IOException {
        String resposta, jsonString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonString += resposta;
        }
        return jsonString;
    }

    public Endereco buscaCep (String cep) throws Exception {
        String enderecoURL = "https://viacep.com.br/ws/" + cep + "/json/";
        URL url = new URL(enderecoURL);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setDoInput(true);
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader((conexao.getInputStream()), "utf-8"));
            String convertJsonString = Json2String(buff);
            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(convertJsonString, Endereco.class);
            return endereco;
        } catch (Exception e) {
            throw  new Exception("Erro de conexão: status Code [" + conexao.getResponseCode() + "]. " + e.toString()); 
        }
    }
}