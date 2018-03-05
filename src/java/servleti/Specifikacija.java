package servleti;

import dao.ProizvodDao;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Specifikacija", urlPatterns = {"/Specifikacija"})
public class Specifikacija extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String specifikacija = request.getParameter("btn1");
        System.out.println(request.getParameter("btn1"));
        RequestDispatcher rd = request.getRequestDispatcher("Specifikacija.jsp");
        HttpSession session = request.getSession(true);
        session.setAttribute("spec", ProizvodDao.proizvodPoId(Integer.parseInt(specifikacija)));
        session.setAttribute("brend", ProizvodDao.sviBrendoviPoId(Integer.parseInt(specifikacija)));
        rd.forward(request, response);
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
