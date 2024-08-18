/*
    Nismo mnogo pričali o ovome ranije (iako smo to koristili) ali kod u JS-u može da se 'pakuje' u nešto što se zovu 'moduli.' Ovo je namenjeno da kod koji ste napisali na jednom mestu možete da koristite na više mesta. Koristili ste nešto veoma slično u Javi i ovde to operiše na gotovo isti način i ima apsolutno istu namenu. 

    Module i pišete vi (ako hoćete, na primer, da stavite svo rukovanje sa udaljenim izvorom podataka na jedno mesto i koristite ga stalno), ali još bitnije, koristite postojeće module koji su objavljeni online. Moduli u JS-u se dobijaju tako što ih preuzmete sa centralnog repozitorijuma koji je vezan za NPM alat koji smo koristili do sada. Ovo funkcioniše neobično kao Maven sa kojim već imate nešto iskustva. Umesto Pom.xml mi imamo package.json, specifično ovaj deo:

      "dependencies": {
    "@testing-library/jest-dom": "^5.16.5",
    "@testing-library/react": "^13.4.0",
    "@testing-library/user-event": "^13.5.0",
    "react": "^18.2.0",
    "react-dom": "^18.2.0",
    "react-router-dom": "^6.8.2",
    "react-scripts": "5.0.1",
    "web-vitals": "^2.1.4"
  },

  Tu vidite da koristimo nekoliko biblioteka od kojih su najbitnije 'react,' 'react-dom', 'react-router-dom' i 'react-scripts'. Naravno ove biblioteke koriste druge biblioteke koje koriste treće biblioteke i tako dalje. Ovaj projekat u trenutku pisanja ovog komentara zavisi od ne manje od 822 različitih bibloteka (tipično JS ime je 'paket'). 

  Osim što navedemo ime bibloteke, posle toga idu jedna ili više oznaka raspona verzije koji se sastoje od neke oznake verzije koja poštuje standard koji se zove SemVer plus mehanizam za određivanje raspona. To znači da moramo da razumemo dve stvari: SemVer i sintaksu za oznaku raspona verzija. 

  SemVer je standard za određivanje verzija softvera. Naziv predstavlja skraćivanje englskog Semantic Versioning odnosno semantičko verzionisanje. Pravila SemVer-a su:
    1. Verzija se sastoji od MAJOR, MINOR, i PATCH broja razdvojenih tačkama praćenim, opciono, sa specifikacijom međuverzije koja ide posle znaka -, praćeno, opciono, sa znakom plus i metapodacima vezanim za proces kompajliranja softvera. Mi se fokusiramo isključivo na najbitnije MAJOR, MINOR, i PATCH vrednosti. 
    2. Sve brojke su nula ili pozitivne i konsekutivne (tj. nema preskakanja)
    3. Svaka promena na softveru mora dovesti do promene verzije. 
    4. PATCH vrednost se koristi kada je promena interna (tj. ne utiče na stvari koje vi importujete i kako ih koristite uopšte) i sve što radi je menja netačno ponašanje u tačno, tj. ispravlja bag. 
    5. MINOR vrednost se koristi kada se dodaje funkcionalnost, ali se ne menja ništa od ponašanja koje je definisano ranije, tj. kaže se da je promena _kompatibilna_ sa ranijim kodom. Dakle, menja se šta importujete i kako ga koristite, ali samo tako što sada može da radi i neke nove stvari: i dalje rade sve stare stvari i na isti način. 
    6. MAJOR vrednost se koristi kada se menja ponašanja na način koji nije kompatibilan: drugim rečima, menja se kako rade stvari koje importujete i kako koristite: nešto što je ranije moglo, više ne može, ili ne može kako je ranije moglo. 
    7. Iz ovoga sledi da promene na MINOR i PATCH nivou ne utiču na to da li će i dalje da radi kod koji ste napisali ranije, dok promene na MAJOR nivou mogu, ali ne moraju imati ovaj uticaj. 
    8. MAJOR verzija 0 ima posebno značenje i ukazuje da je kod i dalje u primarnom razvoju i da njegovo ponašanje nije stabilno: može se promeniti u bilo kom trenutku, sa bilo kom verzijom. 
 
Sintaksa raspona verzija jeste da posle imena biblioteke mi stavimo jedan ili više komparatora (kako se zovu) razdvojenih razmacima ili simbolom ||, i raspon verzija određuje presek svih dozvoljenih verzija koje određuju komparatori ili skupovi komparatora spojenih sa ||. U praksi se ova kompleksnija sintaksa koristi ekstremno retko, i sve što treba da znate je kako da opišete jedan jedini komparator. Komparator može da se sastoji od:
  * Direktnog raspona verzija oblika 1.2.3 - 2.3.4 što obuhvata sve verzije između ove dve, uključujući i tu. 
  * Mehanizma zvezdica oblika 1.2.* što obuhvata sve verzije koje počinju sa 1.2. Kao i obično '*' znači 'bilo šta' 
  * Mehanizma operatora praćenog verzijom: ovo je slučaj gde se SemVer verzija (koja može biti nekompletna i kompletna, tj. 1.2 ili 1 ili 1.2.3 su sve validne) ispred seme ima nekakav operator (npr. ^). Operatori znače:
    - Operator > obuhvata sve veće verzije
    - Operator >= obuhvata sve veće verzije i navedenu verziju
    - Operator < obuhvata sve manje verzije
    - Operator <= obuhvata sve manje verzije i navedenu verziju
    - Operator = obuhvata samo navedenu verziju
    - Operator ~ znači "otprilike ista verzija" tako da ~1.2.3 znači sve verzije veće ili jednake 1.2.3 a manje od  1.3.0, ~1.2 znači sve verzije veće ili jednake 1.2.0 a manje od 1.3.0, dok ~1 znači sve verzije veće ili jednake 1.0.0 a manje od 2.0.0 
    - Operator  ^ je najznačajniji i najčešće u upotrebi i znači "mogu veće verzije dok god se ne očekuje da će da slome pređašnji kod". Formalno pravilo je "Navedena verzija i sve veće koje ne modifikuju najlevlju ne-nultu vrednost." To znači da, recimo, u navedenom ^18.2.0 u stvari znači veće ili jednako 18.2.0, a manje od 19.0.0. Veliku većinu vremena, ovo je tačno ono što želite. 

Ako želite nov paket prvo identifikujete onaj koji vam treba, nađete ka na npm repozitorijumu, i ili dodate verziju koju želite u dependencies ili, što je češće, izvršite komandu za instalaciju koja je npm i ime-paketa. Ta komanda je zgodno navedena na stranici paketa, npr. https://www.npmjs.com/package/react. 

VODITE RAČUNA: NPM repozitorijum NIJE UVEK BEZBEDAN. Mnogo puta je pronađen maliciozan softver na njemu koji ili pokušava da vas prevari da je validna biblioteka, ili ima ime vrlo slično validnoj biblioteci i pokuša da vas prevari kada nešto pogrešno otkucate. Molim vas budite vrlo pažljivi. Mogu pomoći alati kao što je, npr. https://snyk.io/advisor/, ali generalno govoreći, treba da budete ekstremno pažljivi i konzervativni sa instalacijom paketa, naročito na vaše lične računare. 
*/
import {f, g, THE_ANSWER} from './Modul1'; //Sintaksa je vrlo jednostavna: samo navedemo u velikim zagradama šta hoćemo da uvezemo iz nekog modula: taj modul može biti specificiran samo imenom (to znači da je to modul koji smo instalirali NPM-om) ili putanjom (Ovde to znači 'Fajl Modul1.js u tekućem direktorijumu). Možemo uvesti bilo šta: konstante, funkcije, klase... 
//import {h} from './Modul1'; //Ograničenje je to što ono što importujemo ovde mora da je eksportovano tamo odakle ga importujemo. Ako nije, program neće raditi. Ovo je zakomentarisno zato što 'h' nije eksportovan.  
import {x, f as m2_f} from './Modul2'; //Ponekad nam ne odgovara neko ime u nekom modulu: u ovom slučaju i Modul1 i Modul2 imaju nešto što se zove 'f' i to ne možemo da importujemo zato što onda sistem neće znati da li mislimo f iz Modul1 ili f iz Modul2. Stoga ima ključna reč: 'as' kojom kažmo da 'f' iz Modul2 uvozimo pod imenom 'm2_f' 
import * as Modul3 from './Modul3'; // Ponekad ne želimo da se bavimo masovnim preimenovanjem: tada možemo da importujemo sve iz nekog modula sa prefiskom tog modula: Ovde smo importovali sve što Modul3 ima ali tako da mu pristupamo tako što kažemo Modul3.ime-eksportovane-stvari. 
import funckija_iz_modula_4 from './Modul4'; //Moduli mogu da imaju 'podrazumevanu funkciju' (koju ste videli kako specificiramo beskonačno puta). To znači kada importujemo nešto iz tog modula, bez ičega i bez velikih zagrada dobijemo to što je 'podrazumevano.' Ovo nije neophodno koristiti: uglavnom je tu za kompatibilnost sa nekim, starijim, standardima modularizacije. 

const PrimerModula = () => {
    return <div>
        <h3>{f()}</h3>
        <hr></hr>
        <h3>{g()}</h3>
        <hr></hr>
        <h3>Odgovor je {THE_ANSWER}</h3>
        <hr></hr>
        <h3>{x()}</h3>
        <hr></hr>
        <h3>{m2_f()}</h3>
        <hr></hr>
        <h3>{Modul3.y()}</h3>
        <hr></hr>
        <h3>{Modul3.z()}</h3>
        <hr></hr>
        <h3>{funckija_iz_modula_4()}</h3>
        <hr></hr>
    </div>
}

export default PrimerModula;