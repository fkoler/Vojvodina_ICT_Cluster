/*
    Ovaj fajl je, kao što možete pomisliti, baš JavaScript. To je jezik koji je namenjen baš da se izvršava u okviru vašeg Web Browser softvera. Uprkos imenu (tehnički bi trebao da se zove 'ECMAScript' u stvari, ali ga skoro niko tako ne zove) nema baš mnogo veze sa Javom. Liče, naravno, ali to je više zbog porodične sličnosti sa programskim jezikom C. 
    
    Ovaj primer vas uči osnove kako da koristite ovaj jezik na efektan način. Da bi mogli da ga koristimo efektno, moramo da naučimo još par stvari pre nego što krenemo dalje. I dalje sa spoljašnjim svetom pričamo preko funkcije koja vraća HTML (tehnički, JSX) koja će uticati na ono što se prikaže. Ovde je to funkcija 'Osnove'. Ono što nam još treba da bih ove primere koristili udobno je sledeće:
        - Ovaj JSX/HTML je potpuno ravnopravan element jezika (nije standardan za JS sam po sebi, ali jeste ako imate moć React-a iza kulisa da vam pomaže) i može da sve vrati iz bilo koje funkcije i može da bude u bilo kojoj promenljivoj. 
        - Možemo umentnoti vrednost bilo kog JS izraza u JSX tako što ga napišemo između velikih zagrada. To kasnije radimo u više detalja, ali za sada je neophodno samo da znamo da to možemo da uradimo. 
        - JS poseduje funkcije i sintaksa (ona koju mi koristimo) za funkcije je 

        const ImeFunkcije = () => {
            // Ovde ide kod!
        }

        U onoj zagradi, () koju vidite idu argumenti funkcije, pričaćemo o tome detaljnije malo kasnije. 

    Naš plan je da svaki primer živi u svojoj funkciji i da mi vraćamo rezultat te funkcije iz 'Osnove' funkcije. Kod za to je:
        
        const Osnove = () => {
        return <div>
            {p01_promenljive()}
        </div>;
    
    Div služi da upakujemo bilo šta što vratimo. Do kraja časa ćete razumeti ovaj kod u potpunosti. 
    Da bi videli neki drugi primer samo treba da stavite umesto p01_promenljive nešto drugo. Ako već kojim slučajemo nešto znate o React-u, onda znate da imamo mnogo moćniji način da ovo uradimo, ali to za sada ne znamo. Biće kasnije. 
    
    Kao što ste primetili verovatno komentari u JS su apsolutno identični onima u Javi. Komentare jedino ne možete da pišete u okviru JSX-a. 
*/

