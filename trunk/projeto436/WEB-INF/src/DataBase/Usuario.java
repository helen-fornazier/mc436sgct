package DataBase;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String login, senha;
	private String nome, CPF;
	private String endereco, contato;
	private Integer idade;
	private char sexo;
	private boolean status;
	private String historico;
	
	/* Construtor da Classe - Converte Strings nos tipos corretos */
	public Usuario(String login, String senha, String nome, String CPF,
					String endereco, String contato, String idade, String sexo,
					String status){
		
		this.login = login;
		this.senha = senha;
		this.nome = nome.toUpperCase();
		this.CPF = CPF;
		this.endereco = endereco;
		this.contato = contato;
		this.idade = Integer.parseInt(idade, 10);
		this.sexo = sexo.toLowerCase().charAt(0);
		
		if(status.compareTo("true") == 0){
			this.status = true;
		} else if(status.compareTo("false") == 0)
			this.status = false;

		this.historico = null;
	}
	
	/* Checa se um login esta correto */
	public boolean checkLogin(String login, String senha) {
		
		//Se o login e a senha estiverem corretos -> true
		if( (this.login.compareTo(login) == 0) && (this.senha.compareTo(senha) == 0) )
			return true;
		else return false;
	}
	
	/* Retorna login */
	public String getLogin(){
		return this.login;
	}
		
	/* Seta senha, somente se a antiga estiver correta */
	public boolean setSenha(String oldSenha, String newSenha){
		
		if(this.senha.compareTo(oldSenha) == 0){
			this.senha = newSenha;
			return true;
		} else {
			return false;
		}
			
	}
	
	/* Retorna nome */
	public String getNome(){
		return this.nome;
	}

	/* Retorna CPF */
	public String getCPF(){
		return this.CPF;
	}
	
	/* Retorna endereco */
	public String getEndereco(){
		return this.endereco;
	}
	
	/* Retorna contato */
	public String getContato(){
		return this.contato;
	}
	
	/* Retorna idade */
	public Integer getIdade(){
		return this.idade;
	}
	
	/* Retorna sexo */
	public char getSexo(){
		return this.sexo;
	}
	
	/* Retorna status */
	public boolean getStatus(){
		return this.status;
	}
	
	/* Retorna historico */
	public String getHistorico(){
		return this.historico;
	}
	
	/* Seta nome */
	public void setNome(String newNome){
		this.nome = newNome;
	}
	
	/* Seta CPF */
	public void setCPF(String newCPF){
		this.CPF = newCPF;
	}
	
	/* Seta endereco */
	public void setEndereco(String newEndereco){
		this.endereco = newEndereco;
	}
	
	/* Seta contato */
	public void setContato(String newContato){
		this.contato = newContato;
	}
	
	/* Seta idade */
	public void setIdade(String newIdade){
		this.idade = Integer.parseInt(newIdade, 10);
	}
	
	/* Muda sexo */
	public char changeSexo(){
		if(this.sexo == 'm'){
			this.sexo = 'f';
			return this.sexo;
		} else if(this.sexo == 'f'){
			this.sexo = 'm';
			return this.sexo;
		} else {
			this.sexo = 'm';
			return this.sexo;
		}
	}
	
	/* Muda status */
	public boolean changeStatus(){
		if(this.status){
			this.status = false;
			return this.status;
		} else { 
			this.status = true;
			return this.status;
		}
	}
		
	
}
