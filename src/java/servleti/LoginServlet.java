/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import dao.KorisnikDao;
import dao.PravoDao;
import entity.Korisnik;
import entity.Prava;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("akcije"));
        HttpSession sesija = request.getSession(true);
        RequestDispatcher rd = null;
        String akcija = request.getParameter("akcije");
        if(akcija.equalsIgnoreCase("logovanje"))
        {
                if(KorisnikDao.sviKorisnici(request.getParameter("username"))!= null)
                {
                    Korisnik korisnik = dao.KorisnikDao.logovanKorisnik(request.getParameter("username").trim());
                    dao.KorisnikDao.closeSession();
                    if(korisnik.getSifra().equals(request.getParameter("password")))
                     {
                         if(korisnik.getPrava().getPravaId() == 1){ 
                            rd = request.getRequestDispatcher("Admin.jsp");
                         }
                         else if(korisnik.getPrava().getPravaId() == 2){ 
                            rd = request.getRequestDispatcher("Profil.jsp");
                         }
                        sesija.setAttribute("korisnik", korisnik);
                        sesija.setAttribute("statusKorisnika", "log");
                     }
                    else
                    {
                            rd = request.getRequestDispatcher("Logovanje.jsp");
                    }
                }
                else {
                     rd = request.getRequestDispatcher("Logovanje.jsp");
                }
                rd.forward(request, response);
        }
        else if(akcija.equalsIgnoreCase("registracija"))
        {
            Prava p = PravoDao.vratiPravoPoId(2);
            Korisnik korisnik = new Korisnik(p, request.getParameter("inp-ime"), request.getParameter("inp-prezime"), request.getParameter("inp-email"), request.getParameter("inp-un-pass1"), request.getParameter("inp-adresa"), request.getParameter("inp-grad"));
            KorisnikDao.ubaciKorisnika(korisnik);
            rd = request.getRequestDispatcher("Proizvodi.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
