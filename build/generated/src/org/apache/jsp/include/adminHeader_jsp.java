package org.apache.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminHeader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<style>\n");
      out.write("    @import url('https://fonts.googleapis.com/css?family=Oswald:400,700');\n");
      out.write("    @import url('https://fonts.googleapis.com/css?family=Montserrat:400,700');\n");
      out.write("    \n");
      out.write("    body\n");
      out.write("{\n");
      out.write("    background-repeat: no-repeat;\n");
      out.write("    background-size: cover;\n");
      out.write(" margin: 0;\n");
      out.write("}\n");
      out.write("header \n");
      out.write("{\n");
      out.write(" background: black;   \n");
      out.write(" color: white;\n");
      out.write(" padding: 8px 0px 6px 40px;\n");
      out.write(" height: 46px;\n");
      out.write("}\n");
      out.write("header h1\n");
      out.write("{\n");
      out.write("    display: inline;\n");
      out.write("    font-family: 'Oswald', sans-serif;\n");
      out.write("    font-weight: 400;\n");
      out.write("    font-size: 32px;\n");
      out.write("    float: left;\n");
      out.write("    margin-top: -5px;\n");
      out.write("    margin-right: 15px;\n");
      out.write("    margin-left: -20px;\n");
      out.write("}\n");
      out.write("nav ul\n");
      out.write("{\n");
      out.write("    display: inline;\n");
      out.write("    padding: 0px;\n");
      out.write("    float: left;\n");
      out.write("}\n");
      out.write("nav ul li\n");
      out.write("{\n");
      out.write("    display: inline-block;\n");
      out.write("    list-style-type: none;\n");
      out.write("    color: white;\n");
      out.write("    float: left;\n");
      out.write("    margin-left: 15px;\n");
      out.write("}\n");
      out.write("nav ul li a\n");
      out.write("{\n");
      out.write("    color:  white;\n");
      out.write("    text-decoration: none;\n");
      out.write("}\n");
      out.write("#nav\n");
      out.write("{\n");
      out.write("    font-family: 'Montserrat', sans-serif;\n");
      out.write("}\n");
      out.write(".homered:hover{\n");
      out.write("    background-color: red;\n");
      out.write("    padding: 24px 10px 20px 10px\n");
      out.write("}\n");
      out.write(".divider\n");
      out.write("{\n");
      out.write("    background-color: red;\n");
      out.write("    height: 5px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("    <header>\n");
      out.write("            <nav>\n");
      out.write("                <h1>SkiShop</h1>\n");
      out.write("                <ul id=\"nav\">\n");
      out.write("                    <li><a class=\"homered\" href=\"Admin.jsp\">Korisnici</a></li>\n");
      out.write("                    <li><a class=\"homered\" href=\"noviProizvod.jsp\">Ubaci novi proizvod</a></li>\n");
      out.write("                    <li><a class=\"homered\" href=\"updateProizvod.jsp\">Ažuriraj proizvod</a></li>\n");
      out.write("                    <li><a class=\"homered\" href=\"logoutServlet?action=logout\">Odjavi se</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("    </header>\n");
      out.write("    <div class=\"divider\"></div>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
