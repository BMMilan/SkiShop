<%@page import="java.util.ArrayList"%>
<%@page import="entity.Stavka"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  List<Stavka> items = new ArrayList();
    int broj = 0;
    double suma = 0;
    if(session.getAttribute("cart") != null) {
     items = (List<Stavka>)session.getAttribute("cart");
}
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Korpa</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="Css/cart.css" />
        <link href="Css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <script src="JavaScript/sweetalert-dev.js" type="text/javascript"></script>
        <script type="text/javascript">
            function onClick(){
              swal({
  title: "Da li ste sigurni ?",
  text: "Necete moci menjati zahtev posle kreiranja porudzbine !",
  type: "warning",
  showCancelButton: true,
  confirmButtonColor: "#DD6B55",
  confirmButtonText: "Da, kreiraj porudzbinu!",
  closeOnConfirm: false
},
function(){
   window.location.href = 'CartServlet?action=buy&&suma=<%= suma %>';
});
      
            }
            </script>
    </head>
    <body>
        <jsp:include page="include/header.jsp" />
        <div class="content">
                <table border="5">
                    <caption><div> <img src='slike/Cart.jpg' alt="korpa" />Korpa</div></caption>
                    <tr>
                        <th>Slika</th>
                        <th>Proizvođač</th>
                        <th>Model</th>
                        <th>Cena </th>
                        <th>Količina</th>
                        <th>Suma</th>
                        <th>Option</th>
                    </tr>
                    <% if(items.isEmpty()) {  %>
                    <tr><td colspan="7" align="center">Korpa je trenutno prazna</td></tr>
                    <% } else { %>
                    <% for(Stavka it:items) {

                        suma += it.getProizvod().getCena().doubleValue() *  it.getKolicina();

                        %>
                    <tr>
                        <td><img src='slike/<%= it.getProizvod().getReferencuSlike() %>' alt='slika' /></td>
                        <td><%= it.getProizvod().getBrend().getNaziv() %></td>
                        <td><%= it.getProizvod().getNazivProizvoda() %></td>
                        <td><%= it.getProizvod().getCena() %></td>
                        <td><%= it.getKolicina() %></td>
                        <td><%= it.getProizvod().getCena().doubleValue() * it.getKolicina() %></td>
                        <td><a href='CartServlet?action=remove&&id=<%= it.getProizvod().getProizvodId() %>' onclick=" return confirm('Da li želite da izbacite proizvod iz korpe?')" > Delete</a></td>
                    </tr>
                    <% }} %>
                    <tr><td colspan="6" align="right">ukupno</td><td align="center"><%= suma %></td></tr>
                </table>
                <div id="actions">
                    <a href="Home.jsp">Nazad na kupovinu</a>
                    <a href='#' onclick="onClick();">Pošalji porudžbinu</a>
                </div>
             
            <div id='deo2'>
                <div id='cart-img'>
                    
                </div>
                <div id='total'>
                    <table>
                        <tr>
                            <td>Vrednost porudžbine: </td>
                            <td><%= suma %> RSD</td>
                        </tr>
                        <tr>
                            <td>Za plaćanje:  </td>
                            <td><%= suma %> RSD</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
