package models;

import java.util.List;

public class Mensagem {
    private String texto;
    private String data;
    private List<Mensagem> respostas;
    private Usuario user;

    public Mensagem(String texto, String data, List<Mensagem> respostas, Usuario autor){
        this.texto = texto;
        this.data = data;
        this.respostas = respostas;
        this.user = autor;
    }

    public String getTexto(){
        return this.texto;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public void insertResposta(Mensagem resposta){
        this.respostas.add(resposta);
    }

    public List<Mensagem> ListaDeRespostas(){
        return this.respostas;
    }

    public String getAutor(){
        return this.user.getNome();
    }
    
    public String getData(){
    	return this.data;
    }
}