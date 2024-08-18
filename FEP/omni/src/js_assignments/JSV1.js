/* 
    Veliki Zadatak 1
    Napiši funkciju koja prima ulazni niz proizvoljne dužine i sortira ga. 
*/

const niz = [2, 8, 5, 12, 7, -13, 9, 17, -20];

const zad1 = () => {
    console.log('Zadati niz:', niz);

    // Veliki Zadatak 1: Sortiranje niza
    const sortiraniNiz = [...niz].sort((a, b) => a - b);
    console.log('Sortirani niz:', sortiraniNiz);

    // Zadatak 1: Proći kroz niz elemenata i ispisati sve parne elemente
    const parniElementi = sortiraniNiz.filter((el) => el % 2 === 0);
    console.log('Parni elementi:', parniElementi);

    // Zadatak 1.1: Dodati pronađene parne elemente u novi niz elemenata i ispisati taj novi niz
    const noviNizParnihElemenata = [...parniElementi];
    console.log('Novi niz parnih elemenata:', { noviNizParnihElemenata });

    // Zadatak 1.2: Dodati pronađene parne elemente u novi niz elemenata ali u suprotnom redosledu
    const obrnutiNizParnihElemenata = [...parniElementi].reverse();
    console.log('Obrnuti niz parnih elemenata:', obrnutiNizParnihElemenata);
};

// zad1();

// +++++++++++++++++++++++++++++

const zad3 = () => {
    /*
    Napraviti mini program za logovanje korisnika. Korisnika predstaviti kao objekat koji
    ima atribute: ime, prezime, korisničko ime i šifru. Sve korisnike smestiti u mapu gde
    je ključ korisničko ime, a vrednost objekat koji predstavlja korisnika. Zatim napraviti
    dve promenljive koje predstavljaju korisničko ime i lozinku i dodeliti im neku vrednost.
    Na osnovu korisničkog imena i lozinke pokušati da ulogujete korisnika, ako je
    logovanje uspešno ispisati podatke o korisniku, a ako nije napisati poruku ‚‚Pogrešno
    korisničko ime ili šifra‚‚.
    */

    const korisnici = new Map();

    korisnici.set('korisnik1', {
        ime: 'Marko',
        prezime: 'Kraljević',
        korisnickoIme: 'korisnik1',
        sifra: 'sifra123',
    });
    korisnici.set('korisnik2', {
        ime: 'Jug',
        prezime: 'Bogdan',
        korisnickoIme: 'korisnik2',
        sifra: 'sifra456',
    });

    const unesenoKorisnickoIme = 'korisnik1';
    const unesenaSifra = 'sifra123';

    const logovanje = (korisnickoIme, sifra) => {
        if (korisnici.has(korisnickoIme)) {
            const korisnik = korisnici.get(korisnickoIme);
            if (korisnik.sifra === sifra) {
                console.log('Uspešno logovanje:', korisnik);
            } else {
                console.log('Pogrešno korisničko ime ili šifra');
            }
        } else {
            console.log('Pogrešno korisničko ime ili šifra');
        }
    };

    logovanje(unesenoKorisnickoIme, unesenaSifra);
};

// zad3();

// +++++++++++++++++++++++++

const zad4 = () => {
    /*
    Od niza elemenata napraviti dva niza. Jedan niz treba da budu elementi koji se
    nalaze na parnim indeksima a njihova vrednost je neparan broj, a drugi elementi koji
    se nalaze na neparnim indeksima a njihova vrednost je paran broj.
    */

    console.log('Zadati niz:', niz);

    const parniIndeksiNeparniBrojevi = niz
        .map((el, index) => (index % 2 === 0 && el % 2 !== 0 ? el : null))
        .filter((el) => el !== null);

    const neparniIndeksiParniBrojevi = niz
        .map((el, index) => (index % 2 !== 0 && el % 2 === 0 ? el : null))
        .filter((el) => el !== null);

    console.log(
        'Elementi na parnim indeksima sa neparnim vrednostima:',
        parniIndeksiNeparniBrojevi
    );
    console.log(
        'Elementi na neparnim indeksima sa parnim vrednostima:',
        neparniIndeksiParniBrojevi
    );
};

// zad4();

// +++++++++++++++++++++++++

const zad5 = () => {
    /*
    Iz sledećeg teksta pomoću regularnog izraza izdvojiti sve e-mail adrese.
    Tekst: Petar Petrović ima naloge na nekoliko servisa koji omogućavaju razmenu
    poruka. Njegove adrese su pera.petrovic@gmail.com, petar@uns.ac.rs i
    petrovic@yahoo.com. Mina Mirković takođe ima nekoliko e-mail adresa. Za
    komunikaciju sa Petrom koristi adresu mina90.m@hotmail.com.
    */

    const tekst = `
    Petar Petrović ima naloge na nekoliko servisa koji omogućavaju razmenu
    poruka. Njegove adrese su pera.petrovic@gmail.com, petar@uns.ac.rs i
    petrovic@yahoo.com. Mina Mirković takođe ima nekoliko e-mail adresa. Za
    komunikaciju sa Petrom koristi adresu mina90.m@hotmail.com.
  `;

    const emailRegex = /[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}/g;

    console.log('Izdvojene e-mail adrese:', tekst.match(emailRegex));
};

// zad5();

// +++++++++++++++++++++++++

