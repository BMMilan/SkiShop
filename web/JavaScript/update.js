function showValue(vrednost)
{ 
    var select = document.getElementById("SelectProizvod").value;
    if(select != "none")
    {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("showProizvod").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","updateProizvodServlet?proizvodId="+select+"&action="+vrednost,true);
        xmlhttp.send();
    }
    else 
    {
        alert("Niste izabrali proizvod!");
        uncheckAll();
    }
       
};

function uncheckAll()
{
       var elem = document.getElementsByName("updateProizvod");
       for(var i = 0;i<elem.length;i++) {
           elem[i].checked = false;
       }
};

function izaberi()
{
    uncheckAll();
    document.getElementById("showProizvod").innerHTML = " ";
};

function actionCena(vrednost)
{
   var select = document.getElementById("SelectProizvod").value;
   var podatak = document.getElementById("novaCenaProizvoda").value;
   if(podatak.length == 0) alert("Polje je prazno.");
   else 
   {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("messageBar").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","updateProizvodServlet?proizvodId="+select+"&action="+vrednost+"&novaCena="+podatak,true);
        xmlhttp.send();
        izaberi();
   }
    
};

function actionDimenzija(vrednost)
{
   var select = document.getElementById("SelectProizvod").value;
   var podatak = document.getElementById("novaDimenzijaPolje").value;
   if(podatak.length == 0) alert("Polje je prazno.");
   else
   {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("messageBar").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","updateProizvodServlet?proizvodId="+select+"&action="+vrednost+"&novaDimenzija="+podatak,true);
        xmlhttp.send();
        izaberi();
   }
    
};

function actionNaziv(vrednost)
{
   var select = document.getElementById("SelectProizvod").value;
   var podatak = document.getElementById("noviNazivPolje").value;
   if(podatak.length == 0) alert("Polje je prazno.");
   else 
   {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("messageBar").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","updateProizvodServlet?proizvodId="+select+"&action="+vrednost+"&noviNaziv="+podatak,true);
        xmlhttp.send();
        izaberi();
   }
    
};

function reloadBar() {
    document.getElementById("messageBar").innerHTML = " ";
};



