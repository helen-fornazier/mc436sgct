package Control;

import DataBase.*;

public class ControleDeSubmissao {
	Autor autorLogado;
	Sistema sistema;
	
	public ControleDeSubmissao(Sistema sistema){
		this.sistema = sistema;
		this.autorLogado = null;
	}
	
	private Material novoMaterial(String autores, String resumo, String titulo, String pwdArquivo){
		Material material = new Material(autorLogado.getIdUsuario(), autores, resumo, titulo, pwdArquivo);
		return material;		
	}
	
	public void setAutorLogado(Autor autorLogado) {
		this.autorLogado = autorLogado;
	}
	
	public boolean registrarMaterial(Material material){
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		
		boolean x = database.insertMaterial(material);
		
		storage.saveDataBase(database);
		
		return x;
	}
}