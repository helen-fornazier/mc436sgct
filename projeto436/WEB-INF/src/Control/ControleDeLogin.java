package Control;

import DataBase.Autor;
import DataBase.Avaliador;
import DataBase.Usuario;
import DataBase.DataBase;
import DataBase.StorageDB;

public class ControleDeLogin {
	private Usuario usuarioLogado;
	private Sistema sistema;
	public ControleDeLogin(Sistema sistema){
		this.usuarioLogado = null;
		this.sistema = sistema;
	}
	
	/**Seta o atributo privado usuarioLogado como o Usuario com o login
	 * e senha passados como parâmetro e retorna o Usuario. Nulo se não
	 * existir.
	 * OBS: ja seta os usuarios logados dos sistemas de submissao e avaliacao */
	public Usuario login(String login, String senha) {
		Usuario usuario = this.getUsuario(login);
		if (usuario == null || usuario.compareSenha(senha) == false) {
			this.usuarioLogado = null;
			sistema.cAvaliacao.setAvaliadorLogado(null);
			sistema.cSubmissao.setAutorLogado(null);
		}
		else {
			this.usuarioLogado = usuario;
			sistema.cAvaliacao.setAvaliadorLogado(this.getAvaliador(login));
			sistema.cSubmissao.setAutorLogado(this.getAutor(login));
		}
		return this.usuarioLogado;
	}
	
	/**retorna true se tem um usuario logado*/
	public Usuario getUsuarioLogado(){
		return this.usuarioLogado;
	}
	
	/**retorna o tipo de usuário logado, retorna null quando nenhum logado,
	 * ou não se enquadrar em nenhum tipo*/
	public String getTipoUsuarioLogado() {
		if (this.usuarioLogado == null)
			return null;
		String login = this.usuarioLogado.getLogin();
		if(this.getAutor(login) != null)
			return "autor";
		if(this.getAvaliador(login) != null)
			return "avaliador";
		if(this.getUsuario(login) != null)
			return "participante";
		else
			return null;
	}
	/**Retorna nulo se usuário não encontrado*/
	public Usuario getUsuario(String login) {
		//Carrega o Banco de dados
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		if (database == null) {
			database = new DataBase();
		}
		
		String cpf = database.searchUsuarioLogin(login);
		//Se usuário nao encontrado
		if (cpf == null)
			return null;
		
		int index = database.searchUsuario(cpf);
		if (index >= 0)
			return database.getListaUsuario().get(index);
		else
			return null;
	}
	
	/**Retorna nulo se deu problema em criar o Usuário*/
	public Usuario criaUsuario(String login, String senha, String nome, String cpf,
								String endereco, String contato, String idade, String sexo) {
		
		//Verifica se o usuário existe, se existir, retorne nulo
		//FIXME: Verificar se o insert usuário não verifica isto já, se sim, esta verifecação abaixo é inútil
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
	
	/**Retorna nulo se Autor não encontrado*/
	public Autor getAutor(String login) {
		//Carrega o Banco de dados
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		
		String cpf = database.searchUsuarioLogin(login);
		//Se usuário nao encontrado
		if (cpf == null)
			return null;
		
		int index = database.searchAutor(cpf);
		if (index >= 0)
			return database.getListaAutor().get(index);
		else
			return null;
	}
	
	/**Retorna nulo se deu problema em criar o Autor
	 * OBS: não precisa criar instância de Usuário a parte, esta função já cria*/
	public Autor criaAutor(String login, String senha, String nome, String cpf,
			String endereco, String contato, String idade, String sexo, String CV) {
		//Cria Usuário, se ele já existe a função não cria novamente
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
	
	/**Retorna nulo se Avaliador não encontrado*/
	public Avaliador getAvaliador(String login) {
		//Carrega o Banco de dados
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		
		String cpf = database.searchUsuarioLogin(login);
		//Se usuário nao encontrado
		if (cpf == null)
			return null;
		
		int index = database.searchAvaliador(cpf);
		if (index >= 0)
			return database.getListaAvaliador().get(index);
		else
			return null;
	}
	
	/**Retorna nulo se deu problema em criar o Avaliador*/
	public Avaliador criaAvaliador(String login, String senha, String nome, String cpf,
			String endereco, String contato, String idade, String sexo, String CV, String qualificacoes) {
		//Cria Usuário, se ele já existe a função não cria novamente
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