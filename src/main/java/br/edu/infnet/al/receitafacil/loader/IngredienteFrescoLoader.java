package br.edu.infnet.al.receitafacil.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteFresco;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.IngredienteFrescoService;

@Component
public class IngredienteFrescoLoader implements ApplicationRunner {
    @Autowired
    IngredienteFrescoService ingredienteFrescoService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String file = ".\\src\\main\\webapp\\resources\\input_ingredientes_fresco.txt";
            try {
                FileReader fileFrescos = new FileReader(file);
                BufferedReader registro = new BufferedReader(fileFrescos);

                String linha = registro.readLine();
                String[] campo = null;

                while(linha != null) {
                    campo = linha.split(";");

                    IngredienteFresco fresco = new IngredienteFresco(campo[0], Float.parseFloat(campo[1]), Float.parseFloat(campo[2]), campo[3], (campo[4].equalsIgnoreCase("S")) ? true : false, (campo[5].equalsIgnoreCase("S")) ? true : false, Integer.parseInt(campo[6]));
                    Usuario user = new Usuario();
                    user.setId(Integer.parseInt(campo[7]));
                    fresco.setUsuario(user);
                    ingredienteFrescoService.incluir(fresco);
                    
                    linha = registro.readLine();
                }
                registro.close();
                fileFrescos.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("[FRESCOS] leitura de dados concluído!");
        }
    }
}