const p01_promenljive = () => {
    /*
        Prva razlika u odnosu na Javu: Promenljive se prave sa komandom i to sa tri različite komande: var, let, i const. 
        let je ona koju koristimo većinu vremena, const pravi konstante (koje se ne mogu menjati, naravno), a var ćemo objasniti kasnije, ali je zastarela i ako je vidite u primeru na internetu postoji rizik da je to stariji primer koji vas neće naučiti dobrom JS-u. Čuvajte se! 
    */
    let broj = 700; 
    /*
        Druga razlika: Nema tipa! Kad napravite promenljivu (ili konstantu) vi joj samo date ime: tip je štagod da stavite u nju. Ovo je osobina (koju dele i drugi jezici, npr. Python) koja se zove 'dinamičko tipiziranje' 
        Ovo ne znači da ovde nema tipova: samo da ih definiše sadržaj. Ovde je tip 'Number' što je bilo šta što ima numeričku vrednost. JS Number tip objedinjuje i ono što je radio 'int' i ono što je radio 'double.'  
    */
    const pi = 3.1415926; //Ovo ne može da se promeni
    let tekst = "Abc"; //Stringovi se pišu u navodnicima, kao i u Javi: smemo koristiti i jednostruke i dvostruke navodnike
    let tekst2 = `Do sada imamo ${tekst} i ${broj}`; //Ako hoćemo u string da umetnemo razne vrednosti, možemo! Samo koristimo `` navodnike i onda u okviru njih stavimo ${} a u to stavimo bilo koji JS izraz, obično ime promenljive. Ovo je kao ono što radimo u okviru JSX sa {} zagradama, samo što je ovo za string, ne JSX. 
    let boolean = true; //Bool vrednosti su kao i u javi: 'true' i 'false' 
    /*
        Postoje i drugi tipovi koji se ili koriste ređe ili su nešto što razrađujemo kasnije. To su:
        Null - kao i u ostalim programskim jezicima, nepostojeća vrednost
        Undefined - neinicijalizovana promenljiva
        Object - Ovo su svi objekti o kojima više kasnije
        Symbol - jedinstvena vrednost koja nema namenu osim svog identiteta - namena je uglavnom sistemska i nas ne zanima previše. 
        Function - U JS-u funkcija može da bude u promenljivi, o ovome dosta više kasnije. 
    */
    broj = "800"; // Upozorenje: tip promenljive se menja u skladu sa promenom sadržaja. 

    /*
        Kao i u Javi promenljive imaju 'scope' odnosno opseg važenja. 'let' se ponaša baš kao što ste navikli u Javi: dakle promenljiva postoji u onom bloku u kome je definisana i svim pod-blokovima i to je to. 'var' se ponaša čudno: ima osobinu koja se zove 'hoisting' što znači da 'pobegne' iz bloka u kome je definisana i ponaša se kao da je napravljena u najvišem obujmljujućem bloku. 
    */
    let x = 'X: p01 scope'; // Ovo X onda važi u celoj ovoj funkciji
    let z = 'Z: ovaj Z je napravljen spolja'; // Ovo Z onda važi u celoj funkciji
    var y = 'Y: p01 scope'; //Ovo Y važi u celoj funkciji
    {
        let z = 'Z: unutarnji scope'; //Ovo Z važi samo u ovom bloku i neće pobeći iz njega. 
        var w = 'W: trebao bi biti unutarnji scope ali...'; //Ovo W hoće pobeći iz svog opsega kao da je napravljeno spolja.
    }
    return <table border={1}>
        <tr><td>{x}</td></tr>
        <tr><td>{y}</td></tr>
        <tr><td>{z}</td></tr>
        <tr><td>{w}</td></tr>
    </table>;
    // Lekcija? Nemojte koristiti var. Uvek koristite let i budite sumnjičavi prema primerima koji ga koriste. 
    // Podsetnik: Tabele se sastoje od tabele u okviru koje su redovi (tr) i u svakom redu ćelije (td), možete napraviti i poseban 'header' deo sa redom koji umesto 'td' ima 'th'. Tabele su samo za tabelarne podatke nikako da se rasporede elementi po stranici, imamo bolje sisteme za to. 
};

