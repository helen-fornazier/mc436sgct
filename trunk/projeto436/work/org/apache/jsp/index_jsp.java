package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Control.Sistema;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "logo.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
 
Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
if (sistema == null) {
 
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "barraHorizontal.jsp", out, false);
      out.write('\r');
      out.write('\n');
  
}
else {

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "barraHorizontalAutor.jsp", out, false);
      out.write('\r');
      out.write('\n');
  
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t     \r\n");
      out.write("      <!--TEXTO DA PAGINA-->       \r\n");
      out.write("          <span style=\"font-size: 8,5pt\">O Sistema de Gerenciamento de Conferencias Tecnologicas (SGCT) proposto e\r\n");
      out.write("\t\t\tuma colecao de sistemas e utilitirios usados para anunciar, preparar e apoiar\r\n");
      out.write("\t\t\tuma conferencia tecnologica.\r\n");
      out.write("   \t\t  </span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<p>&nbsp;</p>\r\n");
      out.write("\t\t\r\n");
      out.write("          <span style=\"font-size: 8,5pt\">Para realizar a inscricao na <b>Conferencia MC436 2010</b>, acesse sua\r\n");
      out.write("          <a href=\"areaReservada.jsp\">Area reservada</a>\r\n");
      out.write("          </span>\r\n");
      out.write("    \t\r\n");
      out.write("    \t</center>\r\n");
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
