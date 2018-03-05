
function insertNewProizvod()
{
    var brend = document.getElementById("ProBrend").value;
    var nazivProizvoda = document.getElementById("ProNaziv").value;
    var opis = document.getElementById("ProOpis").value;
    var velicine = document.getElementById("ProVelicine").value;
    var kategorija = document.getElementById("ProKKategorija").value;
    var cena = document.getElementById("ProCena").value;
    var slika = document.getElementById("ProUpload").value;
    if(brend != "none" && nazivProizvoda.length != 0 &&
        opis != "none" && velicine.length != 0 && kategorija.length != 0 && cena.length != 0 )
    { 
        return true;
    }  
    else
    {
        document.getElementById("actionInfo").innerHTML = "Polja nisu adekvatno popunjena. Proverite da neko niste preskocili.<button onclick='refresh()' align='right' >Refresh</button>";
        return false;
    }
       
};

function refresh() {
    
    document.getElementById("actionInfo").innerHTML = " ";
};