const p02_objekti = () => {
    //Evo iznenađenja: objekti u JS-u mogu da postoje nezavisno od klasa. Ako ste navikli na Javu ovo zvuči bizarno, ali iako JS ima klase (o kojima dosta kasnije) objekt za JS je pre svega kolekcija podataka koji su pod nekim imenima i to ne mora da ima nekakvo ime ili klasu iza sebe ako to ne želimo. Ovakvo ponašanje je moguće jer je Java statički tipiziran jezik a JS nije. 
    let p = {
        x: 0.73,
        y: 0.82
    };
    // Možda vam ovo izgleda jako poznato: ako vam ovo liči na JSON to nije ništa neobično, JSON bukvalno znači JavaScript Object Notation: dolazi odavde. To znači da sve što ste navikli da pišete u JSON-u radi i ovde uključujući i nizove i sve drugo baš kao što ste navikli samo što se ovde, tipično, ključevi pišu direktno bez zagrada. 
    let rect = {
        a: {
            x: 10,
            y: 10
        },
        b: {
            x: 20,
            y: 10
        },
        c: {
            x: 20,
            y: 20
        },
        d: {
            x: 10,
            y: 20
        },
    };
    // Naravno objekti mogu da sadrže i druge objekte: ovde smo napravili pravougaonik. 
    let d = Math.sqrt(p.x*p.x + p.y*p.y); // Pristupamo elementima baš kao i u Javi (sve u ovakvom objektu je javno). Math je gde žive matematičke funkcije. sqrt je kvadratni koren. 
    // Objekti imaju još jedan veoma lep trik koji mogu da urade, a to je destruktuiranje. Često imate objekat koji ima dosta podataka i vi hoćete da sa svima njima ili delovima radite direktno, kao sa promenljivama. To se može uraditi kroz destruktuiranje:
    let {x, y} = p; // Napravili smo nove promenljive x i y koje smo napunili sa x i y u objektu p. Ovo 'let' nije neophodno ako već imamo promenljive x i y spremne za upotrebu. 
    let d2 = Math.sqrt(x*x + y*y); 
    // Bez deklaracije 
    let p2 = {
        x: 703,
        y: 404
    };
    ({x, y} = p2); // Isto kao ranije samo što nema 'let' i što mora (iz tehničkih razloga) da se piše u zagradama.
    let d2_1 = Math.sqrt(x*x + y*y); 
    // Možemo i da damo vrednostima koje god ime želimo samo tako što kažemo JS-u kako hoćemo da se promenljiva zove i čemu odgovara:
    let {x: mojeImeA, y: mojeImeB} = p;
    let d3 = Math.sqrt(mojeImeA*mojeImeA + mojeImeB*mojeImeB); 
    // Možemo destruktuirati i kompleksnije objekte bez veće muke, samo ako repliciramo strukturu objekta kako treba:
    let {a: {x: ax, y: ay}, b: {x: bx, y: by}, c: {x: cx, y: cy}, d: {x: dx, y: dy}} = rect;
    let d4 = Math.sqrt((ax - cx)*(ax - cx) + (ay - cy)*(ay - cy)); // Ovo je dijagonala pravougaonika. 
    // Primetite da smo izvukli brdo podataka koje su potpuno beskorisni. Možemo destruktuirati samo one stvari koje nam trebaju. 
    let {a: {x: ax2, y: ay2}, c: {x: cx2, y: cy2}} = rect;
    let d5 = Math.sqrt((ax2 - cx2)*(ax2 - cx2) + (ay2 - cy2)*(ay2 - cy2));
    // Ponekad nam treba samo nešto specifično, ali bi da sačuvamo ostalo negde za svaki slučaj. Tu nam onda pomaže sintaksa sa ...
    let {a: {x: ax3, y: ay3}, c: {x: cx3, y: cy3}, ...ostalo} = rect;
    let d6 = Math.sqrt((ax3 - cx3)*(ax3 - cx3) + (ay3 - cy3)*(ay3 - cy3));
    // Sada u 'ostalo' živi sve što nismo destruktuirali. 
    return <table border={1}>
        <tr><th>Šta smo ekstrahovali</th><th>Vrednosti</th><th>D ako ima</th></tr>
        <tr><td>X i Y direkt iz p</td><td>{p.x}, {p.y}</td><td>{d}</td></tr>
        <tr><td>X i Y destruktuirano iz p</td><td>{x}, {y}</td><td>{d2}</td></tr>
        <tr><td>X i Y destruktuirano iz p2 bez pravljenja novih promenljivih</td><td>{x}, {y}</td><td>{d2_1}</td></tr>
        <tr><td>mojeImeA i mojeImeB destruktuirano iz p</td><td>{mojeImeA}, {mojeImeB}</td><td>{d3}</td></tr>
        <tr><td>A, B, C, i D destruktuirano iz rect</td><td>({ax}, {ay}), ({bx}, {by}), ({cx}, {cy}), ({dx}, {dy})</td><td>{d4}</td></tr>
        <tr><td>A, C destruktuirano iz rect</td><td>({ax2}, {ay2}), ({cx2}, {cy2})</td><td>{d5}</td></tr>
        <tr><td>A, C destruktuirano iz rect uz čuvanje ostalog</td><td>({ax3}, {ay3}), ({cx3}, {cy3})</td><td>{d6}</td></tr>
        <tr><td>Ono 'ostalo' </td><td><pre>{JSON.stringify(ostalo, null, 4)}</pre></td><td>Nema</td></tr>
    </table>;
    // Pošto je JSON 'domaći' ovde u JS-u, imamo odličnu podršku za rad sa njim. JSON je gde su relevantne funkcije. Stringify koji koristimo ovde je kako objekat postane JSON, a 'parse' je kako string koji sadrži JSON postaje objekat. Ovo 'null, 4' služi da bude lepo uvučen i koristimo ga kada hoćemo da JSON štampamo. Kada ga šaljemo nekoj drugoj mašini, onda nam ne treba. Razlog što smo sve ovo umotali u 'pre' jeste što tačno kažemo JSX/HTML mehanizmu da želimo da formatiranje teksta izgleda tačno kako smo otkucali. 
};

