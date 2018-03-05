<%@page import="java.util.List"%>
<%@page import="entity.Proizvod"%>
<% List<Proizvod> proizvod = (List<Proizvod>)session.getAttribute("kategorija");
String kategorija = (String) session.getAttribute("naziv"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prikaz Proizvoda</title>
        <link rel="stylesheet" href="Css/prikazProizvoda.css">
        <script src="JavaScript/prikazProizvodaAjax.js"> </script>
    </head>
    <body>
        <jsp:include page="include/header.jsp"/>
        <div class="content">
            <h1><%=kategorija %></h1>
            <select onchange="prikazAjax(this.value)">
                <option value="none">[--izaberi--]</option>    
                <% for(Proizvod p:proizvod) { %>
                <option value="<%= p.getProizvodId()%>"><%=p.getNazivProizvoda() %></option>
                <% } %>
            </select>
        </div>
            <div id="prikaz" class="specification">
                
            </div>
        
    </body>
</html>
