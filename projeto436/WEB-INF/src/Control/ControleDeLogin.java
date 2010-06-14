package Control;

import DataBase.Autor;
import DataBase.Avaliador;
import DataBase.Usuario;
import DataBase.DataBase;
import DataBase.StorageDB;

public class ControleDeLogin {
	private Usuario usuarioLogado;
	
	public ControleDeLogin(){
		this.usuarioLogado = null;
	}
	
	/**Seta o atributo privado usuarioLogado como o Usuario com o login
	 * e senha passados como par�metro e retorna o Usuario. Nulo se n�o
	 * existir */
	public Usuario login(String login, String senha) {
		Usuario usuario = this.getUsuario(login);
		if (usuario == null || usuario.compareSenha(senha) == false)
			this.usuarioLogado = null;
		else
			this.usuarioLogado = usuario;
		return this.usuarioLogado;
	}
	
	/** Seta o usuarioLogado como null*/
	public void logout() {
		this.usuarioLogado = null;
	}
	
	/**retorna true se tem um usuario logado*/
	public Usuario getUsuarioLogado(){
		return this.usuarioLogado;
	}
	
	/**Retorna nulo se usu�rio n�o encontrado*/
	public Usuario getUsuario(String login) {
		//Carrega o Banco de dados
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		if (database == null) {
			database = new DataBase();
		}
		
		String cpf = database.searchUsuarioLogin(login);
		//Se usu�rio nao encontrado
		if (cpf == null)
			return null;
		
		return database.getListaUsuario().get(database.searchUsuario(cpf));
	}
	
	/**Retorna nulo se deu problema em criar o Usu�rio*/
	public Usuario criaUsuario(String login, String senha, String nome, String cpf,
								String endereco, String contato, String idade, String sexo) {
		
		//Verifica se o usu�rio existe, se existir, retorne nulo
		//FIXME: Verificar se o insert usu�rio n�o verifica isto j�, se sim, esta verifeca��o abaixo � in�til
		if (this.getUsuario(login) != null)
			return null;		
		//Carrega o Banco de dados
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		if (database == null) {
			database = new DataBase();
		}
		if (!database.insertUsuario(login, senha, nome, cpf, endereco, contato, idade, sexo, "false"))
			return null;
		
		//Salva no banco de dados
		storage.saveDataBase(database);
		
		return database.getListaUsuario().get(database.searchUsuario(cpf));
	}
	
	/**Retorna nulo se Autor n�o encontrado*/
	public Autor getAutor(String login) {
		//Carrega o Banco de dados
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		
		String cpf = database.searchUsuarioLogin(login);
		//Se usu�rio nao encontrado
		if (cpf == null)
			return null;
		
		return database.getListaAutor().get(database.searchAutor(cpf));
	}
	
	/**Retorna nulo se deu problema em criar o Autor
	 * OBS: n�o precisa criar inst�ncia de Usu�rio a parte, esta fun��o j� cria*/
	public Autor criaAutor(String login, String senha, String nome, String cpf,
			String endereco, String contato, String idade, String sexo, String CV) {
		//Cria Usu�rio, se ele j� existe a fun��o n�o cria novamente
		this.criaUsuario(login, senha, nome, cpf, endereco, contato, idade, sexo);
		//Carrega o Banco de dados
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase();
		if (database.insertAutor(cpf, CV) == false)
			return null;		
		//Salva no banco de dados
		storage.saveDataBase(database);
		
		return database.getListaAutor().get(database.searchAutor(cpf));
	}
	
	/**Retorna nulo se Avaliador n�o encontrado*/
	public Avaliador getAvaliador(String login) {
		//Carrega o Banco de dados
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		
		String cpf = database.searchUsuarioLogin(login);
		//Se usu�rio nao encontrado
		if (cpf == null)
			return null;
		
		return database.getListaAvaliador().get(database.searchAvaliador(cpf));
	}
	
	/**Retorna nulo se deu problema em criar o Avaliador*/
	public Avaliador criaAvaliador(String login, String senha, String nome, String cpf,
			String endereco, String contato, String idade, String sexo, String CV, String qualificacoes) {
		//Cria Usu�rio, se ele j� existe a fun��o n�o cria novamente
		this.criaUsuario(login, senha, nome, cpf, endereco, contato, idade, sexo);
		//Carrega o Banco de dados
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase();
		if (database.insertAvaliador(cpf, qualificacoes, CV) == false)
			return null;
		
		//Salva no banco de dados
		storage.saveDataBase(database);
		
		return database.getListaAvaliador().get(database.searchAvaliador(cpf));
	}
	
}