const p03_konverzije = () => {
    // Pošto je JS tako labav sa tipovima ostao nam je problem, šta ako tipovi interaguju? Onda JS pokuša da nam pomogne, ponekad ne kako bi mi hteli. 
    let a = "1234"; 
    let b = Number(a) + 1;  //Ovde konverziju tražimo eksplicitno: učini da a bude Number. 
    let c = a + 2; // Ovde puštamo da nam JS pomogne. 
    return <p>
        Promenljiva a je {typeof(a)} tipa. <br/>
        Promenljiva b je {typeof(b)} tipa i ima vrednost {b}. <br/> 
        Promenljiva c je {typeof(c)} tipa i ima vrednost {c}.
    </p>;
    // typeof, baš kao u Javi je način da saznamo kog je tipa nešto.
};

const p04_operatori = () => {
    /*Svi operatori na koje ste navikli u Javi su tu i rade kako očekujete. Jedina razlika jeste to što postoje operatori =, ==, i ===. Da to su tri znaka jednako. Evo šta rade:
        Operator    Šta radi                Mnemonik
        ====================================================
            =       Namešta vrednost        Jednako
            ==      Poredi uz konverziju    Jeste Jednako
                        tipova.
            ===     Poredi, ali strogo      Jako Jeste Jednako

        Dakle razlika je u tome da li poredimo da li su vrednost zaista identične (===) ili da li JS misli da su vrednosti ekvivalentne (==). Jedno jednako nema veza sa ovom pričom i služi za dodelu vrednosti (i podrazumevane vrednosti). 
    */
    let a = 123; // tip promenljive a je Number 
    let c = "123"; //promenljiva c je String 

    return <table border={1}>
        <caption> Poređenje - primer </caption>
        <tr><th> Poređenje sa '==' </th> <th>Rezultat</th> <th> Poređenje sa '===' </th> <th>Rezultat</th> </tr>
        <tr>
            <td> 0 == false </td> <td> {(0 == false) ? "true" : "false"} </td>
            <td> 0 === false </td> <td> {(0 === false) ? "true" : "false"} </td>
        </tr>
        <tr>
            <td> 1 == true </td> <td> {(1 == true) ? "true" : "false"} </td>
            <td> 1 === true </td> <td> {(1 === true) ? "true" : "false"} </td>
        </tr>
        <tr>
            <td> a == c </td> <td> {(a == c) ? "true" : "false"} </td>
            <td> a === c </td> <td> {(a === c) ? "true" : "false"} </td>
        </tr>
        <tr>
            <td> "" == false </td> <td> {("" == false) ? "true" : "false"} </td>
            <td> "" === false </td> <td> {("" === false) ? "true" : "false"} </td>
        </tr>
        <tr>
            <td> "0" == false </td> <td> {("0" == false) ? "true" : "false"} </td>
            <td> "0" === false </td> <td> {("0" === false) ? "true" : "false"} </td>
        </tr>
    </table>;
    /*
        Kao što se vidi iz ovog primera, jako veliki broj stvari, ako se porede sa == se smatraju jednakim iako u stvari nisu. To je zato što ih JS smatra, ako ne istim, onda ekvivalentnim, tj. konverzija među njima je moguća. Sa === može da se proveri istinski identitet. Naravno, kao što postoji == i != tako ima i === i !==. 

        Ovde koristimo jako korisni ternarni operator koji postoji i u Javi i predstavlja izraz (dakle ima neku vrednost na isti način na koji 2 + 2 ima vrednost) i ima sintaksu (uslov) ? a : b. Funkcioniše tako što se proveri uslov (što je bilo šta što JS zna da interpretira kao boolean) i ako je on istinit onda će izraz imati vrednost koju ima a, u suprotnom će imati vrednost koju ima b. Ovde smo to iskoristili da bi ispisali string 'true' ili 'false' u zavisnosti od toga da li je rezultat poređenja istinit ili ne. 
    */
};

