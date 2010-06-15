package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBase.Material;
import Control.Sistema;
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
 
//Verifica se é é um autor que entrou nesta página
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("avaliador") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("acessoNaoPermitido.jsp");
			rdIndex.forward(request, response);
			return;
		}
 
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t");

		
		ArrayList<Material> materiaisAvaliar = sistema.cAvaliacao.getListaMateriaisAvaliar();
		if (materiaisAvaliar == null)
			materiaisAvaliar = new ArrayList<Material>();
		ArrayList<Material> materiaisAvaliados =  sistema.cAvaliacao.getListaMateriaisAvaliados();
		if (materiaisAvaliados == null)
			materiaisAvaliados = new ArrayList<Material>();
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\tEstes sao os artigos para a avaliacao: <br> <br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
 for(int i=0; i<materiaisAvaliar.size(); i++){
      out.write("\r\n");
      out.write("\t\t\t<a href='avaliacao.jsp?artigo=");
      out.print(i);
      out.write("'>Artigo ");
      out.print(i);
      out.write(':');
      out.write(' ');
      out.print(materiaisAvaliar.get(i).getTitulo());
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
 for(int i=0; i<materiaisAvaliados.size(); i++){
      out.write("\r\n");
      out.write("\t\t\t<a href='ConsultaArtigoAvaliado?artigo=");
      out.print(i);
      out.write("'>Artigo ");
      out.print(i);
      out.write(':');
      out.write(' ');
      out.print(materiaisAvaliados.get(i));
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
