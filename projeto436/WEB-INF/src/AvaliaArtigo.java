import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;


public class AvaliaArtigo extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList artigosAvaliar = new ArrayList();
		artigosAvaliar.add("Como fazer um jsp receber dados de um servlet!");
		artigosAvaliar.add("Como atribuir variaveis de sessao");
		artigosAvaliar.add("Como enviar um atributo por sessao para uma pagina jsp");
			
		
		int numeroArtigo = Integer.parseInt(request.getParameter("artigo"));
		System.out.println("O artigo que o avaliador quer avaliar é o numero "+numeroArtigo);
		System.out.println("O artigo que o avaliador quer avaliar tem o titulo: "+artigosAvaliar.get(numeroArtigo));
		
		
		//Envia como variavel de sessao o titulo e o resumo do trabalho
		request.getSession().setAttribute("titulo", artigosAvaliar.get(numeroArtigo));
		request.getSession().setAttribute("resumo", artigosAvaliar.get(numeroArtigo));
		request.getSession().setAttribute("numero", numeroArtigo);
		
		

		RequestDispatcher rdIndex = request.getRequestDispatcher("avaliacao.jsp");
		rdIndex.forward(request, response);	
		
			
	}	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
}
