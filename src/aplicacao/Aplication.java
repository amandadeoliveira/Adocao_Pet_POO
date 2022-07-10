package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Animal_Cachorro;
import models.Animal_Gato;
import models.Usuario;
import models.Anuncio;


public class Aplication {
	private List<Animal_Gato> Lista_Gatos;
	private List<Animal_Cachorro> Lista_Cachorro;
	private List<Usuario> Lista_Usuario;
	private List<Anuncio> Lista_Anuncio;
	
	
	
	public Aplication() {
		super();
		this.Lista_Gatos = new ArrayList<>(); 
		this.Lista_Cachorro = new ArrayList<>();
		this.Lista_Anuncio = new ArrayList<>();
		this.Lista_Usuario = new ArrayList<>();
	}



	public void setLista_Gatos(List<Animal_Gato> lista_Gatos){
		Lista_Gatos = lista_Gatos;
	}

	public List<Animal_Gato> getLista_Gatos(){
		return Lista_Gatos;
	}
	
	public void insertGato(Animal_Gato gatin){
		this.getLista_Gatos().add(gatin);
	}
	
	
	public void setLista_Cachorro(List<Animal_Cachorro> lista_Cachorro){
		Lista_Cachorro = lista_Cachorro;
	}
	
	public List<Animal_Cachorro> getLista_Cachorro(){
		return Lista_Cachorro;
	}
	
	public void insertCachorro(Animal_Cachorro dogin){
		this.Lista_Cachorro.add(dogin);
	}
	
	
	public void setUsuario(List<Usuario> lista_Usuario){
		Lista_Usuario = lista_Usuario;
	}
	 
	public List<Usuario> getLista_Usuario(){
		return Lista_Usuario;
	}
	
	public void insertUsuario(Usuario user){
		this.Lista_Usuario.add(user);
	}
	
	
	public void setLista_Anuncio(List<Anuncio> lista_Anuncio){
		Lista_Anuncio = lista_Anuncio;
	}
	
	public List<Anuncio> getLista_Anuncio(){
		return Lista_Anuncio;
	}
	
	public void insertAnuncio(Anuncio post){
		this.Lista_Anuncio.add(post);
	}
	
	
	
	
	
	public static void main(String[] args){
		
		Aplication app = new Aplication();
		boolean exit = false;
		
		
		Scanner scan = new Scanner(System.in);
		
		while (!exit){
			System.out.println("Olá, o que deseja cadastrar?\n" + "(1)Gato (2)Cachorro");
			String line = scan.nextLine();
			
			//Criando e Inserindo um Gato
			if (line.equals("1")){
				
				System.out.println("Qual é o nome do gato?");
				String cat_name = scan.nextLine();
				
				System.out.println("Qual é o sexo?");
				String cat_sex = scan.nextLine();
				
				System.out.println("Uma breve descrição:");
				String cat_desc = scan.nextLine();
				
				System.out.println("A idade do pet?");
				int cat_age = Integer.parseInt(scan.nextLine());
				Animal_Gato gato = new Animal_Gato(cat_name, cat_sex, cat_desc, cat_age);

				System.out.println("O pet é castrado?\n"
						+ "(1)Sim (2)Não");
				String cat_castrated = scan.nextLine();
				if (cat_castrated.equals("1")){
					gato.setCastrado(true);
				} else {
					gato.setCastrado(false);
				}
				app.insertGato(gato);
				
				System.out.println(cat_name + " foi cadastrado(a)");
			}
			if (line.equals("2")){
				
				System.out.println("Qual é o nome do cachorro?");
				String dog_name = scan.nextLine();
				
				System.out.println("Qual é o sexo?");
				String dog_sex = scan.nextLine();
				
				System.out.println("Uma breve descrição:");
				String dog_desc = scan.nextLine();
				
				System.out.println("A idade do pet?");
				int dog_age = Integer.parseInt(scan.nextLine());
				Animal_Cachorro dog = new Animal_Cachorro(dog_name, dog_sex, dog_desc, dog_age);
				
				System.out.println("O pet é castrado?\n"
						+ "(1)Sim (2)Não");
				String dog_castrated = scan.nextLine();
				
				if (dog_castrated.equals("1")){
					dog.setCastrado(true);
				} else {
					dog.setCastrado(false);
				}
				app.insertCachorro(dog);
				
				System.out.println(dog_name + " foi cadastrado(a)");
			}
		}
		scan.close();
	}
	
}
