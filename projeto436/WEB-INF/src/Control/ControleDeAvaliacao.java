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
		Material material = new Material(1, "autor1, autor2", "este eh um resumo", "As baleias africanas", "Caminho estranho");
		ArrayList<Material> lista = new ArrayList<Material>();
		lista.add(material);
		return lista;
		
		/*ArrayList<Material> materiaisAvaliar = new ArrayList<Material>();
		
		if(materiais == null)
			this.getListaMateriaisAvaliador();
		
		for(int i = 0;i < materiais.size();i++)
			if(materiais.get(i).getNotaAvaliador(avaliadorLogado.getIdUsuario()) == -1)
				materiaisAvaliar.add(materiais.get(i));
		
		if(materiaisAvaliar.size() > 0)
			return materiaisAvaliar;
		else
			return null;*/
		
	}
	
	/**Pega a lista de materiais que já foram avaliados por este avaliador*/
	public ArrayList getListaMateriaisAvaliados() {
		ArrayList<Material> materiaisAvaliados = new ArrayList<Material>();
		
		if(materiais == null)
			this.getListaMateriaisAvaliador();
		
		for(int i = 0;i < materiais.size();i++)
			if(materiais.get(i).getNotaAvaliador(avaliadorLogado.getIdUsuario()) > -1)
				materiaisAvaliados.add(materiais.get(i));
		
		if(materiaisAvaliados.size() > 0)
			return materiaisAvaliados;
		else
			return null;
	}
	
	/**Avalia um determinado material*/
	public boolean AvaliarMaterial(Material material, int nota) {
		return false;
	}
	
	private void getListaMateriaisAvaliador(){
		StorageDB storage = new StorageDB();
		DataBase database = storage.loadDataBase();
		
		materiais = database.searchMaterial(this.avaliadorLogado);
	}
}