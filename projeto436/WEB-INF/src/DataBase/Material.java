package DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Material implements Serializable {
	
	private int idUsuario;
	private String autores;
	private String resumo;
	private String titulo;
	private String pwdArquivo;
	private ArrayList<Integer> avaliadores;
	private ArrayList<Integer> notas;
	private ArrayList<String> comentarios;
	private boolean avaliado;
	
	/* Construtor da classe */
	public Material(int idUsuario, String autores, String resumo, String titulo, 
			String pwdArquivo){
		
		this.idUsuario = idUsuario;
		this.autores = autores;
		this.resumo = resumo;
		this.titulo = titulo;
		this.pwdArquivo = pwdArquivo;
		
		this.avaliado = false;		
	}
	
	/* Retorna idUsuario */
	public int getIdUsuario(){
		return this.idUsuario;
	}
	
	public Integer getNotaAvaliador(int avaliador){
		for(int i=0;i<this.avaliadores.size();i++)
			if(this.avaliadores.get(i).compareTo(new Integer(avaliador)) == 0){
				try{
					return this.notas.get(i);
				}catch(IndexOutOfBoundsException e){
					return new Integer(-1);
				}
			}
		return new Integer(-2);
	}
	
	/* Retorna autores */
	public String getAutores(){
		return this.autores;
	}
	
	/* Retorna resumo */
	public String getResumo(){
		return this.resumo;
	}
	
	/* Retorna titulo */
	public String getTitulo(){
		return this.titulo;
	}
	
	/* Retorna pwdArquivo */
	public String getPwdArquivo(){
		return this.pwdArquivo;
	}

	/* Retorna nota media */
	public float averageNota(){
		
		float media = 0;
		for (int i = 0; i < this.notas.size(); i++) {
			media = media + this.notas.get(i);
		}
		return (media / this.notas.size());
	}
	
	/* Retorna lista de avaliadores */
	public ArrayList<Integer> getAvaliadores(){
		return this.avaliadores;
	}
	
	/* Retorna lista de notas */
	public ArrayList<Integer> getNotas(){
		return this.notas;
	}
	
	/* Retorna comentarios */
	public ArrayList<String> getComentarios(){
		return this.comentarios;
	}
	
	/* Retorna avaliado */
	public boolean getAvaliado(){
		return this.avaliado;
	}
	
	/* Altera avaliado */
	public void changeAvaliado(){
		if(this.avaliado){
			this.avaliado = false;
		} else {
			this.avaliado = true;
		}
	}
	
	/* Seta autores */
	public void setAutores(String newAutores){
		this.autores = newAutores;
	}
	
	/* Seta resumo */
	public void setResumo(String newResumo){
		this.resumo = newResumo;
	}
	
	/* Seta titulo */
	public void setTitulo(String newTitulo){
		this.titulo = newTitulo;
	}
	
	/* Seta avaliadores */
	public void setAvaliadores(ArrayList<Integer> avaliadores){
		this.avaliadores = avaliadores;
		this.notas = new ArrayList<Integer>();
		this.comentarios = new ArrayList<String>();
		for(int i=0;i<avaliadores.size();i++){
			notas.add(new Integer(-1));
			comentarios.add(new String(""));
		}
	}
	
	/* Seta pwd Arquivo */
	public void setPwdArquivo(String newPwdArquivo){
		this.pwdArquivo = newPwdArquivo;
	}
	
	/* Avalia um material 
	 *   NOTA: os tres arrays terao o mesmo indice para uma nota e comentario, 
	 *     dada por um avaliador. 
	 * 
	 */
	public void avaliarMaterial(int idAvaliador, int nota, String comentario){
		
		//Avaliado
		for(int i=0;i<avaliadores.size();i++)
			if(avaliadores.get(i).compareTo(new Integer(idAvaliador)) == 0){
				this.notas.set(i, new Integer(nota));
				this.comentarios.set(i, comentario);
			}
	}
	
	/* Mudar nota de um avaliador 
	 *   Se o avaliador indicado nao tiver avaliado -> false 
	 */
	public boolean changeNota(int idAvaliador, int newNota){
		
		for (int i = 0; i < this.avaliadores.size(); i++) {
			if(this.avaliadores.get(i) == idAvaliador){ //Encontrei avaliador
				this.notas.set(i, newNota); //Altero a nota
			}
		}
		return false;
	}
	
	/* Mudar comentario de um avaliador 
	 *   Se o avaliador indicado nao tiver avaliado -> false 
	 */
	public boolean changeComentario(int idAvaliador, String newComentario){
		
		for (int i = 0; i < this.avaliadores.size(); i++) {
			if(this.avaliadores.get(i) == idAvaliador){ //Encontrei avaliador
				this.comentarios.set(i, newComentario); //Altero o Comentario
			}
		}
		return false;
	}

}
