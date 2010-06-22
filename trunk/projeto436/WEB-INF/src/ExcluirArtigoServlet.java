import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Control.Sistema;
import DataBase.Material;

public class ExcluirArtigoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		this.doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if(sistema == null) { //se não tem ninguem logado
			RequestDispatcher rdIndex = request.getRequestDispatcher("PaginaInicial");
			rdIndex.forward(request, response);
			return;
		}
		
		Material material = (Material)request.getSession().getAttribute("materialASerExcluido");
		System.out.println( sistema.cSubmissao.removerMaterial(material));
		
		RequestDispatcher rdIndex = request.getRequestDispatcher("listaArtigosSubmetidos.jsp");
		rdIndex.forward(request, response);
			
	}
	
}