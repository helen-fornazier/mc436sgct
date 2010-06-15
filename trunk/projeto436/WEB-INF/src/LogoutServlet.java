

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Control.Sistema;

public class LogoutServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.getSession().setAttribute("sistema", null);
		/*//Inicializa o sistema
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if (sistema == null) {
			sistema = new Sistema();
			request.getSession().setAttribute("sistema", sistema);
		}

		sistema.cLogin.logout();
		*/
		RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
		rdIndex.forward(request, response);
		
	}
}
	