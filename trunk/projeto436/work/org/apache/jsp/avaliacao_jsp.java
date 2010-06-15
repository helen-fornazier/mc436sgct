package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Control.Sistema;
import DataBase.Material;
import java.util.ArrayList;

public final class avaliacao_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
//Verifica se é é um autor que entrou nesta página
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("avaliador") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("acessoNaoPermitido.jsp");
			rdIndex.forward(request, response);
			return;
		}
 
      out.write("\r\n");
      out.write("<!-- Tag de abertura do Form com metodo GET chamando o futuro Servlet AvaliacaoServlet -->\r\n");
      out.write("<form action=\"AvaliacaoServlet\" method=\"GET\">\r\n");
      out.write("\r\n");
      out.write("<!-- Um titulo centralizado na pagina-->\r\n");
      out.write("  <p align=\"center\"><b><font size=\"5\">Avaliacao de Artigos</font></b></p>\r\n");
      out.write("  \r\n");
      out.write("<table>\r\n");
      out.write("\r\n");
      out.write("\r\n");

ArrayList<Material> materiaisAvaliar = sistema.cAvaliacao.getListaMateriaisAvaliar();
		if (materiaisAvaliar == null)
			materiaisAvaliar = new ArrayList<Material>();
int index = Integer.parseInt(request.getParameter("artigo"));
Material material = materiaisAvaliar.get(index);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Titulo do artigo:</td>\r\n");
      out.write("<td>");
      out.print(material.getTitulo() );
      out.write("</td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Download do artigo</td>\r\n");
      out.write("<td><a href=\"../pdfs/algoritmos-adianta-slides.pdf\" name=\"Artigo\">Artigo para download</a></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Comentarios:</td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><textarea name=\"comentarios\" rows=\"10\" cols=\"50\"></textarea></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Notas</td>\r\n");
      out.write("\r\n");
      out.write("<td>0<input type=\"radio\" name=\"nota\" value=\"0\"></td>\r\n");
      out.write("<td>1<input type=\"radio\" name=\"nota\" value=\"1\"></td>\r\n");
      out.write("<td>2<input type=\"radio\" name=\"nota\" value=\"2\"></td>\r\n");
      out.write("<td>3<input type=\"radio\" name=\"nota\" value=\"3\"></td>\r\n");
      out.write("<td>4<input type=\"radio\" name=\"nota\" value=\"4\"></td>\r\n");
      out.write("<td>5<input type=\"radio\" name=\"nota\" value=\"5\"></td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<input type=\"submit\" name=\"submitAval\" value=\"Enviar\">\r\n");
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
