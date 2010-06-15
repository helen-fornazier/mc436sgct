package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Control.Sistema;

public final class barraHorizontalAutor_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\t\r\n");
      out.write("\t<!-- end #logo -->\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"index.jsp\">Inicio</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"submissao.jsp\">Submissao</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"listaArtigosAvaliacao.jsp\">Avaliar</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end #menu -->\r\n");
      out.write("\t\t<div id=\"search\">\r\n");
      out.write("\t\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t");

					Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td><li><a href=\"LogoutServlet\">Logout</a></li></td>\r\n");
      out.write("\t\t\t\t\t<td><font size=\"2\">logado como ");
      out.print(sistema.cLogin.getUsuarioLogado().getLogin());
      out.write(" </font></td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end #search -->\r\n");
      out.write("\t</div>\r\n");
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
