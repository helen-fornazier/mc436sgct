import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import Control.Sistema;


public class CarregaListaArtigos extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Verifica se é é um avaliador que entrou nesta página
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("avaliador") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("acessoNaoPermitido.jsp");
			rdIndex.forward(request, response);
			return;
		}
		
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
