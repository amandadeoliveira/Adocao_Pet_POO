package models;

public class Animal_Cachorro extends Animal {
	private static final long serialVersionUID = 1L;
	private String raca;
	private String cor;
	
	public Animal_Cachorro(String nome, String sexo, String descricao, String idade) {
		super(nome, sexo, descricao, idade);
	}
	public Animal_Cachorro() {
	}
	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}	
}
