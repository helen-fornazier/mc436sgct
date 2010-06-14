import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;


public class CarregaListaArtigos extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				ArrayList artigosAvaliar = new ArrayList();
				artigosAvaliar.add("Como fazer um jsp receber dados de um servlet!");
				artigosAvaliar.add("Como atribuir variaveis de sessao");
				artigosAvaliar.add("Como enviar um atributo por sessao para uma pagina jsp");
		
				request.getSession().setAttribute("arrayArtigosAvaliar", artigosAvaliar);
				
				ArrayList artigosAvaliados = new ArrayList();
				artigosAvaliados.add("Avaliado 1");
				artigosAvaliados.add("Avaliado 2");
				artigosAvaliados.add("Avaliado 3");
		
				request.getSession().setAttribute("arrayArtigosAvaliados", artigosAvaliados);
				
				

				RequestDispatcher rdIndex = request.getRequestDispatcher("listaArtigosAvaliacao.jsp");
				rdIndex.forward(request, response);	
	}	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
}
