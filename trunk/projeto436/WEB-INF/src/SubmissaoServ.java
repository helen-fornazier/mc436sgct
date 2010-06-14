

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Control.Sistema;


/**
 * @author Paulo 
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SubmissaoServ extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		this.doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ENTROU NA SUBMISSAO!!!!!!");
		//Verifica se � � um autor que entrou nesta p�gina
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		System.out.println(sistema.cLogin.getTipoUsuarioLogado());
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("autor") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("acessoNaoPermitido.jsp");
			rdIndex.forward(request, response);
			return;
		}
		
		
		String autor1 = String.valueOf(request.getParameter("autor1"));
		System.out.println("autor 1 = "+autor1);
		String inst1 = String.valueOf(request.getParameter("inst1"));
		System.out.println("instituto 1 = "+inst1);
		
		String autor2 = String.valueOf(request.getParameter("autor2"));
		System.out.println("autor 2 = "+autor2);
		String inst2 = String.valueOf(request.getParameter("inst2"));
		System.out.println("instituto 2 = "+inst2);
		
		String autor3 = String.valueOf(request.getParameter("autor3"));
		System.out.println("autor 3 = "+autor3);
		String inst3 = String.valueOf(request.getParameter("inst3"));
		System.out.println("instituto 3 = "+inst3);
		
		String titulo = String.valueOf(request.getParameter("titulo"));
		System.out.println("titulo = "+titulo);
		
		String resumo = String.valueOf(request.getParameter("resumo"));
		System.out.println("resumo = "+resumo);
		
		String ES = String.valueOf(request.getParameter("ES"));
		System.out.println("ES = "+ES);
		String IA = String.valueOf(request.getParameter("IA"));
		System.out.println("IA = "+IA);
		String Redes = String.valueOf(request.getParameter("Redes"));
		System.out.println("Redes = "+Redes);
		
		RequestDispatcher rdIndex = request.getRequestDispatcher("submissaoSucesso.jsp");
		rdIndex.forward(request, response);
			
	}
	
}