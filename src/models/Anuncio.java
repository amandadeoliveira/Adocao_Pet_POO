package models;

public class Anuncio {
	private String cidade;
	private String estado;
	private String data_post;
	private Animal_Gato petGato;
	private Animal_Cachorro petCachorro;
	private Usuario user;
	
	public Anuncio(String cidade, String estado, String data_post, Usuario autor){
	        this.cidade = cidade;
	        this.estado = estado;
	        this.data_post = data_post;
	        this.user = autor;
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
}