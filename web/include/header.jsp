<%@page import="java.util.List"%>
<%@page import="entity.Stavka"%>
<%@page import="entity.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%      
        
        int kolicina = 0;
        
        if(session.getAttribute("korisnik")!= null)
        {   
            Korisnik kor = (Korisnik)session.getAttribute("korisnik");
        }
      
        if(session.getAttribute("cart") != null) {
                List<Stavka> stavkas = (List<Stavka>)session.getAttribute("cart");
                kolicina = stavkas.size();
            }
        
 %>
<!DOCTYPE html>
<style>
    @import url('https://fonts.googleapis.com/css?family=Oswald:400,700');
    @import url('https://fonts.googleapis.com/css?family=Montserrat:400,700');
    
    body
{
    background-repeat: no-repeat;
    background-size: cover;
 margin: 0;
}
header 
{
 background: black;   
 color: white;
 padding: 8px 0px 6px 40px;
 height: 46px;
}
header h1
{
    display: inline;
    font-family: 'Oswald', sans-serif;
    font-weight: 400;
    font-size: 32px;
    float: left;
    margin-top: -5px;
    margin-right: 15px;
    margin-left: -20px;
}
nav ul
{
    display: inline;
    padding: 0px;
    float: left;
}
nav ul li
{
    display: inline-block;
    list-style-type: none;
    color: white;
    float: left;
    margin-left: 15px;
}
nav ul li a
{
    color:  white;
    text-decoration: none;
}
#nav
{
    font-family: 'Montserrat', sans-serif;
}
.homered:hover{
    background-color: red;
    padding: 24px 10px 20px 10px
}
.divider
{
    background-color: red;
    height: 5px;
}
</style>
    <header>
            <nav>
                <h1>SkiShop</h1>
                <ul id="nav">
                    <li><a class="homered" href="Home.jsp">Početna</a></li>
                    <li><a class="homered" href="Proizvodi.jsp">Proizvodi</a></li>
                    <% if(session.getAttribute("korisnik") == null) { %>
                    <li><a class="homered" href="Logovanje.jsp">Login i Registracija</a></li>
                    <% } else { %>
                    <li><a class="homered" href="Profil.jsp">Profil</a></li>
                    <% } %>
                    <li><a class="homered" href="cart.jsp">Korpa(<%= kolicina %>)</a></li>
                </ul>
            </nav>
    </header>
    <div class="divider"></div>