const zad6 = () => {
    /*
    Napraviti program koji na osnovu podataka o pravougaoniku računa: dijagonalu,
    stranice pravougaonika, površinu i obim. Pravougaonik je predstavljen kao objekat
    koji za atribute ima koordinate temena. Koristiti destrukturiranje podataka.
    Primer:
    let pravougaonik = {
    A { x: 10, y: 30},
    B { x: 30, y: 30},
    C { x: 30, y: 45},
    D { x: 10, y: 45}
    }
  */

    const pravougaonik = {
        A: { x: 10, y: 30 },
        B: { x: 30, y: 30 },
        C: { x: 30, y: 45 },
        D: { x: 10, y: 45 },
    };

    const { A, B, C, D } = pravougaonik;

    const stranicaAB = Math.sqrt((B.x - A.x) ** 2 + (B.y - A.y) ** 2);
    const stranicaAD = Math.sqrt((D.x - A.x) ** 2 + (D.y - A.y) ** 2);

    const dijagonala = Math.sqrt((C.x - A.x) ** 2 + (C.y - A.y) ** 2);

    const povrsina = stranicaAB * stranicaAD;
    const obim = 2 * (stranicaAB + stranicaAD);

    console.log(`Dijagonala: ${dijagonala}`);
    console.log(`Stranica AB: ${stranicaAB}`);
    console.log(`Stranica AD: ${stranicaAD}`);
    console.log(`Površina: ${povrsina}`);
    console.log(`Obim: ${obim}`);
};

// zad6();

// +++++++++++++++++++++++++

const zad7 = () => {
    // Za dati niz elemenata izračunati: zbir, srednju vrednost i proizvod.

    const zbir = niz.reduce((acc, val) => acc + val, 0);

    const srednjaVrednost = zbir / niz.length;

    const proizvod = niz.reduce((acc, val) => acc * val, 1);

    console.log(`Zbir: ${zbir}`);
    console.log(`Srednja vrednost: ${srednjaVrednost}`);
    console.log(`Proizvod: ${proizvod}`);
};

// zad7();

// +++++++++++++++++++++++++

const zad8 = () => {
    /*
    Za dati niz elemenata pronaći element u nizu koji se najčešće pojavljuje.
    Primer niza: arr1=[3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3]
    */

    const arr1 = [3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3];

    const countMap = arr1.reduce((acc, val) => {
        acc[val] = (acc[val] || 0) + 1;
        return acc;
    }, {});

    const countArray = [];

    for (const key in countMap) {
        if (countMap.hasOwnProperty(key)) {
            countArray.push([key, countMap[key]]);
        }
    }

    countArray.sort((a, b) => b[1] - a[1]);

    const totalElements = arr1.length;

    for (const [key, count] of countArray) {
        const percentage = ((count / totalElements) * 100).toFixed(2);
        console.log(
            `Element: "${key}" se pojavljuje ${count} puta (${percentage}%)`
        );
    }
};

// zad8();

// +++++++++++++++++++++++++

const zad9 = () => {
    /*
    Proći kroz dati niz elemenata i ispisati imena i prezime studenata.
    let studenti = [
    {indeks: "XY 409/2072", ime: "Alice", prezime: "Alferson"},
    {indeks: "ZW 133/2072", ime: "Bob", prezime: "Bobbert"},
    {indeks: "XY 112/2073", ime: "Carol", prezime: "Creed"},
    {indeks: "XY 507/2071", ime: "Drew", prezime: "Danger"},
    {indeks: "ZW 233/2070", ime: "Eve", prezime: "Emmerson"},
    {indeks: "ZW 57/2072", ime: "Trent", prezime: "Tweed"},
    {indeks: "XY 111/2071", ime: "Fred", prezime: "Franks"},
    {indeks: "ZW 404/2073", ime: "George", prezime: "Green"}
    ];
    */

    let studenti = [
        { indeks: 'XY 409/2072', ime: 'Alice', prezime: 'InChains' },
        { indeks: 'ZW 133/2072', ime: 'Bob', prezime: 'Rock' },
        { indeks: 'XY 112/2073', ime: 'Carol', prezime: 'Burnett' },
        { indeks: 'XY 507/2071', ime: 'Drew', prezime: 'Barrymore' },
        { indeks: 'ZW 233/2070', ime: 'Eve', prezime: 'Online' },
        { indeks: 'ZW 57/2072', ime: 'Trent', prezime: 'Raznor' },
        { indeks: 'XY 111/2071', ime: 'Fred', prezime: 'Mercury' },
        { indeks: 'ZW 404/2073', ime: 'George', prezime: 'Martin' },
    ];

    const ispis = studenti.map(
        (student) => `Ime: ${student.ime}, Prezime: ${student.prezime}`
    );

    console.log(ispis.join('\n'));
};

// zad9();

const zad10 = () => {
    /*
    Ispisati sve stringove koji se pojavljuju u sledećem nizu elemenata: [1, 34, ‘1’, ‘abc’, 347, ‘false’, ‘s’, 123]
    */

    const nizZad10 = [1, 34, '1', 'abc', 347, 'false', 's', 123];

    // const stringovi = nizZad10.filter((element) => typeof element === 'string');

    const stringovi = nizZad10.reduce((acc, element) => {
        if (typeof element === 'string') {
            acc.push(element);
        }

        return acc;
    }, []);

    console.log('Stringovi u nizu:', stringovi);
};

// zad10();

// +++++++++++++++++++++++++

const JSV1 = () => {
    // return <div>{zad1()}</div>;
};

export default JSV1;
