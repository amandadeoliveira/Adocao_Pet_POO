package models;

import java.util.UUID;

public class Animal {
	private UUID animid;
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
        
        this.animid = UUID.randomUUID();
    }
    
    public UUID getId(){
    	return this.animid;
    }
    public void setId(UUID animid){
    	this.animid = animid;
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