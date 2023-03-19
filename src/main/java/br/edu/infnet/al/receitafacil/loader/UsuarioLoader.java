package br.edu.infnet.al.receitafacil.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.al.receitafacil.model.domain.Usuario;
import br.edu.infnet.al.receitafacil.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String file = "input_usuarios.txt";
            try {
                FileReader fileUsuarios = new FileReader(file);
                BufferedReader registro = new BufferedReader(fileUsuarios);

                String linha = registro.readLine();
                String[] campo = null;

                while(linha != null) {
                    campo = linha.split(";");

                    Usuario usuario = new Usuario(campo[0], campo[1], campo[2]);
                    usuarioService.incluir(usuario);
                    
                    linha = registro.readLine();
                }
                registro.close();
                fileUsuarios.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("[USUARIOS] leitura de dados concluído!");
        }
    }
}