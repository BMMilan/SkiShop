<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login i Registracija</title>
        <link rel="stylesheet" href="Css/loginReg.css"/>
        <script src="JavaScript/logovanje.js"></script>
    </head>
    <body>
        <jsp:include page="include/header.jsp"/>
           <div class="content">
            <div id="prijava">
                <h3>Postojeći korisnik</h3>
                <p>Za prijavu upišite korisničko ime i lozinku</p>
                <form action="LoginServlet" method="post" >
                    <input type="hidden" name="akcije" value="logovanje" />
                    <table>
                        <tr><td>Korisničko ime: </td><td><input type="text" name="username" required placeholder="korisnicko ime" /></td></tr>
                        <tr><td>Password: </td><td><input type="password" name="password" required placeholder="password"/></td></tr>
                        <tr><td colspan="2" style="text-align: center;"><input type="submit" value="Uloguj se" /></td></tr>
                    </table>
                </form>
                <p id="proveraKorisnika"></p>
            </div>
            <div id="register">
                <h3>Novi korisnik</h3>
                <p>Za registraciju popunite sledeca polja</p>
                <form action="LoginServlet" method="post" >
                    <input type="hidden" name="akcije" value="registracija" />
                    <table>
                        <tr>
                            <td>Ime: <input type="text" name="inp-ime" required placeholder="ime" /></td>
                            <td></td>
                            <td>Prezime: <input type="text" name="inp-prezime" required placeholder="prezime" /></td>
                        </tr>
                        <tr>
                            <td>E-mail: <input type="text" name="inp-email" required placeholder="email"></td>
                            <td>Lozinka: <input type="password" name="inp-un-pass1" required placeholder="lozinka" /></td>
                            <td>Ponovi lozinku: <input type="password" name="inp-un-pass2" required placeholder="lozinka" /></td>
                        </tr>
                        <tr>
                            <td>Grad: <input type="text" name="inp-grad" required placeholder="korisnicko ime" /></td>
                            <td>Adresa: <input type="text" name="inp-adresa" required placeholder="adresa" /></td>
                        </tr>
                        <tr>
                            <td><input value="Registruj se" type="submit" /></td>
                        </tr>
                    </table>
                </form>
                <p id="registracijaKorisnika"></p>
            </div>  
        </div>
    </body>
</html>
