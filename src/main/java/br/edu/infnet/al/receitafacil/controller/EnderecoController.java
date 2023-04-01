package br.edu.infnet.al.receitafacil.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import br.edu.infnet.al.receitafacil.model.domain.Endereco;

@Controller
@SessionAttributes("usuario")
public class EnderecoController {

	@PostMapping(value = "/cep")
	public String verificaCep(Model model, @RequestParam String buscacep) {
		
        Endereco endereco = new Endereco();
        try {
            endereco = buscaCep(buscacep);
        } catch (Exception e) {
        }

        if(endereco.getLocalidade() != null) {
            model.addAttribute("encontrado", "s");
            model.addAttribute("endereco", endereco);
        } else {
            model.addAttribute("encontrado", "n");
        }
        return "/usuario/cadastro";
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
            throw new Exception("Erro de conexão: status Code [" + conexao.getResponseCode() + "]. " + e.toString()); 
        }
    }    
}