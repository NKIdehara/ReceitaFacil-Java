package br.edu.infnet.al.receitafacil.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.al.receitafacil.model.domain.Receita;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.ReceitaService;

@Component
public class ReceitaLoader implements ApplicationRunner {
    @Autowired
    ReceitaService receitaService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String file = ".\\src\\main\\webapp\\resources\\input_receitas.txt";
            try {
                FileReader fileReceitas = new FileReader(file);
                BufferedReader registro = new BufferedReader(fileReceitas);

                String linha = registro.readLine();
                String[] campo = null;

                while(linha != null) {
                    campo = linha.split(";");

                    Receita receita = new Receita(campo[0], campo[1], Integer.parseInt(campo[2]), Integer.parseInt(campo[3]));
                    Usuario user = new Usuario();
                    user.setId(Integer.parseInt(campo[4]));
                    receita.setUsuario(user);
                    receitaService.incluir(receita);
                    
                    linha = registro.readLine();
                }
                registro.close();
                fileReceitas.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("[RECEITAS] leitura de dados concluído!");
        }
    }
}