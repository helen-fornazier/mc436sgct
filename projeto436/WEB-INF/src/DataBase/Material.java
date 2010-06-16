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
	private ArrayList<Float> notas;
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
		this.notas = new ArrayList<Float>();
		this.comentarios = new ArrayList<String>();
		this.avaliadores = new ArrayList<Integer>();
		
		this.avaliado = false;		
	}
	
	/* Retorna idUsuario */
	public int getIdUsuario(){
		return this.idUsuario;
	}
	
	public float getNotaAvaliador(int avaliador){
		for(int i=0;i<this.avaliadores.size();i++)
			if(avaliador == this.avaliadores.get(i)){
				try{
					return this.notas.get(i);
				}catch(IndexOutOfBoundsException e){
					return -1;
				}
			}
		return -2;
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
	
	/* Retorna lista de notas */
	public Float[] getNotas(){
		return (Float[]) this.notas.toArray(new Float[this.notas.size()]);
	}
	
	/* Retorna lista de avaliadores */
	public ArrayList getAvaliadores(){
		//return (Integer[]) this.avaliadores.toArray(new Integer[this.avaliadores.size()]);
		return this.avaliadores;
	}
	
	/* Retorna comentarios */
	public String[] getComentarios(){
		return (String[]) this.comentarios.toArray(new String[this.comentarios.size()]);
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
	
	/* Seta pwd Arquivo */
	public void setPwdArquivo(String newPwdArquivo){
		this.pwdArquivo = newPwdArquivo;
	}
	
	/* Avalia um material 
	 *   NOTA: os tres arrays terao o mesmo indice para uma nota e comentario, 
	 *     dada por um avaliador. 
	 * 
	 */
	public void avaliarMaterial(int idAvaliador, float nota, String comentario){
		
		//Avaliado
		if(! this.avaliado) this.changeAvaliado();
		
		this.avaliadores.add(idAvaliador);
		this.notas.add(nota);
		this.comentarios.add(comentario);
	}
	
	/* Mudar nota de um avaliador 
	 *   Se o avaliador indicado nao tiver avaliado -> false 
	 */
	public boolean changeNota(int idAvaliador, float newNota){
		
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
