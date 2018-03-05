<%@page import="entity.Stavka"%>
<%@page import="entity.Korisnik"%>
<%@page import="java.util.List"%>
<%@page import="entity.Kategorija"%>
<%@page import="dao.KategorijeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Kategorija> kategorija = KategorijeDao.sveKategorije();%>
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

<html>
    <head>
        <title>SkiShop</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Css/home.css">
        <script></script>
    </head> 
    <jsp:include page="include/header.jsp"/>
        <div class="content">
            <div class="proizvodjaci">
                <%for(Kategorija k:kategorija){%>
                <a href="Controler?vrstaProizvoda=<%=k.getKategorija() %>"><button value="Skije"><%=k.getKategorija() %> </button></a><br/>
                <%}%>
            </div>
            <div class="container">
                <ul>
                    <li>
                        <div class="item">
                            <img src="slike/skije1.jpg" alt="HEAD SUPERSHAPE IRALLY SW TFB" />
                            <h4>HEAD SUPERSHAPE SW TFB</h4>
                            <p>Cena: 62.662,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="1" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=1"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li> 
                    <li>
                        <div class="item">
                            <img src="slike/cipele1.jpg" alt="HEAD VECTOR EVO 120 BLACK/GREEN" />
                            <h4>HEAD VECTOR EVO 120</h4>
                            <p>Cena: 33.112,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="3" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=3"><input class="ubaci" type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <img src="slike/snow2.jpg" alt="HEAD RUSH" />
                            <h4>HEAD RUSH</h4>
                            <p>Cena: 23.554,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="8" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=8"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <img src="slike/cipele3.jpg" alt="HEAD FIVE BOA" />
                            <h4>HEAD FIVE BOA</h4>
                            <p>Cena: 22.381,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="5" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=5"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <img src="slike/skije2.jpg" alt="SUPERSHAPE I.SPEED SW TFB BK/YW" />
                            <h4>SUPERSHAPE SW TFB</h4>
                            <p>Cena: 64.562,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="2" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=2"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <img src="slike/cipele2.jpg" alt="HEAD STIVOT" />
                            <h4>HEAD STIVOT</h4>
                            <p>Cena: 31.392,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="4" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=4"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/snow1.jpg" alt="HEAD G-FORCE" />
                            <h4>HEAD G-FORCE</h4>
                            <p>Cena: 35.216,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="7" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=7"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/cipele4.jpg" alt="HEAD THREE WMN BOA 16/17" />
                            <h4>HEAD THREE WMN BOA</h4>
                            <p>Cena: 21.871,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="6" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=6"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/naocare3.jpg" alt="HEAD GALACTIC FS FMR WHITE/BLUE" />
                            <h4>HEAD GALACTIC FS FMR</h4>
                            <p>Cena: 7905,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="19" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=19"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/torba1.jpg" alt="HEAD REBEL" />
                            <h4>HEAD REBEL</h4>
                            <p>Cena: 16224,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="20" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=20"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/torba2.jpg" alt="HEAD WOMENS BOOT BAG SHADOW" />
                            <h4>HEAD WOMENS SHADOW</h4>
                            <p>Cena: 2824,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="22" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=22"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                    <li>
                       <div class="item">
                            <img src="slike/stap2.jpg" alt="HEAD AIRFOLI BLACK NEON RED" />
                            <h4>HEAD AIRFOLI RED</h4>
                            <p>Cena: 5865,00 RSD</p>
                            <form action="Specifikacija" method="get">
                            <button value ="25" name="btn1" class="specifikacije" >Specifikacije</button>
                            <a href="CartServlet?action=order&&id=25"><input type="button" value="Ubaci u korpu" /></a>
                            </form>
                        </div>
                    </li>
                </ul>
                
            </div>
        </div>
        
    </body>
</html>


