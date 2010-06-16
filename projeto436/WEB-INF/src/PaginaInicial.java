import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Control.Sistema;

public class PaginaInicial extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Le um atributo de session
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if (sistema == null) {
			RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
			rdIndex.forward(request, response);
			return;
		}
		
		String tipoUsuario = sistema.cLogin.getTipoUsuarioLogado();
		
		if(tipoUsuario == null){
			RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
			rdIndex.forward(request, response);
			return;
		}else if(tipoUsuario == "participante"){
			RequestDispatcher rdIndex = request.getRequestDispatcher("indexParticipante.jsp");
			rdIndex.forward(request, response);
			return;
		}else if(tipoUsuario == "autor"){
			RequestDispatcher rdIndex = request.getRequestDispatcher("indexAutor.jsp");
			rdIndex.forward(request, response);
			return;
		}else if(tipoUsuario == "avaliador"){
			RequestDispatcher rdIndex = request.getRequestDispatcher("indexAvaliador.jsp");
			rdIndex.forward(request, response);
			return;
		}
		
	}
}