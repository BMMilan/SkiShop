package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Korpa</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/cart.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("                <table border=\"2\">\n");
      out.write("                    <caption><div> <img src='slike/logo/Cart.jpg' alt=\"korpa\" />Korpa</div></caption>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Slika</th>\n");
      out.write("                        <th>Proizvođač</th>\n");
      out.write("                        <th>Model</th>\n");
      out.write("                        <th>Cena </th>\n");
      out.write("                        <th>Količina</th>\n");
      out.write("                        <th>Sum</th>\n");
      out.write("                        <th>Option</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr><td colspan=\"7\" align=\"center\">Korpa je trenutno prazna</td></tr>\n");
      out.write("                    <tr><td colspan=\"6\" align=\"right\">ukupno</td><td align=\"center\">.00</td></tr>\n");
      out.write("                </table>\n");
      out.write("                <div id=\"actions\">\n");
      out.write("                    <a href=\"Home.jsp\">Nazad na kupovinu</a>\n");
      out.write("                    <a href='orderServlet?action=buy&&suma=' onclick=\" return confirm('Posalji porudzbinu?')\">Pošalji porudžbinu</a>\n");
      out.write("                </div>\n");
      out.write("             \n");
      out.write("            <div id='deo2'>\n");
      out.write("                <div id='cart-img'>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div id='total'>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Vrednost porudžbine: </td>\n");
      out.write("                            <td>.00 RSD</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Za plaćanje:  </td>\n");
      out.write("                            <td>.00 RSD</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
