<%@page import="java.util.List"%>
<%@page import="dao.ProizvodDao"%>
<%@page import="entity.Brend"%>
<%@page import="entity.Proizvod"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Proizvod proizvod = (Proizvod)session.getAttribute("spec"); %>
<% String link = "slike/"+proizvod.getReferencuSlike(); %>
<% Brend brend = (Brend)session.getAttribute("brend") ; %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=proizvod.getNazivProizvoda() %></title>
        <link rel="stylesheet" href="Css/specifikacija.css"/>
    </head>
    <body>
        <jsp:include page="include/header.jsp" />
        <div class="content">
        <div class="sadrzaj">
        
        <div class="Osnovni-info">
            <h3><%=proizvod.getNazivProizvoda() %></h3>
            <img src=<%=link %> alt="slika" />
            <h3>Cena: <%= proizvod.getCena() %> RSD</h3>
            <a href='CartServlet?action=order&&id=<%=proizvod.getProizvodId() %>'><input type="button" value="Ubaci u korpu" /></a>
        </div>
        <table>
            <caption>Specifikacije</caption>
            <tr><td>Naziv: </td><td class="podnaslov"><%= proizvod.getNazivProizvoda() %></td></tr>
            <tr><td>Cena: </td><td class="podnaslov"><%= proizvod.getCena() %> RSD</td></tr>
            <tr><td>Dostupne veličine: </td><td class="podnaslov"><%= proizvod.getVelicina() %></td></tr>
            <tr><td>Opis: </td><td class="podnaslov"><%= proizvod.getOpis() %></td></tr>
            <tr>
        </table>
        </div>
        </div>
    </body>
</html>

