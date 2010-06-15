

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Control.Sistema;

public class AvaliacaoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		this.doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rdIndex = request.getRequestDispatcher("listaArtigosAvaliacao.jsp");
		rdIndex.forward(request, response);
	}	
}
