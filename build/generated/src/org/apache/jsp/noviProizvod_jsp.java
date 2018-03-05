package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.KategorijeDao;
import entity.*;
import java.util.List;
import dao.ProizvodDao;
import entity.Proizvod;

public final class noviProizvod_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
 
    List<Brend> sviBrendoviList = ProizvodDao.sviBrendovi();
    List<Kategorija> sveKategorijeList = KategorijeDao.sveKategorije();
    ProizvodDao.closeSession();
    
    

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Novi Proizvod</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Css/noviProizvod.css\" />\n");
      out.write("        <script src=\"JavaScript/noviProizvod.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/adminHeader.jsp", out, false);
      out.write("\n");
      out.write("         <div class=\"content\">\n");
      out.write("            <div id=\"actionInfo\">\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("             <form method=\"POST\" action=\"NoviProizvodServlet\" enctype=\"multipart/form-data\" onsubmit=\"return insertNewProizvod();\"  >\n");
      out.write("             <table>\n");
      out.write("                 <caption>Ubaci novi Proizvod</caption>\n");
      out.write("                 <tr>\n");
      out.write("                    <td>\n");
      out.write("                         Proizvođač:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                    <select id=\"ProBrend\" name=\"ProBrend\" >\n");
      out.write("                        <option value=\"none\">[---izaberi brend---]</option>\n");
      out.write("                        ");
 for(Brend br:sviBrendoviList) { 
      out.write("\n");
      out.write("                        <option value=");
      out.print(br.getBrendId() );
      out.write('>');
      out.print( br.getNaziv() );
      out.write("</option>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                         Unesi Naziv: \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                         <input type=\"text\" id=\"ProNaziv\" name=\"ProNaziv\" width=\"100\" required />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Mreže:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                    <select id=\"ProKategorija\" name=\"ProKategorija\" >\n");
      out.write("                        <option value=\"none\" >[---izaberi kategoriju---]</option>\n");
      out.write("                        ");
 for(Kategorija k:sveKategorijeList) { 
      out.write("\n");
      out.write("                        <option value=");
      out.print( k.getKategorijaId() );
      out.write('>');
      out.print( k.getKategorija() );
      out.write("</option>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        Dostupne veličine: \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"ProVelicine\" id=\"ProVelicine\" width=\"100\" required placeholder=\"163cm,46,75cmx40cm\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Opis: \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"ProOpis\" id=\"ProOpis\" width=\"100\" required placeholder=\"Unesite opis\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Slika proizvoda: \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"file\" name=\"ProUpload\" id=\"ProUpload\" size=\"100\" required />\n");
      out.write("                    </td> \n");
      out.write("                     <td>Cena proizvoda: </td>\n");
      out.write("                     <td><input type=\"text\" name=\"ProCena\" id=\"ProCena\" required /> </td>\n");
      out.write("                 </tr>\n");
      out.write("                 <tr>\n");
      out.write("                     <td colspan=\"4\" align=\"center\" ><input type=\"submit\" value=\"Ubaci proizvod\" /> </td>\n");
      out.write("                 </tr>\n");
      out.write("            </table>\n");
      out.write("            </form> \n");
      out.write("            \n");
      out.write("         </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
