<%@page import="entity.Korisnik"%>
<%@page import="entity.Stavka"%>
<%@page import="entity.Porudzbina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Porudzbina por = (Porudzbina)session.getAttribute("porudzbina"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Porudžbina</title>
        <link rel="stylesheet" href="Css/porudzbina.css" />
    </head>
    <body>
        <% if(session.getAttribute("korisnik") != null) { %>
        <% Korisnik kor = (Korisnik)(session.getAttribute("korisnik"));
           if(kor.getPrava().getPravaId() == 2) {       %>
        <jsp:include page="include/ProfilHeader.jsp" />
        <% } else {%>
        <jsp:include page="include/adminHeader.jsp" />
        <% }} %>
        <div class="content">
            <table>
                <caption><h3>Sastav porudžbine</h3></caption>
                <tr>
                    <th>Slika</th>
                    <th>Proizvođač</th>
                    <th>Model</th>
                    <th>Količina</th>
                    <th>Cena</th>
                    <th>Suma</th>
                </tr>
                <% for(Stavka stavka: por.getStavkas()) { %>
                <tr>
                    <td><img src='slike/<%= stavka.getProizvod().getReferencuSlike() %>' alt='slika' /> </td>
                    <td><%= stavka.getProizvod().getBrend().getNaziv() %></td>
                    <td><a href='Specifikacija?btn1=<%= stavka.getProizvod().getProizvodId() %>' ><span><%= stavka.getProizvod().getNazivProizvoda() %></span></a></td>
                    <td><%= stavka.getKolicina() %></td>
                    <td><%= stavka.getProizvod().getCena() %> RSD</td>
                    <td><%= stavka.getProizvod().getCena().doubleValue() * stavka.getKolicina() %> RSD</td>
                </tr>
                <% } %>
            </table>
            
        </div>
    </body>
</html>
