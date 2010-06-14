package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Control.Sistema;

public final class submissao_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "barraHorizontalAutor.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
 
//Verifica se é é um autor que entrou nesta página
		System.out.println("ENTROUOUOUOUOUO");
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("autor") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("acessoNaoPermitido.jsp");
			rdIndex.forward(request, response);
			return;
		}
 
      out.write("\r\n");
      out.write("<form action=\"SubmissaoServ\" method=\"get\">\r\n");
      out.write("\r\n");
      out.write("<!-- Um titulo centralizado na pagina-->\r\n");
      out.write("  <p align=\"center\"><font size=\"5\"><b>Submissao de artigo</b></font></p>\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Nome do autor 1:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"autor1\" size=\"50\"></td>\r\n");
      out.write("<tr>\r\n");
      out.write("</tr>\r\n");
      out.write("<td>Instituicao:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"inst1\" size=\"20\"></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Nome do autor 2:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"autor2\" size=\"50\"></td>\r\n");
      out.write("<tr>\r\n");
      out.write("</tr>\r\n");
      out.write("<td>Instituicao:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"inst2\" size=\"20\"></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Nome do autor 3:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"autor3\" size=\"50\"></td>\r\n");
      out.write("<tr>\r\n");
      out.write("</tr>\r\n");
      out.write("<td>Instituicao:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"inst3\" size=\"20\"></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Titulo artigo</td>\r\n");
      out.write("<td><input type=\"text\" name=\"titulo\" size=\"20\"></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td valign=\"top\">Resumo:</td>\r\n");
      out.write("<td><textarea name=\"resumo\" rows=\"10\" cols=\"40\"></textarea></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table width=\"433\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=\"129\">Areas:</td>\r\n");
      out.write("<td width=\"170\"><input type=\"checkbox\" name=\"ES\" value=\"ES\">Engenharia de software</td>\r\n");
      out.write("<td width=\"38\"><input type=\"checkbox\" name=\"IA\" value=\"IA\">IA</td>\r\n");
      out.write("<td width=\"58\"><input type=\"checkbox\" name=\"Redes\" value=\"Redes\">Redes</td>\r\n");
      out.write("<td width=\"6\"></td>\r\n");
      out.write("<td width=\"6\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Arquivo para upload:</td>\r\n");
      out.write("<td><input type=\"file\" name=\"arquivo\" size=\"50\"></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<p align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<input type=\"submit\" name=\"botaoSubmissao\" value=\"Enviar\">\r\n");
      out.write("<input type=\"reset\" name=\"botaoLimpar\" value=\"Limpar\"> </p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