const p05_kontrola_toka = () => {
    // Ovde (srećom!) nema mnogo šta da se kaže, kontrola toka je baš kakvu ste i navikli da koristite u Javi
    // Ista imena, ista funkcija
    // Jedina razlika jeste što u 'for' ne kucate čuveno int i nego let i. Sve ostalo radi baš kao što bi očekivali. 
    //IF petlja

    let a = 42;
    let if_res = "";
    if (a < 0) {
        if_res = "Uneli ste negativan broj (n < 0).";
      } else if (a === 0) {
        if_res = "Uneli ste 0 (n = 0).";
      } else if (a > 0 && a < 100) {
        if_res = "Uneli ste dvocifren broj (n < 100).";
      } else if (a >= 100 && a < 1000) {
        if_res = "Uneli ste trocifren broj (n < 1000).";
      } else {
        if_res = "Uneli ste broj koji je veci od 1000 (n >= 1000).";
    }
    a = "#0000FF";
    let case_res = "";
    switch (a) {
        case "#000000":
            case_res = "Crna";
            break;
        case "#0000FF":
            case_res = "Plava";
            break;
        case "#ffffff":
            case_res = "Bela";
            break;
        default:
            case_res = a + " nepoznata boja!";
    }
    
    a = 42;    
    let suma = 0;
    let c = 0;
    while (c < a) {
      suma += c;
      c++;
    }

    a = 10;
    let ispis = '';
    for (let i = 0; i < a; i++) {
        ispis += i + " ";
    }

    return <table border={1}>
        <tr><th>Primer</th><th>Rezultat</th></tr>
        <tr><td>If</td><td>{if_res}</td></tr>
        <tr><td>Case</td><td>{case_res}</td></tr>
        <tr><td>While</td><td>{suma}</td></tr>
        <tr><td>For</td><td>{ispis}</td></tr>
    </table>
}

