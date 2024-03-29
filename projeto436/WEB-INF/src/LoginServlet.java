import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Control.Sistema;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Inicializa o sistema
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if (sistema == null) {
			sistema = new Sistema();
			request.getSession().setAttribute("sistema", sistema);
		}
		
		String login = (String)request.getParameter("usuario");
		String senha = (String)request.getParameter("password");
		System.out.println(login);
		System.out.println(senha);

		if(sistema.cLogin.login(login, senha) != null) {
			RequestDispatcher rdIndex = request.getRequestDispatcher("PaginaInicial");
			rdIndex.forward(request, response);
		}
		else {
			request.getSession().setAttribute("sistema", null);
			RequestDispatcher rdIndex = request.getRequestDispatcher("loginErro.jsp");
			rdIndex.forward(request, response);
		}
	}
}
	