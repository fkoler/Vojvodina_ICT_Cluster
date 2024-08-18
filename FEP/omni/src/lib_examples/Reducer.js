// useReducer hook je sličan useState hook-u ali vam omogucava da logiku azuriranja premestite iz obradjivaca dogadjaja u jednu funkciju izvan vase komponente
// Omogucava prilagodjenu logiku stanja
// Koristi se ako vodite racuna o vise delova stanja koji se oslanjaju na slozenu logiku

import { useReducer } from "react"

// Sintaksa:
//      useReducer(<reducer>, <initialState>)
//          - reducer - funkcija koja sadrzi prilagodjenu logiku stanja, odredjuje kako se stanje azurira. Treba da uzme stanje i akciju kao argumente i da vrati sledece stanje.
//          - initialState - jednostavna vrednost, obicno objekat, vrednost iz koje se izracunava pocetno stanje
//          - init? (opcionalno) - funkcija koja treba da vrati pocetno stanje; ako nije navedeno, pocetno stanje je postavljeno na initialState 
//      Povratna vrednost: 
//          - currentState - trenutno stanje
//          - dispatch funkcija - omogucava azuriranje stanja i pokretanje ponovnog prikaza komponente 
//                              - prima akciju (action) argument - predstavalja radnju koju je korisnik izvrsio, vrednost bilo koje vrste. Po konvenciji, to je obicno objekat da svojstvom tipa koji ga identifikuje i opciono drugim svojstvima sa dodatnim informacijama.
//                              - nema povratnu vrednost




// 1. kreiranje reducer funkcije, koju cemo koristiti da definisemo kako ce stanje da se azurira
const reducer = (state, action) => {
    // Argumente ce dobiti od React-a, i na osnovu toga ce izracunati i vratiti sledece stanje, React ce sacuvati stanje, prikazati ponovo komponentu i azurirati korisnicki interfejs

    // proverimo koju akciju je korisnik uradio i na osnovu toga izmenimo stanje 
    if(action.type === 'povecaj_brojac') {
        return {
            brojac: state.brojac + 1
        }
    }else if(action.type === 'umanji_brojac'){
        return {
            brojac: state.brojac - 1
        }
    }

    // ako akciju nismo definisali onda izbacimo gresku
    throw Error('Nepoznata akcija')
}


const Reducer = () => {
    //2. kreiramo stanje pomocu useReducer hook-a, koji prima funkciju reducer koja definise kako se stanje menja i inicijalnu vrednost stanja 
    const [state, dispatch] = useReducer(reducer, {brojac: 42})
    
    // da biste azurirali ono sto je prikazano, neophodno je pozvati dispatch metodu sa objektom koji predstavlja sta je korisnik uradio
    const povecajBrojac = () => {
        // 3. pozovemo azuriranje stanja
        dispatch({type: 'povecaj_brojac'});
    }

    const umanjiBrojac = () => {
        dispatch({type: 'umanji_brojac'});
    }

    return <div>
        <p> {state.brojac} </p> 
        <button onClick={umanjiBrojac}> - </button>
        <button onClick={povecajBrojac}> + </button>
    </div>
}

export default Reducer;

// Dodatak - POREDJENJE useState i useReducer
/**
 * a) Velicina koda - useState ima manje koda, ali useReducer moze da pomogne u smanjenju koda ako mnogi obradjivaci dogadjaja modifikuju stanje na slican nacin
 * b) Citljivost - useState se veoma lako cita kada su azuriranja stanja jednostavna, ali kada postanu slozenije onda mogu da postanu teska za razumevanje i pregled; useReducer omogucava da jasno odvojite logiku azuriranja od onoga sto se dogodilo sa obradjivacem dogadjaja
 * c) Otklanjanje gresaka - useState vam ne moze reci gde je doslo do greske, dok uz upotrebu useReducer mozete da dodate ispis na konzolu u reduce funkciji kako biste videli svako azuriranje stanja i zasto se to dogodilo
 * d) Testiranje - reduce funkcija je funkcija koja je nezavisna od komponente i mozete je lako testirati
 * e) Licne preferencije - neki ljudi vole reduktore, drugi ne. To je stvar preferencije. Uvek mozete da konvertujete izmedju useState i useReducer, zato sto su ekvivalentni
 */

// PREPORUKA: useReducer koristiti ako cesto nailazite na greske prilikom azuriranja stanja u nekoj komponenti i ako zelite da unesete vise strukture u kod. Ne morate useReducer da koristite za sve, slobodno mesajte i spajajte. useState i useReducer mozete koristiti u istoj komponenti.