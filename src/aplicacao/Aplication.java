package aplicacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	public void saveDatabase(){
		
		try{
			FileOutputStream fos = new FileOutputStream("userDB");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject( this.Lista_Usuario );
			oos.close();
			fos.close();
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		try{
			FileOutputStream fos = new FileOutputStream("gatosDB");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.Lista_Gatos);
			oos.close();
			fos.close();
		}
		
		catch (IOException ama) {
			ama.printStackTrace();
		}
		
		try{
			FileOutputStream fos = new FileOutputStream("dogsDB");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.Lista_Cachorro);
			oos.close();
			fos.close();
		}
		
		catch (IOException nda){
			nda.printStackTrace();
		}
		
		try{
			FileOutputStream fos = new FileOutputStream("anunciosDB");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.Lista_Anuncio);
			oos.close();
			fos.close();
		}
		
		catch (IOException pei){
			pei.printStackTrace();
		}
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void loadDatabase(){
		
		try {
			FileInputStream finputStream = new FileInputStream("userDB");
			ObjectInputStream oinputStream = new ObjectInputStream( finputStream );
			
			
			Lista_Usuario =  ( ArrayList<Usuario> ) oinputStream.readObject();
			oinputStream.close();
			finputStream.close();
			
		} catch ( IOException e ) {
			System.out.println("loadDatabase error: "+  e.getMessage());
		} catch (ClassNotFoundException c) {
			System.out.println("loadDatabase error: "+  c.getMessage());
		}

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
		saveDatabase();
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
		app.loadDatabase();
		boolean exit = false;
		
		
		Scanner scan = new Scanner(System.in);
		
		while (!exit){
			
			System.out.println("caduser:   cadastrar usuário\n"
							 + "cadanunc:  cadastrar anuncio\n"
							 + "read:      ler anuncios cadastrados\n"
							 + "cadpet:    cadastrar um pet\n"
							 + "readpets:  ver animais cadastrados\n"
							 + "adote:     adotar um pet\n"
							 + "sair:      encerrar o sistema");
			String line = scan.nextLine();
			
			if (line.equals("sair")){
				exit = true;
			}
			if( line.equals("cadanunc") ) {
				System.out.println("Vamos fazer o anuncio de um pet:\n Esse pet, é um (1) Gatinho ou (2)Doguinho?\n");
				String choice = scan.nextLine();
				if( choice.equals("1") ) {
					choice = "";
					System.out.println("O gatinho já deve estar cadastrado no sistema. Qual o nome dele?");
					String pet = scan.nextLine();
						   pet = pet.toLowerCase();
					for( Animal_Gato gato : app.getLista_Gatos() ) {
						if ( gato.getNome().toLowerCase().equals(pet) ) {
							
							System.out.println("Vamos identifica-lo usuario. Me diga qual seu nome:");
							String tname = scan.nextLine();
							tname = tname.toLowerCase();
							for ( Usuario user : app.getLista_Usuario() ) {
								if( user.getNome().toLowerCase().equals(tname) ) {
									System.out.println("te encontrei :)\nCriar o anuncio de " + gato.getNome() + "? (1)sim (2)não ");
									choice = scan.nextLine();
									if ( choice.equals("1") ) {
										System.out.println("Me diga em que estado " + gato.getNome() + " está:");
										String estado = scan.nextLine();
										System.out.println("Me diga em que cidade " + gato.getNome() + " está:");
										String cidade = scan.nextLine();
										DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
										Date date = new Date();
										String date_post = dateFormat.format(date);
										
										Anuncio tempAnuncio = new Anuncio(cidade, estado, date_post, user );
										tempAnuncio.setAnimalGato(gato);
										app.insertAnuncio( tempAnuncio );
										app.saveDatabase();
										System.out.println("------------");
										
									}else {
										choice = "";
										System.out.println("tudo bem, " + gato.getNome() + " ainda não foi cadastrada para adoção");
									}
									
									
								}else {
									System.out.println("Sinto muito, para cadastrar um anuncio, você precisa estar cadastrado;");
								}
							}
						}else {
							System.out.println("Gatinho não encontrado :( \n");
						}
					}
				} else if ( choice.equals("2") ) {
					System.out.println("O doguinho já deve estar cadastrado no sistema. Qual o nome dele?");
					String pet = scan.nextLine();
					 	   pet = pet.toLowerCase();
					for( Animal_Cachorro dogin : app.getLista_Cachorro() ) {
						if ( dogin.getNome().toLowerCase().equals(pet) ) {
							System.out.println("Vamos identifica-lo usuario. Me diga qual seu nome:");
							String tname = scan.nextLine();
							tname = tname.toLowerCase();
							for ( Usuario user : app.getLista_Usuario() ) {
								if( user.getNome().toLowerCase().equals(tname) ) {
									System.out.println("te encontrei :)\nCriar o anuncio de " + dogin.getNome() + "? (1)sim (2)não ");
									choice = scan.nextLine();
									if ( choice.equals("1") ) {
										System.out.println("Me diga em que estado " + dogin.getNome() + " está:");
										String estado = scan.nextLine();
										System.out.println("Me diga em que cidade " + dogin.getNome() + " está:");
										String cidade = scan.nextLine();
										DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
										Date date = new Date();
										String date_post = dateFormat.format(date);
										
										Anuncio tempAnuncio = new Anuncio(cidade, estado, date_post, user );
										tempAnuncio.setAnimalCachorro(dogin);
										
										app.insertAnuncio( tempAnuncio );
										app.saveDatabase();
										System.out.println("------------");
										
									}else {
										choice = "";
										System.out.println("tudo bem, " + dogin.getNome() + " ainda não foi cadastrada para adoção");
									}
									
									
								}else {
									System.out.println("Sinto muito, para cadastrar um anuncio, você precisa estar cadastrado;");
								}
							}
						}else {
							System.out.println("Doguinho não encontrado :( \n");
						}
					}
				}
				
			}
			
			
			if (line.equals("read")){
				if (app.getLista_Anuncio().size() == 0){
					System.out.println("Não existem animais para adoção");
				}else{
					List<Anuncio> templist = new ArrayList<Anuncio>();
					for (Anuncio tempAnuncio : app.getLista_Anuncio() ){
						if (tempAnuncio.getDisponivel() == true){
							templist.add(tempAnuncio);							
						}
					}
					if (templist.size() == 0) {
						System.out.println("Não existem animais para adoção");
					}else {
						for (Anuncio nda : templist) {
							System.out.println(nda.toString() + "\n");
						}
					}
				}
			}
			if (line.equals("caduser")){
				System.out.println("Qual é o seu nome?");
				String user_name = scan.nextLine();
				
				System.out.println("Telefone para contato:");
				String user_number = scan.nextLine();
				
				System.out.println("Qual é o seu email?");
				String user_email = scan.nextLine();
				
				System.out.println("Uma senha:");
				String user_pass = scan.nextLine();
				
				Usuario user = new Usuario(user_name, user_number, user_email, user_pass);
				app.insertUsuario(user);
				app.saveDatabase();
				
				System.out.println(user_name + " cadastrado(a) com sucesso\n------------");
			}
			if (line.equals("readpets")){
				System.out.println("Você deseja ver (1) gatos ou (2) cachorros?");
				line = scan.nextLine();
				if (line.equals("1")){
					List<Animal_Gato> locallist = app.getLista_Gatos();
					for ( Animal_Gato  gatin : locallist){
						System.out.println(gatin.getNome() + " " + gatin.getIdade() + " " + gatin.getRaca() + " " + gatin.getCastrado() + " \n" + gatin.getDescricao());
					}
					System.out.println("------------");
				}
				else if (line.equals("2")){
					List<Animal_Cachorro> locallist = app.getLista_Cachorro();
					for ( Animal_Cachorro dogin : locallist){
						System.out.println(dogin.getNome() + " " + dogin.getIdade() + " " + dogin.getRaca() + " " + dogin.getCastrado() + " \n" + dogin.getDescricao());
					}
					System.out.println("------------");
				}
			}
			if (line.equals("cadpet")){
				System.out.println("Você deseja cadastrar um (1) gato ou (2) cachorro?");
				line = scan.nextLine();
				
				if (line.equals("1")){
					
					System.out.println("Qual é o nome do gato?");
					String cat_name = scan.nextLine();
					
					System.out.println("Qual é o sexo?");
					String cat_sex = scan.nextLine();
					
					System.out.println("Uma breve descrição:");
					String cat_desc = scan.nextLine();
					
					System.out.println("A idade do pet?");
					String cat_age = scan.nextLine();
					Animal_Gato gato = new Animal_Gato(cat_name, cat_sex, cat_desc, cat_age);
					
					System.out.println("Qual é o raça?");
					String cat_raca = scan.nextLine();
					gato.setRaca(cat_raca);
					
					System.out.println("O pet é castrado?\n"
							+ "(1)Sim (2)Não");
					String cat_castrated = scan.nextLine();
					
					if (cat_castrated.equals("1")){
						gato.setCastrado(true);
					} else {
						gato.setCastrado(false);
					}
					app.insertGato(gato);
					app.saveDatabase();					
					System.out.println(cat_name + " foi cadastrado(a)\n------------");
				}
				if (line.equals("2")){
					
					System.out.println("Qual é o nome do cachorro?");
					String dog_name = scan.nextLine();
					
					System.out.println("Qual é o sexo?");
					String dog_sex = scan.nextLine();
					
					System.out.println("Uma breve descrição:");
					String dog_desc = scan.nextLine();
					
					System.out.println("A idade do pet?");
					String dog_age = scan.nextLine();
					Animal_Cachorro dog = new Animal_Cachorro(dog_name, dog_sex, dog_desc, dog_age);
					
					System.out.println("Qual é o raça?");
					String dog_raca = scan.nextLine();
					dog.setRaca(dog_raca);
					
					System.out.println("O pet é castrado?\n"
							+ "(1)Sim (2)Não");
					String dog_castrated = scan.nextLine();
					if (dog_castrated.equals("1")){
						dog.setCastrado(true);
					} else {
						dog.setCastrado(false);
					}
					app.insertCachorro(dog);
					app.saveDatabase();
					System.out.println(dog_name + " foi cadastrado(a)\n------------");
				}
			}
			if (line.equals("adote")){
				System.out.println("Qual o nome do pet que você deseja adotar?");
				String pet_name = scan.nextLine();
				pet_name = pet_name.toLowerCase();
				List<Animal_Gato> locallistG = app.getLista_Gatos();
				for (Animal_Gato gato : locallistG){
					if (gato.getNome().toLowerCase().equals(pet_name)){
						
						System.out.println(gato.getNome() + " encontrado, confirmar adoção?\n (1) Sim (2) Não");
						line = scan.nextLine();
						if(line.equals("1")){
							System.out.println("Qual é seu nome");
							String tempname = scan.nextLine();
							tempname = tempname.toLowerCase();
							for( Usuario user : app.getLista_Usuario()){
								if (user.getNome().toLowerCase().equals(tempname)){
									if (user.adoteCat(gato.getId()) == true ){
										app.saveDatabase();
										System.out.println("Gatin adotado\n------------");
									}else {
										System.out.println("não rolou\n------------");
									}
								}
							}
						}
						
					}
				}
				List<Animal_Cachorro> locallistC = app.getLista_Cachorro();
				for (Animal_Cachorro dogin : locallistC){
					if (dogin.getNome().toLowerCase().equals(pet_name)){
						
						System.out.println(dogin.getNome() + " encontrado, confirmar adoção? \n(1) Sim (2) Não");
						line = scan.nextLine();
						if (line.equals("1")){
							System.out.println("Qual é o seu nome?");
							String tempname = scan.nextLine();
							tempname = tempname.toLowerCase();							
							for( Usuario user : app.getLista_Usuario()){
								if (user.getNome().toLowerCase().equals(tempname)){
									if (user.adoteDog(dogin.getId()) == true  ){
										app.saveDatabase();
										System.out.println("Dogin adotado\n------------");
									}else {
										System.out.println("não rolou\n------------");
									}
									
								}
							}
						}
						if (line.equals("2")){
							line = "adote";
						}
					}
				}
				
				
				
			}
			

		}
		scan.close();
	}
	
}
