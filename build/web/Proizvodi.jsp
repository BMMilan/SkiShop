<%@page import="java.util.List"%>
<%@page import="dao.ProizvodDao"%>
<%@page import="entity.Proizvod"%>
<%List<Proizvod> proizvod = (List<Proizvod>) ProizvodDao.sviProizvodi(); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proizvodi</title>
        <link rel="stylesheet" href="Css/pretraga.css">
    </head>
    <body>
        <jsp:include page="include/header.jsp"/>
        <div class="container">
            <%for(Proizvod p:proizvod){%>
            <ul>
                <li>
                    <div class="item">
                        <img src="slike/<%= p.getReferencuSlike() %>" alt="slika"/>
                        <h5><%=p.getNazivProizvoda() %></h5>
                        <p><%="Cena: "+p.getCena()+" RSD" %></p>
                        <form action="Specifikacija" method="get">
                            <button value="<%= p.getProizvodId() %>" name="btn1" class="specifikacije" >Specifikacije</button><br/>
                        <a href="CartServlet?action=order&&id=<%=p.getProizvodId() %>"><input type="button" value="Ubaci u korpu" /></a>
                        </form>
                    </div> 
                </li>
            </ul>
            <%}%>
        </div>
    </body>
</html>
