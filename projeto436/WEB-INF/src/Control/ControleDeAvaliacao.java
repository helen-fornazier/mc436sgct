package Control;
import java.util.ArrayList;
import DataBase.Avaliador;
import DataBase.Material;
import DataBase.DataBase;
import DataBase.StorageDB;

public class ControleDeAvaliacao {
	private Avaliador avaliadorLogado;
	private Sistema sistema;
	private ArrayList<Material> materiais;
	private ArrayList<Material> materiaisAvaliar;
	private ArrayList<Material> materiaisAvaliados;
	private int artigoAvaliar;

	
	public ControleDeAvaliacao(Sistema sistema){
		this.sistema = sistema;
		this.avaliadorLogado = null;
	}
	
	/**Chamado quando o login ocorre em ControleDeLogin*/
	public void setAvaliadorLogado(Avaliador avaliadorLogado) {
		this.avaliadorLogado = avaliadorLogado;
	}
	
	/**Pega a lista de material para serem avaliados pelo avaliador logado*/
	public ArrayList<Material> getListaMateriaisAvaliar() {
	
		if(materiaisAvaliar == null)
			this.getListaMateriaisAvaliador();
		
		if(materiaisAvaliar.size() > 0)
			return materiaisAvaliar;
		else
			return null;
		
	}
	
	/**Pega a lista de materiais que já foram avaliados por este avaliador*/
	public ArrayList getListaMateriaisAvaliados() {
		
		if(materiaisAvaliados == null)
			this.getListaMateriaisAvaliador();
		
		if(materiaisAvaliados.size() > 0)
			return materiaisAvaliados;
		else
			return null;
	}
	
	public void setMaterialAvaliar(int i){
		artigoAvaliar = i;
	}
	
	public int getMaterialAvaliar(){
		return artigoAvaliar;
	}
	
	/**Avalia um determinado material*/
	public boolean AvaliarMaterial(Material material, int nota, String comentarios) {
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase(); 
		
		material.avaliarMaterial(this.getIdAvaliadorLogado(), nota, comentarios);

		boolean x = database.insertMaterial(material);
		
		storage.saveDataBase(database);
		
		return x;
	}
	
	public void getListaMateriaisAvaliador(){
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase();
		
		materiais = database.searchMaterial(this.avaliadorLogado);
		System.out.println(materiais.size());
		System.out.println(materiais.get(0).getTitulo());
		System.out.println(materiais.get(1).getTitulo());
		System.out.println(materiais.get(2).getTitulo());
		materiaisAvaliar = new ArrayList<Material>();
		materiaisAvaliados = new ArrayList<Material>();
		
		for(int i = 0;i < materiais.size();i++)
			if(materiais.get(i).getNotaAvaliador(avaliadorLogado.getIdUsuario()) == -1)
				materiaisAvaliar.add(materiais.get(i));
		
		for(int i = 0;i < materiais.size();i++)
			if(materiais.get(i).getNotaAvaliador(this.getIdAvaliadorLogado()) > -1)
				materiaisAvaliados.add(materiais.get(i));
		
	}
	
	public int getIdAvaliadorLogado(){
		return avaliadorLogado.getIdUsuario();
	}
	
}