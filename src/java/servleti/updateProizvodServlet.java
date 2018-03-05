package servleti;

import entity.Proizvod;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milan
 */
@WebServlet(name = "updateProizvodServlet", urlPatterns = {"/updateProizvodServlet"})
public class updateProizvodServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {  }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try 
        {
            String action = request.getParameter("action");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
            {
                Proizvod proizvod = dao.ProizvodDao.proizvodPoId(Integer.parseInt(request.getParameter("proizvodId"))); // metoda za uzimanje proizvoda na osnovu id-a
                switch(action)
                {
                    case "cena":
                    {
                        out.print("<table>");
                        out.print("<tr><td><p>Trenutna cena ovog proizvoda je <b>"+proizvod.getCena()+" RSD</b></p></td></tr>");
                        out.print("<tr><td><p>Ako želite da promenite cenu, unesite novu cenu u polje.</p></td></tr>");
                        out.print("<tr><td><input type='text' id='novaCenaPolje' placeholder='nova cena' /></td></tr>");
                        out.print("<tr><td><button value='updateCenu' onclick='actionCena(this.value)'  >Promeni cenu proizvoda </button></td></tr>");
                        out.print("</table>");
                        break;
                    }
                    case "dimenzije":
                    {
                        out.print("<table>");
                        out.print("<tr><td><p>Trenutne dimenzije ovog proizvoda su <b>"+proizvod.getVelicina()+"</b></p></td></tr>");
                        out.print("<tr><td><p>Ako želite da promenite podatke, unesite novu dimenziju u polje.</p></td></tr>");
                        out.print("<tr><td><input type='text' id='novaDimenzijaPolje' placeholder='nova dimenzija' /></td></tr>");
                        out.print("<tr><td><button value='updateDimenzije' onclick='actionDimenzija(this.value)' >Promeni dimenzije proizvoda </button></td></tr>");
                        out.print("</table>");
                        break;
                    }
                    case "naziv":
                    {
                        out.print("<table>");
                        out.print("<tr><td><p>Trenutna naziv ovog proizvoda je <b> "+proizvod.getNazivProizvoda()+"</b></p></td></tr>");
                        out.print("<tr><td><p>Ako želite da promenite naziv, unesite novi naziv u polje.</p></td></tr>");
                        out.print("<tr><td><input type='text' id='noviNazivPolje' placeholder='nova naziv' /></td></tr>");
                        out.print("<tr><td><button value='updateNaziv' onclick='actionNaziv(this.value)' >Promeni naziv proizvoda</button></td></tr>");
                        out.print("</table>");
                        break;
                    }
                    case "updateCenu": 
                    {
                        BigDecimal cena = new BigDecimal(request.getParameter("novaCena"));
                        dao.ProizvodDao.updateCenuProizvoda(Integer.parseInt(request.getParameter("proizvodId")), cena);
                        dao.ProizvodDao.closeSession();
                        out.print("<p> Ažurirana je cena "+proizvod.getNazivProizvoda()+" proizvoda. Nova cena iznosi "+cena+" RSD  <button onclick='reloadBar()'>Ok</button></p>");
                        break;
                    }
                    case "updateDimenzije":
                    {
                        dao.ProizvodDao.updateDimezijeProizvod(Integer.parseInt(request.getParameter("proizvodId")), request.getParameter("novaDimenzija"));
                        dao.ProizvodDao.closeSession();
                        out.print("<p> Ažurirana je dimenzija "+proizvod.getNazivProizvoda()+" proizvoda. Nova dimenzije proizvoda su "+request.getParameter("novaDimenzija")+".  <button onclick='reloadBar()'>Ok</button></p>");
                        break;
                    }
                    case "updateNaziv":
                    {
                        dao.ProizvodDao.updateNazivProizvod(Integer.parseInt(request.getParameter("proizvodId")), request.getParameter("noviNaziv"));
                        dao.ProizvodDao.closeSession();
                        out.print("<p> Ažuriran je naziv "+proizvod.getNazivProizvoda()+" proizvoda. Novi naziv proizvoda je "+request.getParameter("noviNaziv")+".  <button onclick='reloadBar()'>Ok</button></p>");
                        break;
                    }
                }
            }
        } 
        catch (Exception e)
        {
            System.out.println("UpdateProizvodServlet");
            System.out.println(e);
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