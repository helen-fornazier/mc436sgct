

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Paulo 
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CadastroServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
	private String _getAttributeProblems(String cpf, String login, String senha1,
										String senha2, String tipo) {
		if (cpf == "")
			return "CPF EM BRANCO";
		else if (login == "")
			return "LOGIN EM BRANCO";
		else if (senha1 == "")
			return "SENHA EM BRANCO";
		else if (senha2 == "")
			return "POR FAVOR, DIGITE NOVAMENTE A SENHA";
		else if (senha1.compareTo(senha2) != 0) {
			return "SENHAS NÃO COMPATÍVEIS, POR FAVOR, DIGITE NOVAMENTE";
		}
		else if (tipo == null)
			return "VOCÊ DEVE ESCOLHER UM TIPO DE USUÁRIO";
		else
			return null;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ENTROU NO CADASTRO1");
		
		//Le um atributo de session
		String nome = request.getParameter("nomeUser");
		String cpf = request.getParameter("cpf");
		String idade = request.getParameter("idade");
		String sexo = request.getParameter("sexo");
		String endereco = request.getParameter("contato");
		String tipo = request.getParameter("tipo");
		String login = request.getParameter("login");
		String senha1 = request.getParameter("senha1");
		String senha2 = request.getParameter("senha2");
		
		String attributeError = _getAttributeProblems(cpf, login, senha1, senha2, tipo);
		if (attributeError != null) {
			request.getSession().setAttribute("attributeError", attributeError);
			
			//reenviando para a página de cadastro
			RequestDispatcher rdIndex = request.getRequestDispatcher("cadastro.jsp");
			rdIndex.forward(request, response);
			return;
		}

		request.getSession().setAttribute("attributeError", null);
		RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
		rdIndex.forward(request, response);
	}
}