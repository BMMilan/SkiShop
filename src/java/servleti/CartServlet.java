package servleti;

import entity.Korisnik;
import entity.Porudzbina;
import entity.Proizvod;
import entity.Stavka;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {
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
            
            String action = request.getParameter("action");
            HttpSession session = request.getSession(true);
            List<Stavka> stavkas = new ArrayList();
            System.out.println("Usao!!!!");
            if(action.equals("order")) // Ubacivanje modela u potrosacku korpu
            {
                if(session.getAttribute("cart")==null) // proverava se postojanje liste u sesiji
                {
                    System.out.println("Prvi iF!!");
                     int id = Integer.parseInt(request.getParameter("id"));
                     Proizvod proizvod = dao.ProizvodDao.proizvodPoId(id); // Metoda za vracanje proizvoda na osnovu id-a
                     Stavka stavka = new Stavka(new Porudzbina(),proizvod,1); // pravi se objekat klase stavka, i taj objekat se dodaje u listu
                     stavkas = new ArrayList<>();
                     stavkas.add(stavka);
                     session.setAttribute("cart", stavkas); // lista se stavlja u sesiju
                }
                else 
                {
                    System.out.println("ELSE");
                    stavkas = (List<Stavka>)session.getAttribute("cart");
                    int id = Integer.parseInt(request.getParameter("id"));
                    int index = isExisting(id, stavkas); // metoda koja proverava da li stavka sa takav model vec postoji u korpi
                    
                    if(index != -1) // ukoliko postoji, povecava samo kolicinu stavke za jedan
                    {
                        stavkas.get(index).setKolicina(stavkas.get(index).getKolicina()+1);
                    }
                    else // ukoliko vec ne postoji u korpi, ubacuje stavku u korpu
                    {
                        Proizvod proizvod = dao.ProizvodDao.proizvodPoId(id);
                        dao.ProizvodDao.closeSession();
                        Stavka stavka = new Stavka(new Porudzbina(),proizvod,1);
                        stavkas.add(stavka);
                    }
                     session.setAttribute("cart", stavkas);       

                }
                RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
                rd.forward(request, response);

            }
            if(action.equalsIgnoreCase("remove")) // action remove, sluzi sa brisanje stavke iz korpe
            {
                 if(session.getAttribute("cart") != null)
                     stavkas = (List<Stavka>)session.getAttribute("cart");

                 int index = isExisting(Integer.parseInt(request.getParameter("id")), stavkas);
                 if(index != -1) stavkas.remove(index); // ukoliko postoji takva stavka u listi, brise je iz iste

                 session.setAttribute("cart", stavkas);
                 RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
                 rd.forward(request, response);
            }
            if(action.equalsIgnoreCase("buy")) // action sluzi za slanje porudzbine
            {
                if(session.getAttribute("korisnik") != null) // provera da li je korisnik ulogovan
                {
                    
                    Korisnik kor = (Korisnik) session.getAttribute("korisnik");
                    
                    stavkas = (List<Stavka>)session.getAttribute("cart");
                    
                    if(session.getAttribute("cart")== null || stavkas.size() == 0 ) // provera da li postoje stavke u korpi
                    {
                       RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
                       rd.forward(request, response); 
                    }
                    else //ukoliko korpa nije prazna, porudzbina se upisuje u bazu
                    {
                        Date datum = new Date(2017, 7, 5);
                        Porudzbina poruzbina = dao.ProizvodDao.insertPorudzbina(new Porudzbina(kor, datum));
                        for(Stavka s:stavkas){
                            dao.ProizvodDao.insertStavke(new Stavka(poruzbina, s.getProizvod(), s.getKolicina()));
                        }

                        Korisnik kor2 = dao.KorisnikDao.logovanKorisnik(kor.getEmail());
                        session.setAttribute("korisnik",kor2);
                        dao.ProizvodDao.closeSession();
                        stavkas.clear();
                        RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
                        rd.forward(request, response);
                    }

                    
                }
                else 
                {
                    RequestDispatcher rd = request.getRequestDispatcher("Logovanje.jsp");
                    rd.forward(request, response);
                }
            }
        } 
        catch (Exception e)
        {
            System.out.println("Order Servlet");
            System.out.println(e);
        }
         
       
    }
    
    private static int isExisting(int id,List<Stavka> stavke) // privatna metoda koja proverava da li izabrani proizvod postoji u korpi
    {   // ukoliko postoji, vraca id stavke u kojoj se nalazi taj proizvod, ukoliko ne, vraca -1
        
        for(int i = 0;i<stavke.size();i++) {
            if(stavke.get(i).getProizvod().getProizvodId() == id) {
                return i;
            }
        }
        return -1;
        
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
