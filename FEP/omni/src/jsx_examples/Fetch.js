import { useState, useEffect } from 'react';

/*
    Vreme je da integrišemo back-end sa front-end-om. Tehnika je ekstremno jednostavna: Kao što ste podešavali Postman da šalje stvari na razne end-point-e tako podesite jedan ugrađen alat (Fetch API se zove) i pošaljete zahtev i dešifrujete i koristite odgovor. Jedino što čini ovo komplikovanim jeste par detalja.  
*/

/*
 Ako hoćemo da nešto preuzmemo samo nam treba 'fetch' čiji je jedini parametar url koji treba preuzeti i podrazumevano će uraditi običan GET na taj url i vratiti rezultat. Jedina komplikacija jeste to što fetch ne vraća direktno rezultat. Preuzimanje stvari online oduzima vreme i kao rezultat fetch može da traje mnogo duže nego što je to tipično za pozive funkcija. Kao rezultat to je tkzv. *asinhrona* funkcija koja vraća ne podatke nego nešto što se zove 'Promise' objekat. Objekat koji kaže "ovde će možda jednom biti vrednost koja ti treba." To ne može da se koristi direktno nego se mora posebno obraditi. Svaki Promise može biti odbijen ili resolve-ovan: ako je odbijen, nešto je pošlo naopako, ako je uspeo, onda je resolve-ovan, i možemo da obradimo rezultat. Ovde ja smestim prvi promise u promenljivu i onda pozovem 'then' To then, odnosno funkcija koju prosledimo, će se izvršiti kada se promise ispuni i dobiće kao parametar sadržaj ispunjenog obećanja. Mi tu proverimo da li to što je stiglo je ok i ako jeste vratimo rezulat poziva .json() metode što dekodira payload fajla i takođe je obećanje. Direktno onda na to obećanje mi podesimo još jedno .then() koje se izvrši tek kada su tu podaci dekodiranja koje stavimo u našu promenljivu stanja. Ako mi detektujemo grešku u prvom 'then' mi vratimo isto Promise ali ovaj put Promise koji je ustartu odbijen koristeći Promise.reject. Bilo koje odbijanje bilo kog obećanja u lancu izazove da se izvrši ono što je prosleđeno 'catch' metodi. 
 */

const Example1 = () => {
    const [data, setData] = useState(null);
    return (
        <div>
            <pre>{JSON.stringify(data, null, 4)}</pre>
            <button
                onClick={() => {
                    let result = fetch('http://localhost:8080/api/v1/book/11');
                    result
                        .then((val) => {
                            if (val.ok) {
                                return val.json();
                            }
                            return Promise.reject(
                                `Fetch nije uspeo sa kodom ${val.status}.`
                            );
                        })
                        .then((d) => setData(d))
                        .catch((err) => console.log(err));
                }}
            >
                GET
            </button>
        </div>
    );
};

/*
Rad sa lancima .then ova zna da bude naporan, stoga ima elegantniji način da se realizuje slično ponašanje. Ako definišemo da nam je _naša_ funkcija asinhrona (što radimo tako što stavimo 'async' ispred zagrada za parametre) dobijemo pristup 'await' ključnoj reči. Ovo znači da će se izvršavanje suspendovati (ne blokirati!) dok podaci ne stignu ili se obrada ne završi. Await jednostavno pretvori promise u ono što taj promise obećava.
*/

const Example2 = () => {
    const [data, setData] = useState(null);
    return (
        <div>
            <pre>{JSON.stringify(data, null, 4)}</pre>
            <button
                onClick={async () => {
                    let result = await fetch(
                        'http://localhost:8080/api/v1/book/11'
                    );
                    if (result.ok) {
                        let d = await result.json();
                        setData(d);
                    } else {
                        console.log(
                            `Fetch nije uspeo sa kodom ${result.status}`
                        );
                    }
                }}
            >
                GET
            </button>
        </div>
    );
};

/*
Naravno rade i stvari koje nisu GET. fetch prima drugi parametar koji je objekat koji služi za podešavanje svih detalja što uključuje metod (ovde POST), zaglavlja, i naravno telo. Ovaj primer takođe demonstrira elegantno kako možemo da koristimo polja forme u okviru React-a. Input polje je tako napravljeno da uvek pokazuje trenutno stanje, ali da pokušaji da se promeni vrednost izazovu promenu stanja. Rezultat je da korisnik slobodno kuca šta želi, a da mi uvek u promenljivoj stanja imamo tekuću ukucanu vrednost.
*/

const Example3 = () => {
    const [txt, setTxt] = useState('');
    return (
        <div>
            <label>
                Ime žanra:{' '}
                <input value={txt} onChange={(e) => setTxt(e.target.value)} />
            </label>
            <br />
            <button
                onClick={async () => {
                    let response = await fetch(
                        'http://localhost:8080/api/v1/genre',
                        {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify({
                                name: txt,
                            }),
                        }
                    );
                    if (response.ok) {
                        let d = await response.json();
                        console.log(JSON.stringify(d, null, 4));
                    } else {
                        console.log('Neuspeh slanja!');
                    }
                }}
            >
                Napravi novi
            </button>
        </div>
    );
};

/* 
Do sada smo uvek radili fetch u okviru obrađivača događaja što je dobro ako, npr dodajemo nešto ili obavljamo REST pozivom bilo kakvu specifičnu akciju. Ponekad želimo da podaci uvek budu dostupni, tj. da ih preuzmemo sekunda kada se prikaže naša komponenta. Za to se koristi useEffect koristeći navedenu strukturu. Molim primetite da imamo asinhronu unutarnju funkciju koju zovemo da odradi posao samog povezivanja i dekodiranja podataka. Primetite, takođe, da vraćamo funkciju iz naše useEffect funkcije: ovo služi ako moramo da prekinemo učitavanje zato što rezultat više nije validan. To radimo tako što jednostavno imamo promenljivu ignore koja nam kaže da treba da preuzete podatke bacimo. Molim obratite pažnju da ovde operišemo sa dvostrukom klauzurom: ignore je definisan u funkciji koju smo obeležili sa 'A' ali se tu ne koristi. Umesto toga klauzurom on je dostupan funkcijama B i C koje koriste tu vrednost da, efektivno, komuniciraju. Ignore će postati true ako React odluči da pozove cleanup funkciju u nekom trenutku, kada god to bilo, a to će uticati na asinhronu funkciju ako ona još nije uspešno preuzela podatke pre nego ignore ode na vrednost 'true.' Ovo je prilično napredna upotreba klauzura, ali srećom, ta upotreba je sasvim šablonska. 
*/

const Example4 = () => {
    const [data, setData] = useState(null);

    useEffect(() => {
        //A
        let ignore = false;
        const ff = async () => {
            //B
            let r = await fetch('http://localhost:8080/api/v1/genre/20');
            let rr = await r.json();
            if (!ignore) {
                setData(rr);
            }
        };
        ff();
        return () => {
            //C
            ignore = true;
        };
    }, []);

    return (
        <div>
            <pre>{JSON.stringify(data, null, 4)}</pre>
        </div>
    );
};

const FetchExample = () => {
    return (
        <div>
            <Example1 />
            <hr />
            <Example2 />
            <hr />
            <Example3 />
            <hr />
            <Example4 />
            <hr />
        </div>
    );
};

export default FetchExample;
