
package servleti;

import dao.ProizvodDao;
import entity.Proizvod;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milan
 */
@WebServlet(name = "PrikazProizvodaAjax", urlPatterns = {"/PrikazProizvodaAjax"})
public class PrikazProizvodaAjax extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Proizvod pr = ProizvodDao.proizvodPoId(Integer.parseInt(request.getParameter("vrednost")));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        out.print("<div id='image-div'>");
        out.print("<img src='slike/"+pr.getReferencuSlike()+"' weight='350px' height='350px'/>");     
        out.print("<p>"+pr.getBrend().getNaziv()+" "+pr.getNazivProizvoda()+"</p>");
        out.print("<p> Cena: "+pr.getCena()+" RSD</p>");
        out.print("<a href='CartServlet?action=order&&id="+pr.getProizvodId()+"'><input type='button' value='Ubaci u korpu' /></a>");
        out.print("</div>");
  
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
