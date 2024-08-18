/*
    Jedna stvar po kome se Java i JavaScript razlikuju jeste u tome što JS ima mnogo intenzivniji fokus na nešto što se zove funkcionalno programiranje. Ono što karakteriše ovaj pristup programiranju jeste da:
        - Postoje _funkcije_ koje trasnformišu ulazne vrednosti u neku izlaznu vrednost (opciono) i imaju nekakve pobočne efekte (opciono). Možete o njima misliti kao da su u pitanju metode koje nisu zakačene za bilo koju klasu. Funkcije imaju ulazne parametre i potencijalnu povratnu vrednost.
        - Funkcije su vrednosti kao bilo koje koje postoje: ništa različite od broja ili stringa tako da mogu da budu smeštene u promenljivu, osobinu objekta, ili prosleđene u funkciju ili povraćene iz funkcije. 
        - Funkcije se mogu napraviti unutar koda kroz nekakav izraz koji se tipično zove lambda izraz (zato što je matematička osnova na osnovu koje postoji u računarskim naukama nazvana 'lambda račun' -- termin nije relevantan za nas)
*/

// Ovo je klasično definisanje funkcije u JS-u. Apsolutno se dalje koristi, ali ga mi u ovom kursu praktično ne koristimo delimično iz estetskih razloga ali uglavnom zbog problema sa 'this' koji nećemo moći da razumemo još poveći broj časova. Glavno je da znate da možete da napravite funkciju tako što napišete 'function' pa onda ime, i u zagradama sve argumente koje hoćete da prosledite. Ako hoćete anonimnu/lambda funkciju možete da napišete function(argumenti) {} i to će se ponašati kao ono što mi radimo kasnije.
function saberi(a, b) {
    return a + b; //Ako funkcija nešto vraća onda moramo pozvati 'return' da to vratimo
}

//Ovo je metod za deklarisanje koji koristimo za većinu kursa. Radi gotovo apsolutno identično kao function osim jedne razlike koju moramo da objasnimo kasnije. Primetite da ovde funkciju napravimo i smestimo u promenljivu (ovde konstantu, pošto ne želimo da ikada promenimo šta saberi2 znači, ali bi mogli da koristimo let ako želimo da se to promeni, samo bi platili cenu u performansama) i to je kako se ona zove. Parametri idu u zagrade i onda ide jednako i znak za veće (što se ovako u kombinaciji zove 'debela strelica') te onda ide blok koda.
const saberi2 = (a, b) => {
    return a + b;
};

const saberi2_1 = (a, b) => a + b; //Ako funkcija vraća vrednost koju računa jedan izraz kao ovde, možemo preskočiti blok i napisati direktno taj izraz a onda se 'return' podrazumeva. Ovo služi da bi bio moguć kompaktniji zapis.

//Parametri u funkcijama mogu imati podrazumevane vrednosti, onda možemo da ih ne navedemo i njihova podrazumevana vrednost će biti upotrebljena. Svi parametri posle prvog sa podrazumevanom vrednošću moraju imati podrazumevane vrednost pošto ne možemo da izostavimo, npr. treći parametar, a navedemo četvrti.
const saberi3 = (a = 1, b = 2) => {
    return a + b;
};

//Moguće je imati funkcije sa promenljivim brojem parametara. Ovo se rešava sa spread operatorom koji kaže da sve osim prvog parametra (koji ide u a), ide u niz ostalo.
const saberi4 = (a, ...ostalo) => {
    let suma = a;
    for (let o of ostalo) {
        suma += o;
    }
    return suma;
};

// Možemo slobodno da imamo i funkcije koje imaju __samo__ te varijabilne skupove argumenata.
const saberi5 = (...sve) => {
    let suma = 0;
    for (let s of sve) {
        suma += s;
    }
    return suma;
};

const p01_funkcije = () => {
    return (
        <table border={1}>
            <tr>
                <th>Izraz</th>
                <th>Rezultat</th>
            </tr>
            <tr>
                <td>saberi(3,4)</td>
                <td>{saberi(3, 4)}</td>
            </tr>
            <tr>
                <td>saberi2(3,4)</td>
                <td>{saberi2(3, 4)}</td>
            </tr>
            <tr>
                <td>saberi3()</td>
                <td>{saberi3()}</td>
            </tr>
            <tr>
                <td>saberi3(3)</td>
                <td>{saberi3(3)}</td>
            </tr>
            <tr>
                <td>saberi3(3,4)</td>
                <td>{saberi3(3, 4)}</td>
            </tr>
            <tr>
                <td>saberi4(3, 4, 5, 6)</td>
                <td>{saberi4(3, 4, 5, 6)}</td>
            </tr>
            <tr>
                <td>saberi5(3,4,5,6)</td>
                <td>{saberi5(3, 4, 5, 6)}</td>
            </tr>
        </table>
    );
};

