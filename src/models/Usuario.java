package models;

public class Usuario {
	private int id;
    private String nome;
    private String celular;
    private String email;
    private String senha;

    public Usuario(String nome, String celular, String email, String senha){
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
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

    public String getCelular(){
        return this.celular;
    }
    public void setCelular(String celular){
        this.celular = celular;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
}
