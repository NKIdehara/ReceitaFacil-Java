package br.edu.infnet.al.receitafacil.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.al.receitafacil.model.domain.Cozinheiro;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.CozinheiroService;

@Order(2)
@Component
public class CozinheiroLoader implements ApplicationRunner {
    @Autowired
    private CozinheiroService cozinheiroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String file = "input_cozinheiros.txt";
            try {
                FileReader fileCozinheiros = new FileReader(file);
                BufferedReader registro = new BufferedReader(fileCozinheiros);

                String linha = registro.readLine();
                String[] campo = null;

                while(linha != null) {
                    campo = linha.split(";");

                    Cozinheiro cozinheiro = new Cozinheiro(campo[0], campo[1], campo[2]);

                    Usuario usuario = new Usuario();
                    usuario.setId(1);
                    cozinheiro.setUsuario(usuario);

                    cozinheiroService.incluir(cozinheiro);

                    
                    linha = registro.readLine();
                }
                registro.close();
                fileCozinheiros.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("[COZINHEIROS] leitura de dados concluído!");
        }
    }
}