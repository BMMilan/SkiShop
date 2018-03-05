<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profil Korisnika</title>
        <link rel="stylesheet" href="Css/profil.css" />
        <script src="JavaScript/Profil.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="include/ProfilHeader.jsp"/>
        <div class="content">
            <div id="navigation-profil">
                <table>
                    <tr>
                        <td><button value="profil" onclick="loadContent(this.value)">Moj profil</button></td>
                    </tr>
                    <tr>
                        <td><button value="porudzbina" onclick="loadContent(this.value)">Moje porudžbine</button></td>
                    </tr>
                    <tr>
                        <td><button value="podaci" onclick="loadContent(this.value)" >Promeni podatke</button></td>
                    </tr>
                    <tr>
                        <td><button value="lozinka" onclick="loadContent(this.value)" >Promeni šifru</button></td>
                    </tr>
                </table>
            </div>
             <p id="info-bar"></p>
             <div id="profil-load" onload="brisanje()">
                
                 
             </div>
               
            </div>
         </div>
         
    </body>
</html>
