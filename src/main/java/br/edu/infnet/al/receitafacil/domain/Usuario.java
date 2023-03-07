package br.edu.infnet.al.receitafacil.domain;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario (String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        StringBuilder usuario = new StringBuilder();
        usuario
            .append(nome)
            .append(";")
            .append(email)
            .append(";")
            .append(senha);
        
        return usuario.toString();
    }
}