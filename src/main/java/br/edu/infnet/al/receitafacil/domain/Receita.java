package br.edu.infnet.al.receitafacil.domain;

public class Receita {
    private Integer id;
    private String nome;
    private Integer idUsuario;
	//private Map<Integer, Ingrediente> ingredientes = new HashMap<Integer, Ingrediente>();
    private String preparo;
    private int tempo;
    private int qtdePessoas;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getUsuario() {
        return idUsuario;
    }
    public void setUsuario(Integer id) {
        this.idUsuario = id;
    }

    public String getPreparo() {
        return preparo;
    }
    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    public int getTempo() {
        return tempo;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getQtdePessoas() {
        return qtdePessoas;
    }
    public void setQtdePessoas(int qtdePessoas) {
        this.qtdePessoas = qtdePessoas;
    }

    public Receita(String nome, int idUsuario, String preparo,int tempo, int qtdePessoas) {
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.preparo = preparo;
        this.tempo = tempo;
        this.qtdePessoas = qtdePessoas;
    }
}
