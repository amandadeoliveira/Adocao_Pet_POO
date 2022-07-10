package models;

public class Animal {
	private int id;
    private String nome;
    private String sexo;
    private String descricao;
    private String idade;
    private boolean castrado;

    

    public Animal(String nome, String sexo, String descricao, String idade){
        this.nome = nome;
        this.sexo = sexo;
        this.descricao = descricao;
        this.idade = idade;
    }
    
    public int getId(){
    	return this.id;
    }
    public void setId(int id){
    	this.id = id;
    }
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getSexo(){
        return this.sexo;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getIdade(){
        return this.idade;
    }
    public void setIdade(String idade){
        this.idade = idade;
    }
    
    public void setCastrado(boolean valor){
        this.castrado = valor;
    }
    
    public boolean getCastrado(){
        return this.castrado; 
    }
}