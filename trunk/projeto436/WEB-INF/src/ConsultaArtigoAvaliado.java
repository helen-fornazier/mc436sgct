import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import Control.Sistema;


public class ConsultaArtigoAvaliado extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if(sistema == null) { //se não tem ninguem logado
			RequestDispatcher rdIndex = request.getRequestDispatcher("PaginaInicial");
			rdIndex.forward(request, response);
			return;
		}

		ArrayList<String> artigosAvaliados = new ArrayList<String>();
		artigosAvaliados.add("Avaliado 1");
		artigosAvaliados.add("Avaliado 2");
		artigosAvaliados.add("Avaliado 3");
			
		
		int numeroArtigo = Integer.parseInt(request.getParameter("artigo"));
		System.out.println("O artigo que o avaliador quer ver é o numero "+numeroArtigo);
		System.out.println("O artigo que o avaliador quer ver tem o titulo: "+artigosAvaliados.get(numeroArtigo));
		
		
		//Envia como variavel de sessao o titulo e o resumo do trabalho
		request.getSession().setAttribute("titulo", artigosAvaliados.get(numeroArtigo));
		request.getSession().setAttribute("resumo", artigosAvaliados.get(numeroArtigo));
		request.getSession().setAttribute("numero", numeroArtigo);
		
		

		RequestDispatcher rdIndex = request.getRequestDispatcher("consultaAvaliacao.jsp");
		rdIndex.forward(request, response);	
		
			
	}	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
}