const oduzmi = (a, b) => {
    return a - b;
};

//Ova funkcija uzme niz i primeni funkciju koju je dobila na susedne vrednosti, ako niz ima neparan broj elemenata, onda se dodaje 'podrazumevana_vrednost' na kraj niza tako da ima paran broj.
const primeni_na_parove = (niz, funkcija, podrazumevana_vrednost) => {
    let rez = [];
    if (niz.length % 2 != 0) {
        niz.push(podrazumevana_vrednost);
    }
    for (let i = 0; i < niz.length; i += 2) {
        rez.push(funkcija(niz[i], niz[i + 1])); //Funkcija je parametar ovde ali je pozivamo i tretiramo baš kao i bilo koju drugu funkciju i ona i radi baš kao bilo koja druga funkcija.
    }
    return rez;
};

const p02_funkcije_kao_parametri = () => {
    let niz = [3, 1, 4, 1, 5, 9, 2, 6];
    return (
        <table border={1}>
            <tr>
                <th>Izraz</th>
                <th>Rezultat</th>
            </tr>
            <tr>
                <td>primeni_na_parove(niz, saberi2, 0)</td>
                <td>{JSON.stringify(primeni_na_parove(niz, saberi2, 0))}</td>
            </tr>
            {/* Ovo je način da imamo komentare u sred JSX-a. Gore upotrebljavamo primeni_na_parove sa sabiranjem*/}
            <tr>
                <td>primeni_na_parove(niz, oduzmi, 0)</td>
                <td>{JSON.stringify(primeni_na_parove(niz, oduzmi, 0))}</td>
            </tr>
            {/* Ako hoćemo oduzimanje, nema problema, metod je isti samo promenimo koju funkciju prosledimo*/}
            <tr>
                <td>primeni_na_parove(niz, (a, b) =&gt; a / b, 0)</td>
                <td>
                    {JSON.stringify(primeni_na_parove(niz, (a, b) => a / b, 0))}
                </td>
            </tr>
            {/*Nema potrebe da funkcija bude u promenljivoj ili konstanti ako je koristimo samo jednom, možemo ono kako se definiše da stavimo direktno na mesto u funkciji gde se to prosleđuje.*/}
        </table>
    );
};

