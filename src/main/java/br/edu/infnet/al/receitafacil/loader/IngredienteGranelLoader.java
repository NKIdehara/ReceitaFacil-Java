package br.edu.infnet.al.receitafacil.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteGranel;
import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.IngredienteGranelService;

@Component
public class IngredienteGranelLoader implements ApplicationRunner {
    @Autowired
    IngredienteGranelService ingredienteGranelService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String file = ".\\src\\main\\webapp\\resources\\input_ingredientes_graneis.txt";
            try {
                FileReader fileGranels = new FileReader(file);
                BufferedReader registro = new BufferedReader(fileGranels);

                String linha = registro.readLine();
                String[] campo = null;

                while(linha != null) {
                    campo = linha.split(";");

                    IngredienteGranel granel = new IngredienteGranel(campo[0], Float.parseFloat(campo[1]), Float.parseFloat(campo[2]), campo[3], (campo[4].equalsIgnoreCase("S")) ? true : false, (campo[5].equalsIgnoreCase("S")) ? true : false, Float.parseFloat(campo[6]));
                    Usuario user = new Usuario();
                    user.setId(Integer.parseInt(campo[7]));
                    granel.setUsuario(user);
                    ingredienteGranelService.incluir(granel);
                    
                    linha = registro.readLine();
                }
                registro.close();
                fileGranels.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("[GRANEIS] leitura de dados concluído!");
        }
    }
}