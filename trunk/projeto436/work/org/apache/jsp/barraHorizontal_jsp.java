package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Control.Sistema;

public final class barraHorizontal_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<!-- end #logo -->\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t<div id=\"menu\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"CarregaInicio\">Inicio</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- end #menu -->\r\n");
      out.write("\t<div id=\"search\">\r\n");
      out.write("\t\t");

		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema"); 
		if (sistema == null || sistema.cLogin.getUsuarioLogado() == null) {
		
      out.write("\r\n");
      out.write("\t\t\t<form action=\"EfetuaLogin\" method=\"get\">\t\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><font size=\"2\">usuario</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"usuario\" size=\"11\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td><font size=\"2\">senha</font></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"password\" name=\"password\" size=\"11\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"submit\" value=\"      Entrar      \" name=\"botaoLogin\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\t\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td><a href=\"cadastro.jsp\"<font color=\"white\" size=\"2\">     Cadastrar    </font></td></a>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t");

		}
		else {
		
      out.write("\r\n");
      out.write("\t\t\t<form action=\"EfetuaLogout\" method=\"get\">\t\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><font size=\"2\">logado como ");
      out.print(sistema.cLogin.getUsuarioLogado().getLogin());
      out.write(" </font></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"submit\" value=\"      Sair      \" name=\"botaoLogout\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t");
 } 
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- end #search -->\r\n");
      out.write("</div>\r\n");
      out.write("\t<!-- end #header -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- end #header-wrapper -->\r\n");
      out.write("<div id=\"page\">\r\n");
      out.write("\t<div id=\"content\">");
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
