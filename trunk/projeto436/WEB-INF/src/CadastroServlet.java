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
	
	private String _getAttributeProblems(Sistema sistema, String login, String senha1, String senha2, String nome, String cpf, 
			String endereco, String contato, String idade, String sexo, String tipo, String curriculo, String qualificacoes) {
		
		if (nome.compareTo("") == 0)
			return "NOME EM BRANCO";
		if (idade.compareTo("") == 0)
			return "IDADE EM BRANCO";
		if (sexo == null)
			return "SEXO EM BRANCO";
		if (cpf.compareTo("") == 0)
			return "CPF EM BRANCO";
		if (login.compareTo("") == 0)
			return "LOGIN EM BRANCO";
		if (sistema.cLogin.getUsuario(login) != null)
			return "LOGIN JA FOI ESCOLHIDO";
		if (senha1.compareTo("") == 0)
			return "SENHA EM BRANCO";
		if (senha2.compareTo("") == 0)
			return "POR FAVOR, DIGITE NOVAMENTE A SENHA";
		if (senha1.compareTo(senha2) != 0) {
			return "SENHAS NÃO COMPATÍVEIS, POR FAVOR, DIGITE NOVAMENTE";
		}
		if (tipo == null)
			return "VOCÊ DEVE ESCOLHER UM TIPO DE USUÁRIO";
		if (curriculo == null)
			return "VOCÊ DEVE MANDAR UM CURRICULO";
		if ((tipo.compareTo("autor") == 0 || tipo.compareTo("avaliador") == 0) && curriculo.compareTo("") == 0)
			return "VOCÊ DEVE ADICIONAR SEU CURRÍCULO";
		if (tipo.compareTo("avaliador") == 0 && qualificacoes.compareTo("") == 0)
			return "VOCE ESCREVER SUAS QUALIFICAÇÕES";
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

		System.out.println("ENTROU NO CADASTRO");
		
		//Le um atributo de session
		String nome = (String)request.getParameter("nomeUser");
		String cpf = (String)request.getParameter("cpf");
		String idade = (String)request.getParameter("idade");
		String sexo = (String)request.getParameter("sexo");
		String endereco = (String)request.getParameter("endereco");
		String contato = (String)request.getParameter("contato");
		String tipo = (String)request.getParameter("tipo");
		String login = (String)request.getParameter("login");
		String senha1 = (String)request.getParameter("senha1");
		String senha2 = (String)request.getParameter("senha2");
		String curriculo = (String)request.getParameter("curriculo");
		String qualificacoes = (String)request.getParameter("qualificacoes");
		
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if(sistema == null) {
			sistema = new Sistema();
			request.getSession().setAttribute("sistema", sistema);
		}
		
		//FIXME: Ver como faz upload (como receber o material e armazenar em disco
		String attributeError = _getAttributeProblems(sistema,login, senha1, senha2, nome, cpf, endereco, contato,
														idade, sexo, tipo, curriculo, qualificacoes);
		request.getSession().setAttribute("attributeError", attributeError);

		if (attributeError != null) {		//Se dados não obrigatório não estão lá, ou senhas diferentes:
			//reenviando para a página de cadastro
			RequestDispatcher rdIndex = request.getRequestDispatcher("cadastro.jsp");
			rdIndex.forward(request, response);
			return;
		}

		if (tipo.compareTo("participante") == 0) {
			Usuario usuario = sistema.cLogin.criaUsuario(login, senha1, nome, cpf, endereco, contato, idade, sexo); 
			if ( usuario != null) { //Se criou um usuário
				RequestDispatcher rdIndex = request.getRequestDispatcher("LoginServlet?usuario="+login+"&password="+senha1+"");
				rdIndex.forward(request, response);
				return;
			}
		}
		else if (tipo.compareTo("autor") == 0) {
			Autor autor = sistema.cLogin.criaAutor(login, senha1, nome, cpf, endereco, contato, idade, sexo, curriculo);
			if ( autor != null) { //Se criou um usuário
				RequestDispatcher rdIndex = request.getRequestDispatcher("LoginServlet?usuario="+login+"&password="+senha1+"");
				rdIndex.forward(request, response);
				return;
			}
		}
		else if (tipo.compareTo("avaliador") == 0) {
			Avaliador avaliador = sistema.cLogin.criaAvaliador(login, senha1, nome, cpf, endereco, contato, idade, sexo,
															curriculo, qualificacoes); 
			if ( avaliador != null) { //Se criou um usuário
				RequestDispatcher rdIndex = request.getRequestDispatcher("LoginServlet?usuario="+login+"&password="+senha1+"");
				rdIndex.forward(request, response);
				return;
			}
		}
		
		RequestDispatcher rdIndex = request.getRequestDispatcher("loginErro.jsp");
		rdIndex.forward(request, response);
	}
}