const p03_funkcije_za_nizove = () => {
    let niz = [3, 1, 4, 1, 5, 9, 2, 6];
    return (
        <table border={1}>
            <tr>
                <th>Izraz</th>
                <th>Rezultat</th>
            </tr>
            <tr>
                <td>
                    <pre>
                        niz.every((vrednost, indeks, ceo_niz) =&gt; vrednost % 2
                        == 0)
                    </pre>
                </td>
                <td>
                    {niz.every((vrednost, indeks, ceo_niz) => vrednost % 2 == 0)
                        ? 'true'
                        : 'false'}
                </td>
            </tr>
            {/* Every izvrši prosleđenu funkciju nad svakim elementom i vrati true ako i samo ako je ta funkcija vratila 'true' nad svakim elementom nad kojim je pozvana. Ova funkcija koja vraća ili true ili false se zove 'predikat.' Ovaj predikat u ovom slučaju prima sve što je ova funkcija (i njoj slične u standardnoj biblioteci) nudi: vrednost niza, njen indeks, i ceo niz, ako nam zatreba. Ne moramo da iskoristimo sve ove stvari i smemo da prosledimo funkcije koje ignorišu zadnji ili zadnja dva parametra.*/}
            <tr>
                <td>
                    <pre>niz.filter((vrednost) =&gt; vrednost % 2 == 0)</pre>
                </td>
                <td>
                    {JSON.stringify(
                        niz.filter((vrednost) => vrednost % 2 == 0)
                    )}
                </td>
            </tr>
            {/* Filter vraća nov niz u kome su samo oni elementi niza nad kojim je pozvan koji zadovoljavaju prosleđen predikat. Primetite da smo ovde koristili predikat koji ignoriše zadnja dva parametra pošto nam ne trebaju. */}
            <tr>
                <td>
                    <pre>
                        niz.find((vrednost, indeks) =&gt; vrednost % 2 == 0)
                    </pre>
                </td>
                <td>{niz.find((vrednost, indeks) => vrednost % 2 == 0)}</td>
            </tr>
            {/* Find vrati prvu stavku u nizu koja zadovoljava dati predikat. Da demonstriramo da može, ovde prosleđujemo varijantu predikata koja samo ignoriše zadnji parametar. Osim što postoji find (koji nalazi samo prvu vrednost) imamo i potpuno ekvivalentne findIndex (nalazi indeks prve vrednosti koja zadovoljava predikat), findLast (nalazi zadnju vrednost koja zadovoljava predikat, tj. krene da traži od kraja niza), i findLastIndex (nalazi indeks zadnje vrednost koja zadovoljava predikat). U slučaju da nema ničega što zadovoljava vraća se ili 'undefined' ako se traži vrednost ili -1 ako se traži indeks.*/}
            <tr>
                <td>
                    <pre>niz.map((vrednost) =&gt; vrednost % 2 == 0)</pre>
                </td>
                <td>
                    {JSON.stringify(niz.map((vrednost) => vrednost % 2 == 0))}
                </td>
            </tr>
            {/* Mapiranje vrati novi niz čiji je svaki element rezultat primene priložene funkcije na odgovarajući element ulaznog niza.*/}
            <tr>
                <td>
                    <pre>
                        niz.some((vrednost, indeks, ceo_niz) =&gt; vrednost % 2
                        == 0)
                    </pre>
                </td>
                <td>
                    {niz.some((vrednost, indeks, ceo_niz) => vrednost % 2 == 0)
                        ? 'true'
                        : 'false'}
                </td>
            </tr>
            {/* Some radi tačno kao i every, ali vraća 'true' ako predikat važi za bilo koji element niza. */}
            <tr>
                <td>
                    <pre>
                        niz.reduce((akumulator, vrednost) =&gt; akumulator +=
                        vrednost)
                    </pre>
                </td>
                <td>
                    {niz.reduce(
                        (akumulator, vrednost) => (akumulator += vrednost)
                    )}
                </td>
            </tr>
            {/* Reduce uzme niz i pretvori ga u jednu vrednost tako što podesi vrednost nekakve promenljive 'akumulator' na prvi element i onda zove priloženu funkciju kojoj prosledi akumulator i svaki drugi element niza, redom. Ovde to koristimo da implementiramo sumiranje, ali može da se koristi za mnogo više od toga.*/}
        </table>
    );
};

const p04_klauzure = () => {
    let niz = [3, 1, 4, 1, 5, 9, 2, 6];
    let rez = [1, 2, 3];
    niz.forEach((value) => {
        //For each jednostavno izvrši neku funkciju za svaki element niza.
        if (value % 3 == 0) {
            rez.push(value); //Ovo je poenta zadatka. Ovo možda ne izgleda neobično ali uistinu jeste: Kako mi to u funkciji možemo da pristupimo vrednosti definisanoj u potpuno drugoj funkciji? One možda izgledaju fizički blizu, ali mogli smo da ovu funkciju prosledimo negde u neki niz i da ga tu čuvamo dugo pošto se funkcija i završila. Razlog što ovo može jeste što JS kompajler primeti da smo koristili nešto spolja i nevidljivo sve to prosledi u našu funkciju tako da imamo pristup. Srećom, ne moramo ništa da radimo da bi nam klauzura radila, dobijemo je besplatno, ali je bitno biti svestan.
        }
    });
    return <pre>{JSON.stringify(rez)}</pre>;
};

//Ovo je funkcija koja primi funkciju (i naziv) i vrati drugu funkciju koja poziva prvu funkciju (i prosledi joj sve parametre koje ima) ali pre i posle pozivanja ispiše na konzolni log (vidljiv ako u browser-u pritisnete F12: ovo mu dođe ekvivalent System.out.println()) da se funkcija startuje i kada se startuje.
const pretvori_u_log_funkciju = (funkcija, naziv) => {
    return (...x) => {
        console.log(`Startujem funkciju ${naziv} u ${Date()}`);
        let r = funkcija(...x);
        console.log(`Gotova funkcija ${naziv} u ${Date()}`);
        return r;
    };
};

const p05_funkcija_kao_povratna = () => {
    const log_zbir = pretvori_u_log_funkciju(saberi2, 'saberi2');
    return <pre>{log_zbir(3, 4)}</pre>;
};

const Funkcionalno = () => {
    return <div>{p05_funkcija_kao_povratna()}</div>;
};

export default Funkcionalno;
