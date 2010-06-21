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
		
		//dá update na lista de materiais submetidos
		this.materiaisSubmetidos = this.getMateriaisSubmetidosFromDB();
		return x;
	}
	
	/**Retorna a lista de materiais que este autor já submeteu*/
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
	public boolean removerMaterial(String titulo) {
		Material materialASerRemovido = this.getMaterial(titulo);
		//Se não há material, não há necessidade de entrar no database.
		return this.removerMaterial(materialASerRemovido);
	}
	
	/**Remove material do autor
	 * Se não removeu nenhum retorna falso
	 * Se parametro passado é nulo, retorna falso*/
	public boolean removerMaterial(Material material) {
		//Se não há material, não há necessidade de entrar no database.
		if(material == null)
			return false;
		else {
			StorageDB storage = new StorageDB();
			DataBase database = storage.loadDataBase();
			if(database.removeMaterial(material) == false)
				return false;
			storage.saveDataBase(database);
			return true;
		}
	}
	
	/**Retorna o material do autor logado com o determinado titulo
	 * Retorna null se não encontrou*/
	public Material getMaterial(String titulo) {
		Material material = null;
		for(int i = 0; i < this.materiaisSubmetidos.size(); i++) {
			if(this.materiaisSubmetidos.get(i).getTitulo().compareTo(titulo) == 0)
				material = this.materiaisSubmetidos.get(i);
		}
		return material;
	}
	
}