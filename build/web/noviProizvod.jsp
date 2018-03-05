<%@page import="dao.KategorijeDao"%>
<%@page import="entity.*"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProizvodDao"%>
<%@page import="entity.Proizvod"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Brend> sviBrendoviList = ProizvodDao.sviBrendovi();
    List<Kategorija> sveKategorijeList = KategorijeDao.sveKategorije();
    ProizvodDao.closeSession();
    
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novi Proizvod</title>
        <link rel="stylesheet" href="Css/noviProizvod.css" />
        <script src="JavaScript/noviProizvod.js"></script>
    </head>
    <body>
         <jsp:include page="include/adminHeader.jsp" />
         <div class="content">
            <div id="actionInfo">
                
            </div>
             <form method="POST" action="NoviProizvodServlet" enctype="multipart/form-data" onsubmit="return insertNewProizvod();"  >
             <table>
                 <caption>Ubaci novi Proizvod</caption>
                 <tr>
                    <td>
                         Brend:
                    </td>
                    <td>
                    <select id="ProBrend" name="ProBrend" >
                        <option value="none">[---izaberi brend---]</option>
                        <% for(Brend br:sviBrendoviList) { %>
                        <option value=<%=br.getBrendId() %>><%= br.getNaziv() %></option>
                        <% } %>
                    </select>
                    </td>
                 </tr>
                 <tr>
                    <td>
                         Unesi Naziv: 
                    </td>
                    <td>
                         <input type="text" id="ProNaziv" name="ProNaziv" width="100" required placeholder="Unesite naziv" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Kategorija:
                    </td>
                    <td>
                    <select id="ProKategorija" name="ProKategorija" >
                        <option value="none" >[---izaberi kategoriju---]</option>
                        <% for(Kategorija k:sveKategorijeList) { %>
                        <option value=<%= k.getKategorijaId() %>><%= k.getKategorija() %></option>
                        <% } %>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Dostupne veličine: 
                    </td>
                    <td>
                        <input type="text" name="ProVelicine" id="ProVelicine" width="100" required placeholder="163cm,46,75cmx40cm" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Opis: 
                    </td>
                    <td>
                        <input type="text" name="ProOpis" id="ProOpis" width="100" required placeholder="Unesite opis"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Slika proizvoda: 
                    </td>
                    <td>
                        <input type="file" name="ProUpload" id="ProUpload" size="100" required />
                    </td>
                </tr>
                <tr>
                     <td>
                         Cena proizvoda: 
                     </td>
                     <td><input type="text" name="ProCena" id="ProCena" required placeholder="234999.99" /> </td>
                 </tr>
                 <tr>
                     <td colspan="4" align="center" ><input type="submit" value="Ubaci proizvod" /> </td>
                 </tr>
            </table>
            </form> 
            
         </div>
    </body>
</html>

