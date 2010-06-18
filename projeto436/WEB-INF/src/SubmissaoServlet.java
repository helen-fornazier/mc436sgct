import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Control.Sistema;
import DataBase.Material;

public class SubmissaoServlet extends HttpServlet {

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
		
		String autores = String.valueOf(request.getParameter("autores"));
		System.out.println("autores = "+autores);

		String titulo = String.valueOf(request.getParameter("titulo"));
		System.out.println("titulo = "+titulo);
		
		String resumo = String.valueOf(request.getParameter("resumo"));
		System.out.println("resumo = "+resumo);
		
		String arquivo = String.valueOf(request.getParameter("arquivo"));
		System.out.println("arquivo = "+resumo);
		
		Material material = sistema.cSubmissao.novoMaterial(autores, resumo, titulo, arquivo);
		
		sistema.cSubmissao.registrarMaterial(material);
		
		RequestDispatcher rdIndex = request.getRequestDispatcher("submissaoSucesso.jsp");
		rdIndex.forward(request, response);
			
	}
	
}