const p06_nizovi = () => {
    /*
        Nizovi su manje kao niz u Javi a više kao ArrayList: dakle struktura podataka koja može da se menja potpuno slobodno: možemo uklanjati, dodavati, i premeštati elemente potpuno slobodno.
    */
    let n1 = [1, 2, 3, 4, 5, 6]; //Niz može da se napravi tako što se napuni unapred nekim vrednostima napisanim ručno: ovo se još zove i pravljenje kroz 'literal' 
    let n2 = new Array(); // Ovo napravi prazan niz: isto je kao da smo napisali = []
    let n3 = new Array(3); // Ovo napravi prazan niz, ali garantuje da u njemu imamo 3 elementa. Ona će, dok ih ne postavimo, da imaju vrednost 'null'
    let n4 = new Array(3).fill(101); //Ovo napravi niz sa 3 elementa gde svaki ima vrednost 101. 

    //Za razliku od Jave, nizovi mogu sasvim normalno da imaju i elemente različitih tipova. 
    let n5 = [1, 'abc', 3, true];

    //Ponekad hoćemo da napravimo niz koji se sastoji od elemenata neke druge strukture. Ovo možemo da uradimo koristeći Array.from
    let niz_od_teksta = Array.from("Lorem ipsum");
    // Ovaj trik radi na baš svemu kroz šta se može iterirati. 

    //Elementima niza pristupamo kao u Javi, i svaki niz ima osobinu .length koja daje dužinu
    let suma = 0;
    let n6 = [3, 1, 4, 1, 5, 9, 2 ,6];
    for(let i = 0; i < n6.length; i++){
        suma += n6[i];
    }

    // Niz ima i elegantniji način da se pristupi koristeći for-of konstrukciju
    let suma2 = 0;
    for(let e of n6){
        suma2 += e;
    }

    //For-of je ono što koristimo da bi prolazili kroz nizove. Naravno, ovo vraća elemente, šta ako hoćemo i element i indeks? Onda možemo da koristimo .entries() metodu koja vraća parove indeks-vrednost, ovako
    let ispis = "";
    for(let [index, element] of n6.entries()){
        ispis += `(${index}: ${element}) `;
    }

    //Ponekad imamo nešto u nizu, a voleli bi da to možemo da tretiramo kao da smo ga ispisali razdvojeno zarezima, tj, da ga otpakujemo iz niza i iskoristimo na nekom mestu. Ovo radi 'spread' operator nad nizovima koji se piše ovako ...niz. Najčešća primena je kad hoćemo da napravimo niz od drugih nizova. 
    let n7 = [n1, '909', n4]; //Ovo ne pravi niz sa elementima n1, pa 909, pa elementima n4. Umesto n1 i n4 će biti elementi niza n7, tj. priv element niza n7 neće biti 1 nego niz [1, 2, 3, 4, 5, 6]. Nekada to hoćemo, ali nekada i ne. 

    let n8 = [...n1, '909', ...n4]; //Ovim smo otpakovali vrednosti n1 i n4, i sada dobijamo niz koji ima kao priv element 1. 
    //Ovo može da bude i kompleksnije: spread operator radi praktično svuda gde nam trebaju vrednosti razdvojene zarezima, čak i kad zovemo funkcije i metode. Ako se setite da smo u jednom trenutku koristili JSON.stringify(obj, null, 4) da lepo ispišemo objekat? E pa, možemo to da uradimo i ovako: 
    let n9 = [n7, null, 4];
    let n7_ispis = JSON.stringify(...n9);

    //Nizove možemo i direktno da modifikujemo. Najčešći (ali ne jedini!) način da se modifikuje niz je da se elementi dodaju i uklanjaju sa početka ili kraja.
    let n10 = [1, 2, 3];
    n10.push(4);//Dodaje nešto na kraj
    n10.unshift(0);//Dodaje nešto na početak

    let n11 = [...n10];//Ovo pravi kopiju, da smo stavili n11 = n10 prošli bi baš kao i u Javi: imali bi dve stvari koje gledaju u jednu vrednost. 
    n11.pop();//Uklanja nešto sa kraja i vrati to što je uklonio. Ovo je forma destruktivnog čitanja. 
    n11.shift();//Uklanja nešto sa početka i vrati to što je uklonio. Ovo je forma destruktivnog čitanja. 

    // Ako želimo malo detaljniju hirurgiju nad nizom možemo da radimo slice i splice operacije. Slice napravi kopiju dela niza u skladu sa našim početnim i krajnjim indeksom, dok splice reže element iz niza i ubacuje nove na njihovo mesto. 
    let n12 = [1, 2, 3, 4, 5, 6];
    let n13 = n12.slice(2);//Jedan parametar znači da slice vrati sve od indeksa 2, pa na dalje
    let n14 = n12.slice(2, 4);//Ovo samo vraća indekse od 2 do 4 uključujući 2, ali ne i 4 
    
    let n15 = [...n12];
    let n16 = [...n12];
    let n17 = [...n12];
    n15.splice(1, 3); //Ovde počevši od indeksa 1 brišemo 3 elementa
    n16.splice(1, 0, ...n4); //Ovde počevši od indeksa 1 ubacujemo 3 elementa, ne brišemo ništa što nam kaže ovo 0. 
    n17.splice(1, 3, ...n4); //Ovde i brišemo i ubacujemo 3 elementa iz niza n4


    // Nizovi se mogu destruktuirati na baš isti način kao i objekti sa tim što je pozicija bitna (naravno) a imena nisu

    let [prvi, drugi, ...o1] = n12;

    return <table border = {1}>
        <tr><th>Šta se ispisuje</th><th>Vrednost</th></tr>
        <tr><td>n1</td><td>{JSON.stringify(n1)}</td></tr>
        <tr><td>n2</td><td>{JSON.stringify(n2)}</td></tr>
        <tr><td>n3</td><td>{JSON.stringify(n3)}</td></tr>
        <tr><td>n4</td><td>{JSON.stringify(n4)}</td></tr>
        <tr><td>n5</td><td>{JSON.stringify(n5)}</td></tr>
        <tr><td>Niz od teksta</td><td>{JSON.stringify(niz_od_teksta)}</td></tr>
        <tr><td>Suma n6</td><td>{suma}</td></tr>
        <tr><td>Suma n6 sa for-of</td><td>{suma2}</td></tr>
        <tr><td>N6 indeksi i vrednosti</td><td>{ispis}</td></tr>
        <tr><td>n7</td><td>{JSON.stringify(n7)}</td></tr>
        <tr><td>n8</td><td>{JSON.stringify(n8)}</td></tr>
        <tr><td>Ispis n7 kroz spread operator</td><td><pre>{n7_ispis}</pre></td></tr>
        <tr><td>n10 -- posle push i unshift</td><td>{JSON.stringify(n10)}</td></tr>
        <tr><td>n11 -- posle pop i shift</td><td>{JSON.stringify(n11)}</td></tr>
        <tr><td>n12</td><td>{JSON.stringify(n12)}</td></tr>
        <tr><td>n12.slice(2)</td><td>{JSON.stringify(n13)}</td></tr>
        <tr><td>n14.slice(2,4)</td><td>{JSON.stringify(n14)}</td></tr>
        <tr><td>n12.splice(1,3)</td><td>{JSON.stringify(n15)}</td></tr>
        <tr><td>n12.splice(1,0, ...n4)</td><td>{JSON.stringify(n16)}</td></tr>
        <tr><td>n12.splice(1, 3, ...n4)</td><td>{JSON.stringify(n17)}</td></tr>
        <tr><td>Prvi n12</td><td>{prvi}</td></tr>
        <tr><td>Drugi n12</td><td>{drugi}</td></tr>
        <tr><td>Ostalo</td><td>{JSON.stringify(o1)}</td></tr>
    </table>;
};

