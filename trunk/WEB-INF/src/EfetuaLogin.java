

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
public class EfetuaLogin extends HttpServlet {

	String loginUsuario = "mc436";
	String senhaUsuario = "mc436";

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
		
		if(!usuario.isEmpty()){
			request.getSession().setAttribute("usuarioLogado",""); //desloga
			RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");
			rdIndex.forward(request, response);
			return;
		}
		
		
	
		//Le o parametro "usuario" do formulario HTML que executou o submit
		String usuariotx = String.valueOf(request.getParameter("usuario"));
		
		//Le o parametro "senha" do formulario HTML que executou o submit
		String senhatx = String.valueOf(request.getParameter("password"));
		
		System.out.println("Usuario tentando se logar ="+usuariotx+" com senha="+senhatx);
		
		 //Confere o Login
		 boolean erro= this.confereErroLogin(usuariotx, senhatx); 

		
			if(erro){
				System.out.println("Senha ou Usuario errado. Indo pra tela de requerimentoLogin");
				
				//Atributo de sessao "erroLogin"  = 1; (poderemos utilizar esse valor em uma interface .jsp)
				request.getSession().setAttribute("erroLogin", 1);
				
				//Envio do usuario para a tela de "Login incorreto"  
				RequestDispatcher rdIndex = request.getRequestDispatcher("loginErro.jsp");
				rdIndex.forward(request, response);
				
			}else{
				System.out.println("Senha e usuario corretos. Indo a tela de Login correto");
				
				//Atributo de sessao "UsuarioLogado" com o valor do usuario logado!
				//(poderemos utilizar esse valor em uma interface .jsp para, por exemplo, mostrar na tela o 
				//usuario logado).
				request.getSession().setAttribute("usuarioLogado",usuariotx );
				
				//Enviar o usuario para a tela de login correto.
				RequestDispatcher rdIndex = request.getRequestDispatcher("index_autor.jsp");
				rdIndex.forward(request, response);
			}
			
	}

	
	public boolean confereErroLogin(String usuario, String senha){
		
		if((usuario.equals(loginUsuario)) && (senha.equals(senhaUsuario))){
			return false;
		}else return true;
		
	}
}