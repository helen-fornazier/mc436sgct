package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class listaArtigosAvaliacao_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t");

		ArrayList arrayAvaliar = new ArrayList();
		ArrayList arrayAvaliados = new ArrayList();
		
		arrayAvaliar = (ArrayList)request.getSession().getAttribute("arrayArtigosAvaliar");
		arrayAvaliados = (ArrayList)request.getSession().getAttribute("arrayArtigosAvaliados");
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\tEstes sao os artigos para a avaliacao: <br> <br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
 for(int i=0; i<arrayAvaliar.size(); i++){
      out.write("\r\n");
      out.write("\t\t\t<a href='AvaliaArtigo?artigo=");
      out.print(i);
      out.write("'>Artigo ");
      out.print(i);
      out.write(':');
      out.write(' ');
      out.print(arrayAvaliar.get(i));
      out.write("</a> <br> <br>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br> <br>\r\n");
      out.write("\t\t<br> <br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\tEstes sao os artigos que ja foram avaliados: <br> <br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
 for(int i=0; i<arrayAvaliados.size(); i++){
      out.write("\r\n");
      out.write("\t\t\t<a href='ConsultaArtigoAvaliado?artigo=");
      out.print(i);
      out.write("'>Artigo ");
      out.print(i);
      out.write(':');
      out.write(' ');
      out.print(arrayAvaliados.get(i));
      out.write(" </a><br> <br>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
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
