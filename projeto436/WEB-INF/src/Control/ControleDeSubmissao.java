package Control;

import DataBase.*;

public class ControleDeSubmissao {
	Autor autorLogado;
	Sistema sistema;
	
	public ControleDeSubmissao(Sistema sistema){
		this.sistema = sistema;
		this.autorLogado = null;
	}
	
	public Material novoMaterial(String autores, String resumo, String titulo, String pwdArquivo){
		Material material = new Material(autorLogado.getIdUsuario(), autores, resumo, titulo, pwdArquivo);
		return material;		
	}
	
	/**Chamado quando o login ocorre em ControleDeLogin*/
	public void setAutorLogado(Autor autorLogado) {
		this.autorLogado = autorLogado;
	}
	
	public boolean registrarMaterial(Material material){
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		
		material.setAvaliadores(database.getRndAvaliadores());

		boolean x = database.insertMaterial(material);
		
		System.out.println(x);
		
		storage.saveDataBase(database);
		
		return x;
	}
}