const p07_mape = () => {
    /*
        Možete postaviti pitanje, ako imamo objekte šta će nam onda još i mapa? U Javi objekat mora da nastane od klase, a HashMap može da dobija i gubi ključeve kako god hoće. Kakva je situacija ovde? Iako vi možete dodavati i brisati ključeve objektu, ovo je loša ideja. Objekti su tu da budu ili produkti klasa (kasnije) ili da jednostavno čuvaju vrednosti koje idu zajedno. Ako vam treba mapa kao struktura podataka, ako planirate da ubacujete i brišete ključeve i iterirate po njima, e onda vam treba Map. Srećom, lako se koristi. 
    */
    let m = new Map();
    m.set('abc', 117); //Koristi se .set da se namesti vrednost ma kojeg ključa
    m.set(904, 'def'); //Ključ i vrednost mogu biti bilo kog tipa koji nije konstantan u okviru mape
    m.set('ima_kljuc_904', m.has(904)); //sa .has možemo da proverimo da li ima neki ključ u mapi ili ne
    m.set(905, 'ghi'); 
    m.delete(905); // Sa .delete možemo da obrišemo bilo koji ključ
    let ispis = ""; 
    for(let [k, v] of m){ //for-of iterira po parovima ključ-vrednost naše mape. Možemo iterirati samo po ključevima ako umesto m stavimo m.keys() ili samo po vrednostima ako stavimo m.values()
        ispis += `pod ${k} ima ${v}\n`;
    }
    /*
        Ako nam samo treba odgovor na pitanje da li je nešto u nekom skupu ili ne, možemo da koristimo Set. Set je kao mapa bez vrednosti. 
    */
    let s = new Set();
    s.add('abc');//Dodajemo ne sa .set nego sa .add
    s.add(904);
    s.clear(); //Imamo brzo pražnjenje celog skupa
    s.add('bcd');
    s.add(s.has('bcd')); //Kao i za mapu, .has proverava prisustvo.
    let ispis2 = "";
    for(let k of s){
        ispis2 += `S ima ${k}\n`
    }

    return <div>
        <h1>Mapa</h1>
        <pre>
            {ispis}
        </pre>
        <h1>Set</h1>
        <pre>
            {ispis2}
        </pre>
    </div>;
}

