package Control;

import DataBase.*;

public class ControleDeSubmissao {
	Autor autor;
	
	public ControleDeSubmissao(Sistema sistema){
		this.autor = sistema.cLogin.getAutor(sistema.cLogin.getUsuarioLogado().getLogin());
	}
	
	private Material novoMaterial(String autores, String resumo, String titulo, String pwdArquivo){
		Material material = new Material(autor.getIdUsuario(), autores, resumo, titulo, pwdArquivo);
		return material;		
	}
	
	public boolean registrarMaterial(Material material){
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		
		boolean x = database.insertMaterial(material);
		
		storage.saveDataBase(database);
		
		return x;
	}
}