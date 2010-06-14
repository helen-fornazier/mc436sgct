
public class Artigo {

	public String titulo="";
	public String autor="";
	public String resumo="";
	public String nota="";
	public String comentarios="";
	
	
	
	
	
	public Artigo(String titulo, String autor, String resumo, String nota, String comentarios) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.resumo = resumo;
		this.nota = nota;
		this.comentarios = comentarios;
	}
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
}
