package DataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataBase implements Serializable{

	private LinkedList<Usuario>   listaUsuario;
	private LinkedList<Autor>     listaAutor;
	private LinkedList<Avaliador> listaAvaliador;
	
	private boolean status;
	
	/* Construtor da classe */
	public DataBase(){
		this.listaAutor = new LinkedList<Autor>();
		this.listaAvaliador = new LinkedList<Avaliador>();
		this.listaUsuario = new LinkedList<Usuario>();
		this.status = true;
	}
	
	/* Altera status do DataBase */
	public void changeStatus(){
		if(this.status){
			this.status = false;
		} else {
			this.status = true;
		}
	}
	
	/* Retorna status */
	public boolean getStatus(){
		return this.status;
	}
	
	/* Inseri um Usuario no DataBase 
	 *   Se ja existir Usuario com mesmo login ou CPF, return false.
	 *
	 */
	public boolean insertUsuario(String login, String senha, String nome, String CPF,
			String endereco, String contato, String idade, String sexo,
			String status){
		
		if( (this.searchUsuario(CPF) != -1) || (this.searchUsuarioLogin(login) != null) ) return false;
		else{
			Usuario newUsuario = new Usuario(login, senha, nome, CPF, endereco, contato, idade, sexo, status);
			this.listaUsuario.add(newUsuario);
			return true;
		}
	}
	
	/* Busca um Usuario no DataBase pelo login -> retorna o CPF
	 *   Se nao encontrar -> null
	 */
	public String searchUsuarioLogin(String login){
		
		for (int i = 0; i < this.listaUsuario.size(); i++) {
			if(this.listaUsuario.get(i).getLogin().compareTo(login) == 0)
				return this.listaUsuario.get(i).getCPF();
		}
		return null;
	}
	
	/* Busca Usuarios no DataBase pelo nome (regex) -> retorna os CPFs
	 *   Se nao encontrar -> String[] vazio
	 */
	public String[] searchUsuarioNome(String nomeRegex){
		
		String regex = ".*" + nomeRegex.toUpperCase() + ".*"; //Regex para casar com o nome dos Usuarios
		
		ArrayList<String> CPFs = new ArrayList<String>(); //Vetor dos CPFs
		
		for (int i = 0; i < this.listaUsuario.size(); i++) {
			if(this.listaUsuario.get(i).getNome().matches(regex))
				CPFs.add(this.listaUsuario.get(i).getCPF());
		}
		return (String[]) CPFs.toArray(new String[CPFs.size()]);
	}
	
	/* Busca um Usuario no DataBase pelo CPF -> retorna o indice na lista
	 *   Se nao encontrar -> -1
	 */
	public int searchUsuario(String CPF){
		
		for (int i = 0; i < this.listaUsuario.size(); i++) {
			if(this.listaUsuario.get(i).getCPF().compareTo(CPF) == 0)
				return i;
		}
		return -1;
	}
	
	/* Remove um Usuario no DataBase pelo CPF -> retorna true se bem sucedido */
	public boolean removeUsuario(String CPF){
		
		int index = this.searchUsuario(CPF); //Procurando Usuario no DB.
		if(index == -1) return false; //Nao encontrou.
		else{ //Encontrou.
			this.listaUsuario.remove(index);
			return true;
		}
	}
	
	/* Retorna Lista de Usuario */
	public LinkedList<Usuario> getListaUsuario(){
		return this.listaUsuario;
	}
	
	/* Inseri um Avaliador no DataBase 
	 *   Verifica se o Usuario existe.
	 *
	 */
	public boolean insertAvaliador(String CPF, String qualificacoes, String CV){
		
		int index = this.searchUsuario(CPF); //Verif. se o Usuario existe.
		
		if(index == -1) return false; //Nao existe
		else{ //Existe
			
			Avaliador avaliador = new Avaliador(index, qualificacoes, CV);
			this.listaAvaliador.add(avaliador);
			return true;
		}
	}
	
	/* Busca um Avaliador no DataBase pelo CPF -> retorna o indice na lista
	 *   Se nao for Usuario -> -1
	 *   Se for Usuario, mas nao Avaliador -> -2
	 */
	public int searchAvaliador(String CPF){
		
		int index = this.searchUsuario(CPF); //Procurando Usuario com o CPF informado 
		
		if(index == -1) return -1; //Avaliador nao foi encontrado
		else{
			//Usuario com o CPF foi encontrado, verificando se eh avaliador
			for (int i = 0; i < this.listaAvaliador.size(); i++) {
				if(this.listaAvaliador.get(i).getIdUsuario() == index) return i; //Encontrou
			}
			return -2; //Usuario nao eh avaliador
		}
	}
	
	/* Busca um Avaliador no DataBase pelo idUsuario -> retorna o indice na lista
	 *   Se nao Avaliador -> -1
	 */
	public int searchAvaliador(int idUsuario){
		
		if(idUsuario < 0) return -1; //IdUsuario errado
		else{
			//Verificando se eh avaliador
			for (int i = 0; i < this.listaAvaliador.size(); i++) {
				if(this.listaAvaliador.get(i).getIdUsuario() == idUsuario) return i; //Encontrou
			}
			return -1; //Nao encontrou
		}
	}
	
	/* Remove um Usuario no DataBase pelo CPF -> retorna true se bem sucedido */
	public boolean removeAvaliador(String CPF){
		
		int index = this.searchAvaliador(CPF); //Procurando Avaliador no DB.
		if(index < 0) return false; //Nao encontrou.
		else{ //Encontrou.
			this.listaAvaliador.remove(index);
			return true;
		}
	}
	
	/* Remove um Usuario no DataBase pelo IdUsuario -> retorna true se bem sucedido */
	public boolean removeAvaliador(int idUsuario){
		
		int index = this.searchAvaliador(idUsuario); //Procurando Avaliador no DB.
		if(index < 0) return false; //Nao encontrou.
		else{ //Encontrou.
			this.listaAvaliador.remove(index);
			return true;
		}
	}
	
	/* Retorna Lista de Avaliador */
	public LinkedList<Avaliador> getListaAvaliador(){
		return this.listaAvaliador;
	}
	
	
	
	
	
	
	
	/* Inseri um Autor no DataBase 
	 *   Verifica se o Usuario existe.
	 *
	 */
	public boolean insertAutor(String CPF, String CV){
		
		int index = this.searchUsuario(CPF); //Verif. se o Usuario existe.
		
		if(index == -1) return false; //Nao existe
		else{ //Existe
			
			Autor autor = new Autor(index, CV);
			this.listaAutor.add(autor);
			return true;
		}
	}
	
	/* Busca um Autor no DataBase pelo CPF -> retorna o indice na lista
	 *   Se nao for Usuario -> -1
	 *   Se for Usuario, mas nao Autor -> -2
	 */
	public int searchAutor(String CPF){
		
		int index = this.searchUsuario(CPF); //Procurando Usuario com o CPF informado 
		
		if(index == -1) return -1; //Autor nao foi encontrado
		else{
			//Usuario com o CPF foi encontrado, verificando se eh autor
			for (int i = 0; i < this.listaAutor.size(); i++) {
				if(this.listaAutor.get(i).getIdUsuario() == index) return i; //Encontrou
			}
			return -2; //Usuario nao eh autor
		}
	}
	
	/* Busca um Autor no DataBase pelo idUsuario -> retorna o indice na lista
	 *   Se nao Autor -> -1
	 */
	public int searchAutor(int idUsuario){
		
		if(idUsuario < 0) return -1; //IdUsuario errado
		else{
			//Verificando se eh autor
			for (int i = 0; i < this.listaAutor.size(); i++) {
				if(this.listaAutor.get(i).getIdUsuario() == idUsuario) return i; //Encontrou
			}
			return -1; //Nao encontrou
		}
	}
	
	/* Remove um Autor no DataBase pelo CPF -> retorna true se bem sucedido */
	public boolean removeAutor(String CPF){
		
		int index = this.searchAutor(CPF); //Procurando Avaliador no DB.
		if(index < 0) return false; //Nao encontrou.
		else{ //Encontrou.
			this.listaAutor.remove(index);
			return true;
		}
	}
	
	/* Remove um Autor no DataBase pelo IdUsuario -> retorna true se bem sucedido */
	public boolean removeAutor(int idUsuario){
		
		int index = this.searchAutor(idUsuario); //Procurando Avaliador no DB.
		if(index < 0) return false; //Nao encontrou.
		else{ //Encontrou.
			this.listaAutor.remove(index);
			return true;
		}
	}
	
	/* Retorna Lista de Autor */
	public LinkedList<Autor> getListaAutor(){
		return this.listaAutor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void printDatabase(DataBase DB){
		
		//Usuario
		System.out.printf("### USUARIO ###\n");
		for (int i = 0; i < DB.getListaUsuario().size(); i++) {
			System.out.printf("%s / %s / ", DB.getListaUsuario().get(i).getLogin(), DB.getListaUsuario().get(i).getNome());
			System.out.println(DB.getListaUsuario().get(i).getStatus());
		}
		System.out.printf("\n\n");
		
		//Avaliador
		System.out.printf("### AVALIADOR ###\n");
		for (int i = 0; i < DB.getListaAvaliador().size(); i++) {
			System.out.println(DB.getListaAvaliador().get(i).getQualificacoes());
		}
		System.out.printf("\n\n");
		
		//Autor e material
		System.out.printf("### AUTOR E MATERIAL ###\n");
		for (int i = 0; i < DB.getListaAutor().size(); i++) {
			System.out.println(DB.getListaAutor().get(i).getIdUsuario());
			System.out.printf("\t");
			for (int j = 0; j < DB.getListaAutor().get(i).getListaMaterial().size(); j++) {
				System.out.printf("%s / ", DB.getListaAutor().get(i).getListaMaterial().get(j).getTitulo());
			}
			System.out.printf("\n");
		}
		System.out.printf("\n\n");
	}
	
}