const p08_regexp = () => {
    /*
        Regularni izrazi su, plus-minus, apsolutno isti kao oni koje ste koristili u Javi. To je lepa stvar, inače, sa regularnim izrazima, ako ih naučite jednom, možete da ih koristite u praktično svakom programskom jeziku. Lepa razlika jeste što JS podržava direktno kucanje regularnih izraza: ne u stringu nego u direktnom formatu između kosih crta, sa flag-ovim odmah iza. Ovo čini kucanje regularnih izraza jako udobno. 
    */
   let str1 = "Petar,Petrovic,A=100&B=200";
   let str2 = "Petar,Petrovic,A=100&B=200\nZorana,Zoranovic,Q=70&R=44";
   let re = /(.+),(.+),([A-Z])=(\d+)&([A-Z])=(\d+)/; //Ovo je izraz koji kaže da očekujemo jedan ili više bilo kog karaktera (i da hoćemo da zapamtimo te karaktere), pa zarez, pa jedan ili više karaktera (koje pamtimo) pa zarez, pa jedno veliko slovo (koje pamtimo), pa znak za jednakost, pa jedan ili više brojeva, koje pamtimo, i onda znak ampersand, pa jedno veliko slovo (koje pamtimo) pa znak jednakosti, pa jedan ili više brojeva koje pamtimo. 
   let reg = /(.+),(.+),([A-Z])=(\d+)&([A-Z])=(\d+)/g; //Ovo je isti regexp, samo što je uključen flag globalnosti: to znači da nas ne zanima __prvi__ put gde smo otkrili šablon, no svaki put. 
   //Kada hoćemo da nađemo samo jedno poklapanje, možemo da koristimo .match metodu stringa ovako:
   let ispis = [];
   let m = str1.match(re);
   ispis[0] = <tr><td>{`Tekst celog poklapanja: ${m[0]}, prva grupa pamćenja: ${m[1]}, druga grupa pamćenja: ${m[2]}, treća grupa pamćenja: ${m[3]}, četvrta grupa pamćenja: ${m[4]}, peta grupa pamćenja: ${m[5]}, šesta grupa pamćenja: ${m[6]}`}</td></tr>;
   //match će vratiti niz gde je prvi element sve u stringu što odgovara našem izrazu, a onda redom svaka 'capture group' odnosno grupa za pamćenje vrednosti. Ovde će to biti Petar, Petrovic, A, 100, B, 200
   let m2 = str2.matchAll(reg); //sve što matchAll uradi (očekuje Regexp sa 'g' flagom) jeste vrati listu svih poklapanja gde je svaki element kao ono što vrati .match
   let i = 0;
   for(m of m2){
    ispis[i + 1] = <tr><td>{`Za poklapanje ${i + 1} tekst celog poklapanja: ${m[0]}, prva grupa pamćenja: ${m[1]}, druga grupa pamćenja: ${m[2]}, treća grupa pamćenja: ${m[3]}, četvrta grupa pamćenja: ${m[4]}, peta grupa pamćenja: ${m[5]}, šesta grupa pamćenja: ${m[6]}`}</td></tr>;
    i++;
   }

   //Ovo kako smo ovo uradili je OK i regularni izrazi se koriste sve vreme, ali ovakav specifičan problem se može rešiti i lukavom primenom operacije 'split' koja vraća delove stringa koji su razdvojeni 'separatorskim' stringom koji mi damo. Imao i obrnutu operaciju, join, koja spaja niz u jedan string razdvojen separatorom. 
   let linije = str2.split("\n");
   for(let linija of linije){
    let [ime, prezime, brojke] = linija.split(",");
    let [prva, druga] = brojke.split("&");
    let [pk, pv] = prva.split("=");
    let [dk, dv] = druga.split("=");
    ispis.push(<tr><td>Ime: {ime}, prezime: {prezime}, {pk}={pv}, {dk}={dv}</td></tr>);
   }
   
   return <table border={1}>
    {ispis}
   </table>
   //React je dovoljno pametan da zna, kada mu damo listu elemenata koje su sve JSX da ih ispiše redom, u našem slučaju to su redovi ove tabele. 
}

const Osnove = () => {
    return <div>
        {p08_regexp()}
    </div>;
};
    
export default Osnove;
