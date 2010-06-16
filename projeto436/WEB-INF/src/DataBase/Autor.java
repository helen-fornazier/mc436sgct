package DataBase;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.LinkedList;

public class Autor implements Serializable {

	private int idUsuario;
	private String pwdCV;
	private LinkedList<Material> listaMaterial;
	
	private boolean status;
	
	/* Construtor da classe */
	public Autor(int idUsuario, String CV){
		
		this.idUsuario = idUsuario;
		this.pwdCV = CV;
		this.listaMaterial = new LinkedList<Material>();
		
		this.status = true;
	}
	
	/* Altera status do Autor */
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
		
	/* Retorna o endereco que esta armazenado o CV */
	public String getPwdCV(){
		return this.pwdCV;
	}
	
	/* Retorna a lista de material */
	public LinkedList<Material> getListaMaterial(){
		return this.listaMaterial;
	}
	
	/* Seta o novo pwd CV */
	public void setPwdCV(String newPwdCV){
		this.pwdCV = newPwdCV;
	}
	
	/* Inseri um material */
	public void insertMaterial(String autores, String resumo, 
			String titulo, String pwdArquivo){
		
		
		Material material = new Material(this.idUsuario, autores, resumo, titulo, pwdArquivo);
		
		this.listaMaterial.add(material);		
	}
}
