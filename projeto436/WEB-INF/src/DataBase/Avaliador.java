package DataBase;

import java.io.Serializable;

public class Avaliador implements Serializable {

	private int idUsuario;
	private String qualificacoes;
	private String pwdCV;
	private boolean status;
	
	/* Construtor da classe */
	public Avaliador(int idUsuario, String qualificacoes, String CV){
		
		this.idUsuario = idUsuario;
		this.qualificacoes = qualificacoes;
		this.pwdCV = CV;
		
		this.status = true;
	}
	
	/* Altera status do Avaliador */
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
	
	/* Retorna o id do Usuario (chave estrangeira) */
	public int getIdUsuario(){
		return this.idUsuario;
	}
	
	/* Retorna as qualificacoes */
	public String getQualificacoes(){
		return this.qualificacoes;
	}
	
	/* Retorna o endereco que esta armazenado o CV */
	public String getPwdCV(){
		return this.pwdCV;
	}
	
	/* Seta as qualificacoes */
	public void setQualificacoes(String newQualificacoes){
		this.qualificacoes = newQualificacoes;
	}
	
	/* Seta o novo pwd CV */
	public void setPwdCV(String newPwdCV){
		this.pwdCV = newPwdCV;
	}
	
}
