package br.edu.infnet.al.receitafacil.model.domain;

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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