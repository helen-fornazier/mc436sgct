package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class barraLateral_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\t</div>\r\n");
      out.write("\t<!-- end #content -->\r\n");
      out.write("\t<div id=\"sidebar\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<h2>Aliquam tempus</h2>\r\n");
      out.write("\t\t\t\t<p>Mauris vitae nisl nec metus placerat perdiet est. Phasellus dapibus semper urna. Pellentesque ornare, orci in consectetuer hendrerit, volutpat.</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<h2>Turpis nulla</h2>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\"></a><a href=\"#\">Nec metus sed donec</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Magna lacus bibendum mauris</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Velit semper nisi molestie</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Eget tempor eget nonummy</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Nec metus sed donec</a></li>\r\n");
      out.write("\t\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- end #sidebar -->");
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
