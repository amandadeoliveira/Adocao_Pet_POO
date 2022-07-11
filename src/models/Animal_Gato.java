package models;

import java.io.Serializable;

public class Animal_Gato extends Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	private String raca;
	private String cor;
	
	public Animal_Gato(String nome, String sexo, String descricao, String idade) {
		super(nome, sexo, descricao, idade);
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
