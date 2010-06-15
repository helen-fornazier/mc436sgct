package Control;
import java.util.ArrayList;

import DataBase.Avaliador;
import DataBase.Material;
public class ControleDeAvaliacao {
	private Avaliador avaliadorLogado;
	private Sistema sistema;
	
	public ControleDeAvaliacao(Sistema sistema){
		this.sistema = sistema;
		this.avaliadorLogado = null;
	}
	
	public void setAvaliadorLogado(Avaliador avaliadorLogado) {
		this.avaliadorLogado = avaliadorLogado;
	}
	
	/**Pega a lista de material para serem avaliados pelo avaliador logado*/
	public ArrayList<Material> getListaMateriaisAvaliar() {
		Material material = new Material(1, "autor1, autor2", "este eh um resumo", "As baleias africanas", "Caminho estranho");
		ArrayList<Material> lista = new ArrayList<Material>();
		lista.add(material);
		return lista;
	}
	
	/**Pega a lista de materiais que já foram avaliados por este avaliador*/
	public ArrayList<Material> getListaMateriaisAvaliados() {
		return null;
	}
	
	/**Avalia um determinado material*/
	public boolean AvaliarMaterial(Material material, int nota) {
		return false;
	}
}