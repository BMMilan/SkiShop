package servleti;

import entity.Korisnik;
import entity.Porudzbina;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Milan
 */
@WebServlet(name = "ProfilServlet", urlPatterns = {"/ProfilServlet"})
public class ProfilServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try
        {
            HttpSession sesija = request.getSession(true);
            if(sesija.getAttribute("korisnik")!=null) // proverava da li je istekla sesija
            {
                Korisnik kor = (Korisnik)sesija.getAttribute("korisnik"); // uzima logovanog korisnika iz sesije
                String value = request.getParameter("value").trim(); // value
                if(value.equalsIgnoreCase("profil")) // prikazivanje osnovnih podataka korisnika
                {
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.print("<table>");
                        out.print("<tr><td>Ime: "+kor.getIme()+"</td></tr>");
                        out.print("<tr><td>Prezime: "+kor.getPrezime()+"</td></tr>");
                        out.print("<tr><td>Korisničko ime: "+kor.getEmail()+"</td></tr>");
                        out.print("<tr><td>Adresa: "+kor.getAdresa()+", Grad: "+kor.getGrad()+"</td></tr>");
                        out.print("</table>");

                    }
                }
                if(value.equalsIgnoreCase("porudzbina")) // prikazivanje svih porudzbina korisnika
                {
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) 
                    {
                        if(kor.getPorudzbinas().isEmpty())
                        {
                            out.print("Trenutno nemate porudžbina.");
                        }
                        else 
                        {
                           out.print("<table>");
                           for(Porudzbina por:kor.getPorudzbinas())
                           {
                              out.print("<tr><td>Porudžbina: "+por.getPorudzbinaId()+"</td><td><a href='prikazPorudzbine?idporudzine="+por.getPorudzbinaId()+"'>Detalji>>></a></td></tr>"); 
                           }
                           out.print("<table>");

                        }
                    }
                }
                if(value.equalsIgnoreCase("podaci"))  // omoucavanje promene podataka korisnika
                {
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter())
                    {
                            out.print("<table>");
                            out.print("<tr><td>Ime: </td><td><input type='text' id='azur-ime' value='"+kor.getIme()+"' required /></tr></td>");
                            out.print("<tr><td>Prezime:</td><td> <input type='text' id='azur-prezime' value='"+kor.getPrezime()+"' required /></tr></td>");
                            out.print("<tr><td>e-Mail: </td><td><input type='text' id='azur-email' value='"+kor.getEmail()+"' required /></tr></td>");
                            out.print("<tr><td>Adresa: </td><td> <input type='text' id='azur-adr' value='"+kor.getAdresa()+"' required /></tr></td>");
                            out.print("<tr><td>Grad: </td><td> <input type='text' id='azur-grd' value='"+kor.getGrad()+"' required /></tr></td>");
                            out.print("<tr><td><input type='submit' value='Ažuriraj podatke' onclick='refresh()'/></tr></td>");
                            out.print("</table>");

                    }
                  }
                if(value.equalsIgnoreCase("lozinka")) // omogucava promenu sifre korisniku
                {
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter())
                    {
                        out.print("<table>");
                        out.print("<tr><td>Ukucaj novu šifru:</td><td> <input type='password' id='azur-pass1' required /></tr></td>");
                        out.print("<tr><td></td></tr>");
                        out.print("<tr><td>Ponovi novu šifru:</td><td> <input type='password' id='azur-pass2' required /></tr></td>");
                        out.print("<tr><td></td></tr>");
                        out.print("<tr><td><input type='submit' value='Ažuriraj šifru' onclick='refreshPassword()'/></tr></td>");
                        out.print("</table>");
                    }
                } 
            }
            else // ukoliko je sesija istekla, umerava vas na prijavu 
            {
                response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.print("Istekla vam se sesija. Ulogujte se ponovo. <a href='Logovanje.jsp'>Log here</a>");
                    }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Profil Servlet");
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
