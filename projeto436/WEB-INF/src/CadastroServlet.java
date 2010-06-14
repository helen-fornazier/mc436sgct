

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Control.Sistema;
import DataBase.Usuario;
import DataBase.Autor;
import DataBase.Avaliador;

public class CadastroServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// same logic
		this.doGet(request, response);
	}
	
	private String _getAttributeProblems(String login, String senha1, String senha2, String nome, String cpf, 
			String endereco, String contato, String idade, String sexo, String tipo, String curriculo, String qualificacoes) {
		
		if (nome.compareTo("") == 0)
			return "NOME EM BRANCO";
		if (idade.compareTo("") == 0)
			return "IDADE EM BRANCO";
		if (sexo == null)
			return "SEXO EM BRANCO";
		if (cpf.compareTo("") == 0)
			return "CPF EM BRANCO";
		else if (login.compareTo("") == 0)
			return "LOGIN EM BRANCO";
		else if (senha1.compareTo("") == 0)
			return "SENHA EM BRANCO";
		else if (senha2.compareTo("") == 0)
			return "POR FAVOR, DIGITE NOVAMENTE A SENHA";
		else if (senha1.compareTo(senha2) != 0) {
			return "SENHAS N�O COMPAT�VEIS, POR FAVOR, DIGITE NOVAMENTE";
		}
		else if (tipo == null)
			return "VOC� DEVE ESCOLHER UM TIPO DE USU�RIO";
		else if ((tipo.compareTo("autor") == 0 || tipo.compareTo("avaliador") == 0) && curriculo.compareTo("") == 0)
			return "VOC� DEVE ADICIONAR SEU CURR�CULO";
		else if (tipo.compareTo("avaliador") == 0 && qualificacoes.compareTo("") == 0)
			return "VOCE ESCREVER SUAS QUALIFICA��ES";
		try {
			Integer.parseInt(idade);
		}
		catch (NumberFormatException e) {
			return "S� COLOQUE N�MEROS EM IDADE";
		}
		try {
			Integer.parseInt(cpf);
		}
		catch (NumberFormatException e) {
			return "S� COLOQUE N�MEROS EM CPF";
		}
		return null;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ENTROU NO CADASTRO");
		
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
		String curriculo = request.getParameter("curriculo");
		String qualificacoes = request.getParameter("qualificacoes");
		
		//FIXME: Ver como faz upload (como receber o material e armazenar em disco
		String attributeError = _getAttributeProblems(login, senha1, senha2, nome, cpf, endereco, contato,
														idade, sexo, tipo, curriculo, qualificacoes);
		request.getSession().setAttribute("attributeError", attributeError);

		if (attributeError != null) {		//Se dados n�o obrigat�rio n�o est�o l�, ou senhas diferentes:
			//reenviando para a p�gina de cadastro
			RequestDispatcher rdIndex = request.getRequestDispatcher("cadastro.jsp");
			rdIndex.forward(request, response);
			return;
		}

		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if(sistema == null) {
			sistema = new Sistema();
			request.getSession().setAttribute("sistema", sistema);
		}

		if (tipo.compareTo("participante") == 0) {
			Usuario usuario = sistema.cLogin.criaUsuario(login, senha1, nome, cpf, endereco, contato, idade, sexo); 
			if ( usuario != null) { //Se criou um usu�rio
				sistema.cLogin.login(login, senha1);
				RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
				rdIndex.forward(request, response);
				return;
			}
		}
		else if (tipo.compareTo("autor") == 0) {
			Autor autor = sistema.cLogin.criaAutor(login, senha1, nome, cpf, endereco, contato, idade, sexo, curriculo);
			if ( autor != null) { //Se criou um usu�rio
				sistema.cLogin.login(login, senha1);
				RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
				rdIndex.forward(request, response);
				return;
			}	
		}
		else if (tipo.compareTo("avaliador") == 0) {
			Avaliador avaliador = sistema.cLogin.criaAvaliador(login, senha1, nome, cpf, endereco, contato, idade, sexo,
															curriculo, qualificacoes); 
			if ( avaliador != null) { //Se criou um usu�rio
				sistema.cLogin.login(login, senha1);
				RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
				rdIndex.forward(request, response);
				return;
			}	
		}
		
		RequestDispatcher rdIndex = request.getRequestDispatcher("loginErro.jsp");
		rdIndex.forward(request, response);
	}
}