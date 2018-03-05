<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ProizvodDao"%>
<%@page import="entity.Proizvod"%>
<% 
   List<Proizvod> sviProizvodi = ProizvodDao.sviProizvodi();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ažuriraj proizvod</title>
        <link rel="stylesheet" href="Css/update.css" />
        <script src="JavaScript/update.js"></script>
    </head>
    <body>
        <jsp:include page="include/adminHeader.jsp" />
        <div class="content">
            <p id="messageBar"></p>
            <div id="selectdiv">
                <table>
                    <tr>
                        <Td>
                            <select id="SelectProizvod" onchange="izaberi()" >
                                <option value="none">[---izaberi proizvod---]</option>
                                <% for(Proizvod p:sviProizvodi) { %>
                                <option value=<%=p.getProizvodId() %>><%= p.getBrend().getNaziv() +" "+p.getNazivProizvoda() %></option>
                                <% } %>
                            </select>
                        </Td>
                    </tr> 
                    <tr>
                        <td>
                            <input type="radio" name="updateProizvod" value="cena" onclick="showValue(this.value)" >Cena</input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="updateProizvod" value="dimenzije" onclick="showValue(this.value)" >Dimenzije</input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="updateProizvod" value="naziv" onclick="showValue(this.value)" >Naziv</input>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="showProizvod">
                 
            </div>
            
             
        </div>
</body>
</html>

