

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Control.Sistema;
import DataBase.Usuario;

public class CadastroServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
	private String _getAttributeProblems(String nome, String idade, String sexo, String cpf, String login,
										String senha1, String senha2, String tipo) {
		if (nome == "")
			return "NOME EM BRANCO";
		if (idade == "")
			return "IDADE EM BRANCO";
		if (sexo == null)
			return "SEXO EM BRANCO";
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
		
		try {
			Integer.parseInt(idade);
		}
		catch (NumberFormatException e) {
			return "SÓ COLOQUE NÚMEROS EM IDADE";
		}
		try {
			Integer.parseInt(cpf);
		}
		catch (NumberFormatException e) {
			return "SÓ COLOQUE NÚMEROS EM CPF";
		}
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
		String endereco = request.getParameter("endereco");
		String contato = request.getParameter("contato");
		String tipo = request.getParameter("tipo");
		String login = request.getParameter("login");
		String senha1 = request.getParameter("senha1");
		String senha2 = request.getParameter("senha2");
		
		String attributeError = _getAttributeProblems(nome, idade, sexo, cpf, login, senha1, senha2, tipo);
		request.getSession().setAttribute("attributeError", attributeError);

		if (attributeError != null) {		//Se dados não obrigatório não estão lá, ou senhas diferentes:
			//reenviando para a página de cadastro
			RequestDispatcher rdIndex = request.getRequestDispatcher("cadastro.jsp");
			rdIndex.forward(request, response);
			return;
		}

		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if(sistema == null) {
			sistema = new Sistema();
			request.getSession().setAttribute("sistema", sistema);
		}
		
		Usuario usuario = sistema.cLogin.criaUsuario(login, senha1, nome, cpf, endereco, contato, idade, sexo); 
		if ( usuario != null) { //Se criou um usuário
			request.getSession().setAttribute("usuario", usuario);
			RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
			rdIndex.forward(request, response);
		}
		else {
			RequestDispatcher rdIndex = request.getRequestDispatcher("loginErro.jsp");
			rdIndex.forward(request, response);
		}
	}
}