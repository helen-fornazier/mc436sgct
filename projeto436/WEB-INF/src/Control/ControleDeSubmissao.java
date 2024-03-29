package Control;

import java.util.ArrayList;
import DataBase.Autor;
import DataBase.Material;
import DataBase.DataBase;
import DataBase.StorageDB;

public class ControleDeSubmissao {
	Autor autorLogado;
	Sistema sistema;
	private ArrayList<Material> materiaisSubmetidos;
	private int arquivoEmEdicao;
	
	public ControleDeSubmissao(Sistema sistema){
		this.sistema = sistema;
		this.autorLogado = null;
	}
	
	public void setArquivoEmEdicao(int i){
		arquivoEmEdicao = i;
	}
	
	public int getArquivoEmEdicao(){
		return arquivoEmEdicao;
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
		
		//d� update na lista de materiais submetidos
		this.materiaisSubmetidos = this.getMateriaisSubmetidosFromDB();
		return x;
	}
	
	/**Retorna a lista de materiais que este autor j� submeteu*/
	public ArrayList<Material> getMateriaisSubmetidos(){
		
		if(materiaisSubmetidos == null)
			this.getMateriaisSubmetidosFromDB();
		
		if(materiaisSubmetidos.size() > 0)
			return materiaisSubmetidos;
		else
			return null;
	}
	
	private ArrayList<Material> getMateriaisSubmetidosFromDB () {
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase();
		
		this.materiaisSubmetidos = database.searchMaterial(this.autorLogado);
		
		return this.materiaisSubmetidos;
	}
	
	/**Remove material do autor logado com o determinado titulo*/
	public boolean removerMaterial(Material material) {
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase();
		
		System.out.println("Entrou na remocao no ControleDeSubmissao");
		if(database.removeMaterial(material.getTitulo())){
			storage.saveDataBase(database);
			this.materiaisSubmetidos.remove(material);
			return true;
		}
		else return false;
	}
	
	/**Altera material do autor logado com o determinado titulo*/
	public boolean alteraMaterial(Material material, String novoArquivo) {
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase();
		
		material.setPwdArquivo(novoArquivo);
		
		System.out.println("Entrou na alteracao no ControleDeSubmissao");
		if(database.insertMaterial(material)){
			storage.saveDataBase(database);
			//d� update na lista de materiais submetidos
			this.materiaisSubmetidos = this.getMateriaisSubmetidosFromDB();
			return true;
		}
		else return false;
	}
	
	/**Retorna o material do autor logado com o determinado titulo
	 * Retorna null se n�o encontrou*/
	public Material getMaterial(String titulo) {
		Material material = null;
		for(int i = 0; i < this.materiaisSubmetidos.size(); i++) {
			if(this.materiaisSubmetidos.get(i).getTitulo().compareTo(titulo) == 0)
				material = this.materiaisSubmetidos.get(i);
		}
		return material;
	}
	
}