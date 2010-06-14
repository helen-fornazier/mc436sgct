import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarregaInicio extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Le um atributo de session
		String usuario = request.getSession().getAttribute("usuarioLogado")+"";
		System.out.println("usuario que estava logado  = "+usuario);
		
			if(usuario.equals("mc436")){
				System.out.println("Usuario ja esta logado");

				//Envio do usuario para a tela de "Login incorreto"  
				RequestDispatcher rdIndex = request.getRequestDispatcher("index_autor.jsp");
				rdIndex.forward(request, response);
				
			}else{
				System.out.println("Usuario nao esta logado");

				//Enviar o usuario para a tela de login correto.
				RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
				rdIndex.forward(request, response);
			}
			
	}
}