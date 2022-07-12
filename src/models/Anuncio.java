package models;

import java.io.Serializable;

public class Anuncio implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cidade;
	private String estado;
	private String data_post;
	private Animal_Gato petGato;
	private Animal_Cachorro petCachorro;
	private Usuario user;
	private boolean disponivel;
	
	public Anuncio(String cidade, String estado, String data_post, Usuario autor){
	        this.cidade = cidade;
	        this.estado = estado;
	        this.data_post = data_post;
	        this.user = autor;
	        this.disponivel = true;
	        
	        this.petCachorro = new Animal_Cachorro();
	        this.petGato 	 = new Animal_Gato();
	}
	
	public String getCidade(){
        return this.cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
	public String getEstado(){
        return this.estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public String getDataPost(){
    	return this.data_post;
    }
    
    public String getAutor(){
        return this.user.getNome();
    }
    
    public Animal_Gato getAnimalGato(){
    	return this.petGato;
    }
    public void setAnimalGato(Animal_Gato gato){
    	this.petCachorro = null;
    	this.petGato = gato;
    }
    
    public Animal_Cachorro getAnimalCachorro(){
    	return this.petCachorro;
    }
    public void setAnimalCachorro(Animal_Cachorro cachorro){
    	this.petGato = null;
    	this.petCachorro = cachorro;
    }

	public boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean value) {
		this.disponivel = value;
	}

	@Override
	public String toString() {
		String petString = "";
		String petDescrp = "";
		if (petGato == null && !(petCachorro == null) ) {
			String tempName  = this.petCachorro.getNome();
			String tempIdade = this.petCachorro.getIdade();
			String animCast = "LoL"; 
			
			if ( this.petCachorro.getCastrado() ) {
			animCast = "É castrado";
			} else {
				animCast = "Não é castrado";
			}
			petString = tempName + " // " + tempIdade + " // " + animCast;
			petDescrp = this.petCachorro.getDescricao();
		}
		else if (petCachorro == null) {
			String tempName  = this.petGato.getNome();
			String tempIdade = this.petGato.getIdade();
			String animCast = "LoL"; 
			
			if ( this.petGato.getCastrado() ) {
				animCast = "É castrado";
				} else {
					animCast = "Não é castrado";
				}
				petString = tempName + " // " + tempIdade + " // " + animCast;
				petDescrp = this.petGato.getDescricao();
		}
		
		String response = petString + "\n" + petDescrp + "\n" + "Author: " + user.getNome() + " // " + user.getCelular() + "\n" + cidade + " - " + estado + " // " + "DATA do CAD: " + data_post;
		
		return response;
//		return "Anuncio cidade=" + cidade + ", estado=" + estado + ", data_post=" + data_post + ", user=" + user.getNome() + ", disponivel=" + disponivel  + petString;
		
		
		
	}
	
}
