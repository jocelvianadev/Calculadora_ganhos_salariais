package entities;

public class Departamento {
	private String nome;
	
	//CONSTRUTOR PADRÃO VAZIO
	public Departamento() {
		
	}
	
	//CONSTRUTOR PADRÃO COM ARGUMENTO
	public Departamento(String nome) {
		this.nome = nome;
	}

	//GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
