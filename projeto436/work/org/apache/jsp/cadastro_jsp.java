package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "logo.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "barraHorizontal.jsp", out, false);
      out.write("\r\n");
      out.write("  \r\n");
      out.write("<form action=\"CadastroServlet\" method=\"get\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- Um titulo centralizado na pagina-->\r\n");
      out.write("  \t<p align=\"center\"><font size=\"5\"><b>Cadastro de Usuario</b></font></p>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');
      out.write('	');

	String attributeError = (String)request.getSession().getAttribute("attributeError");
	
	if (attributeError != null) { 
		request.getSession().setAttribute("attributeError", null);
	
      out.write("\r\n");
      out.write("\t\t<font size=\"1\" color=\"red\">");
      out.print(attributeError);
      out.write("</font> <br>\t\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t  \r\n");
      out.write("\t<font size=\"1\">(Ítens obrigatórios marcados com *)</font>\r\n");
      out.write("\t\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Nome*:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"nomeUser\" size=\"50\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Idade*:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"idade\" size=\"10\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Sexo*:</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"sexo\" value=\"feminino\"> Feminino<br>\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"sexo\" value=\"masculino\"> Masculino<br>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>CPF*:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"cpf\" size=\"20\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Endereço:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"endereco\" size=\"50\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Contato:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"contato\" size=\"50\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Escolha seu tipo de usuário*:</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"tipo\" value=\"participante\"> Participante<br>\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"tipo\" value=\"autor\"> Autor<br>\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"tipo\" value=\"avaliador\"> Avaliador<br>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Login*:</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"login\" size=\"20\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Senha*:</td>\r\n");
      out.write("\t\t\t<td><input type=\"password\" name=\"senha1\" size=\"20\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Digite a senha novamente*:</td>\r\n");
      out.write("\t\t\t<td><input type=\"password\" name=\"senha2\" size=\"20\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Mande o seu currículo se você for um Autor ou Avaliador*:</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td><input type=\"file\" name=\"curriculo\" size=\"50\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Digite suas qualificações se você for um Avaliador:</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td><textarea name=\"qualificacoes\" rows=\"25\" cols=\"70\"></textarea></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<p align=\"center\">\r\n");
      out.write("\t<input type=\"submit\" name=\"botaoSubmissao\" value=\"Enviar\">\r\n");
      out.write("\t<input type=\"reset\" name=\"botaoLimpar\" value=\"Limpar\"> </p>\r\n");
      out.write("\t\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "barraLateral.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "rodape.jsp", out, false);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
