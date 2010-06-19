import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import Control.Sistema;
import DataBase.Material;

public class AvaliacaoServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		this.doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if(sistema == null) {
			sistema = new Sistema();
			request.getSession().setAttribute("sistema", sistema);
		}
		
		String comentarios = String.valueOf(request.getParameter("comentarios"));
		System.out.println("comentarios = "+comentarios);

		String nota = String.valueOf(request.getParameter("nota"));
		System.out.println("nota = "+nota);
		
		int i = sistema.cAvaliacao.getMaterialAvaliar();
		int lista = sistema.cAvaliacao.getUsarLista();
		ArrayList<Material> listaMateriais;
		
		if(lista == 0){
			listaMateriais = sistema.cAvaliacao.getListaMateriaisAvaliar();
		}else{
			listaMateriais = sistema.cAvaliacao.getListaMateriaisAvaliados();
		}
			
		Material material = listaMateriais.get(i);
		
		sistema.cAvaliacao.AvaliarMaterial(material, Integer.parseInt(nota), comentarios);

		RequestDispatcher rdIndex = request.getRequestDispatcher("listaArtigosAvaliacao.jsp");
		rdIndex.forward(request, response);
	}	
}
