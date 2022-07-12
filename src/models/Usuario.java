package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private UUID userid;
    private String nome;
    private String celular;
    private String email;
    private String senha;
    private int pets_adotados;
    private List<UUID> meus_gatos;
    private List<UUID> meus_dogs;
    
    public Usuario(String nome, String celular, String email, String senha){
    	
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
        
        this.userid = UUID.randomUUID();
        
        this.meus_dogs = new ArrayList<UUID>();
        this.meus_gatos = new ArrayList<UUID>();
        this.pets_adotados = 0;
    }
    
    public Usuario() {
	}

	public UUID getId(){
    	return this.userid;
    }
    public void setId(UUID userid){
    	this.userid = userid;
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
    
    public boolean adoteCat( UUID catId ){
    	if ( pets_adotados < 2) {
    		meus_gatos.add(catId);
    		pets_adotados++;
    		return true;
    	}else {
    		return false;
    	}
    }
    public boolean adoteDog( UUID dogId ){
    	if ( pets_adotados < 2) {
    		 meus_dogs.add( dogId );
    		 pets_adotados++;
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public int getQtdPetAdotados(){
    	return this.pets_adotados;
    }
    
    
	public String toString(){
		return "Usuario [userid=" + userid + ", nome=" + nome + ", celular=" + celular + ", email=" + email + ", senha="
				+ senha + ", pets_adotados=" + pets_adotados + ", meus_gatos=" + meus_gatos + ", meus_dogs=" + meus_dogs
				+ "]";
	}
    
}
