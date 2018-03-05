package servleti;

import dao.KategorijeDao;
import dao.ProizvodDao;
import entity.Brend;
import entity.Kategorija;
import entity.Proizvod;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "NoviProizvodServlet", urlPatterns = {"/NoviProizvodServlet"})
@MultipartConfig(maxFileSize = 16177215) public class NoviProizvodServlet extends HttpServlet {
    
    private final static Logger LOGGER = Logger.getLogger(NoviProizvodServlet.class.getCanonicalName());
    
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
            throws ServletException, IOException
    {
        
        String nazivProizvoda = request.getParameter("ProNaziv").trim();
        String velicine = request.getParameter("ProVelicine").trim();
        String opis = request.getParameter("ProOpis").trim();
        BigDecimal cena = new BigDecimal(request.getParameter("ProCena").trim());
        HttpSession session = request.getSession(true);
        
        
        Brend brend = ProizvodDao.sviBrendoviPoId(Integer.parseInt(request.getParameter("ProBrend")));
        Kategorija kategorija = KategorijeDao.KategorijaPoId(Integer.parseInt(request.getParameter("ProKategorija")));
        
        
        String path = "C:\\Users\\Milan\\Documents\\NetBeansProjects\\SkiShop\\web\\slike/";
        Part filePart = request.getPart("ProUpload");
        String referencaSlike = getFileName(filePart);
        
        OutputStream outS = new FileOutputStream(new File(path + File.separator + referencaSlike));
        InputStream filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
                outS.write(bytes, 0, read);
        }

        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                    new Object[]{referencaSlike, path});
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            Proizvod proizvod = new Proizvod(brend, kategorija, nazivProizvoda, referencaSlike, cena, velicine, opis);
            ProizvodDao.insertProizvod(proizvod);
            session.setAttribute("sviProizvodi", ProizvodDao.sviProizvodi());
            //ProizvodDao.closeSession();
            RequestDispatcher rd = request.getRequestDispatcher("ProizvodUbacen.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
