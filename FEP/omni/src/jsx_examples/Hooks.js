import { useState, useEffect } from 'react';

/*
    Koristeći događaje možemo da reagujemo na akcije korisnika, ali ne možemo da postignem mnogo jer naše kontrole ne mogu da _zapamte_ bilo šta. Svako pozivanje funkcije počinje od 'nule' i mi ne možemo da razlikujemo da li smo pozvani prvi ili stoti put: sve lokalne promenljive se prave nanovo. 
*/

//Ovo ne radi zato što brojač uvek počne sa vrednošću nula, kada god se iscrta kontrola: vrednost ne ostaje između iscrtavanja kontrole. Da stvar bude gora, čak i da može, promena lokalne promenljive ne izaziva ponovno iscrtavanje kontrole tako da čak i da smo uspeli da povećamo brojač React ne zna da treba da osveži kontrolu da bi se to videlo.
const BrokenExample1 = () => {
    let brojac = 0;
    return (
        <div>
            {brojac} <button onClick={() => brojac++}>+</button>
        </div>
    );
};

/*
Način na koji se ovaj problem leči je kroz posebnu funkciju koju dobijemo od React-a koja se zove 'useState.' Ove posebne funkcije (ima ih još) se zovu još i 'hook-ovi' i to je već neko vreme podrazumevan način na koji treba da se pravi React. Ono što 'useState' radi je, efektivno, pravi poseban novi tip promenljive koja nije lokalna promenljiva (odnosno, nije __samo__ lokalna promenljiva) nego predstavlja nešto novo što se u React-u zove 'stanje' odnosno 'state.' Stanje opstaje između render-a (zato što svaki put kada pozovemo useState dobijemo zapamćenu vrednost) i promena stanja izaziva ponovno iscrtavanje kontrole. Način na koji su promenljive stanja implementirane jeste kroz par vrednosti: prva je obična lokalna promenljiva (iz koje možemo da čitamo tekuću vrednost promenljive stanja), a druga je funkcija koju moramo da koristimo ako hoćemo da promenimo vrednost stanja: ne možemo da kažemo brojac = brojac + 2 ili brojac++, to neće raditi. Kada menjamo vrednost menjamo je *isključivo* sa set-funkcijom koju smo dobili i kojoj prosledimo potpuno novu vrednost koju hoćemo da namestimo. Sam 'useState' ima kao parametar početnu vrednost promenljive stanja: u našem slučaju to je 0.
*/

const Example1 = () => {
    const [brojac, setBrojac] = useState(0);

    return (
        <>
            {brojac} <button onClick={() => setBrojac(brojac + 1)}>+</button>
        </>
    );
};

/*
Ovo je zakomentarisano zato što izaziva grešku kod kompajliranja. Hook-ovi su posebne funkcije, i imaju veliki broj ograničenja, specifično:
    - Mogu se pozvati samo tokom iscrtavanja, tj. u okviru komponente ili u okviru drugog hook-a. 
    - Ne mogu da budu u bilo kakvim petljama 
    - Moraju isključivo da budu na najvišem nivou funkcije i to tako da se svaki put svi hook-ovi pozivaju istim redosledom. 
Ovde smo pozvali hook u if-u i to se ne može kompajlirati. 
*/
/*const BrokenExample2 = ({koristiHook}) => {
    let brojac = 0;
    let setBrojac = () => {};
    if(koristiHook){
        [brojac, setBrojac] = useState(0);
    }
    return <div>
        {brojac} <button onClick={() => setBrojac(brojac + 1)}>+</button>
    </div>;
}
*/

// Stanje je privatno: svaka od ovih komponenti ima *svoj* brojač koji je potpuno nezavisan od stanja ostalih komponenti istog tipa.
const Example2 = () => {
    return (
        <div>
            <Example1 />
            <Example1 />
            <Example1 />
        </div>
    );
};

const Example31 = ({ id }) => {
    console.log(`Renderujem Example3_1 sa id-jem ${id}`);

    return <h1>{id}</h1>;
};
// Mi već neko vreme pričamo o 'iscrtavanju' odnosno 'renderovanju.' Šta je to? Način na koji React radi jeste da interno čuva šta treba da se vidi na ekranu: računarski model koji dogovara HTML-u koji se zove 'DOM' (document object model). JSX se direktno mapira na operacije modifikacije ovog DOM-a, u stvari JSX *jeste* opis modifikacije tog stabla. Iscrtavanje (renderovanje) je operacija gde React pozove određene komponente, uzme njihove zatražene promene DOM stabla, kombinuje ih u jednu veliku promenu[1], primeni je na stablo, i onda zamoli pretraživač da sve to pretvori u piksele koje vi vidite. Iscrtavanje se okida na komponentama kada se pikažu prvi put, kada im se promeni stanje, i kada se ponovo iscrtaju njihove nad-komponente iz bilo kog razloga.
//[1] Ovde preskačemo jako jako jako puno detalja i optimizacije.
const Example3 = () => {
    const [s, setS] = useState(0);
    return (
        <div>
            <button onClick={() => setS(s + 1)}>Refresh</button>
            <Example31 id={1} />
            <Example31 id={2} />
            <Example31 id={3} />
        </div>
    );
};
// Set metoda koju vam vrati useState je vrlo specifična: ne izvršava se kada je pozovete, samo zakaže promenu stanja za sledeći render. To znači da ovaj brojač izgleda kao da broji u jedinicama od 3, ali on u stvari samo kaže sistemu da uradi istu stvar tri puta.
const Example4 = () => {
    const [brojac, setBrojac] = useState(0);
    return (
        <>
            {brojac}{' '}
            <button
                onClick={() => {
                    setBrojac(brojac + 1);
                    setBrojac(brojac + 1);
                    setBrojac(brojac + 1);
                }}
            >
                +
            </button>
        </>
    );
};

// Naravno da možemo da napravimo primer gde brojimo u trojkama. Prvo, mogli bi jednostavno da kažemo setBrojac(brojac + 3), ali ako zamislimo da imamo vrednost koju menjamo iterativno, korak po korak, uvek možemo da napravimo lokalnu promenljivu (koja se menja trenutno) akomuliramo promene u njoj, i onda je pridodamo, na ovaj ili onaj način, stanju kao u ovom primeru.
const Example5 = () => {
    const [brojac, setBrojac] = useState(0);
    let brojacIncrement = 0;
    return (
        <>
            {brojac}{' '}
            <button
                onClick={() => {
                    brojacIncrement++;
                    brojacIncrement++;
                    brojacIncrement++;
                    setBrojac(brojac + brojacIncrement);
                }}
            >
                +
            </button>
        </>
    );
};

// Mogli smo da koristimo trik sa lokalnom promenljivom u kojoj akomuliramo promene zato što je sabiranje matematički prosto. Kod kompleksnijih stanja (a stanje može biti bilo šta) ovo nije slučaj. Šta onda? Postoji način da pozovemo setBrojac na takav način da više poziva ima kumulativan efekat. Umesto da kažemo setBrojac(NovaVrednost) što u stvari kaže React-u "zameni brojač sa ovom novom vrednošću" možemo da prosledimo toj funkciji __funkciju__ (tkz. updater funkcija). Ta funkcija koju prosledimo prima tekuću vrednost stanja kao parametar i vraća kako želi da ona bude promenjena. React će da 'zapamti' svaki takav poziv i da uradi tačno šta mi kažemo, redom koji smo rekli. Jedini problem je ako pozovemo setBrojac() sa fisknom vrednošću. Onda će React, kada bude primenio sve set-ove koje smo zatražili, da izvrši sve promene redom, stigne do ovog poziva SetBrojac i 'pregazi' štagod da je izračunao ranije kao u primeru 6_1
const Example6 = () => {
    const [brojac, setBrojac] = useState(0);
    return (
        <>
            {brojac}{' '}
            <button
                onClick={() => {
                    setBrojac((b) => b + 1);
                    setBrojac((b) => b + 1);
                    setBrojac((b) => b + 1);
                }}
            >
                +
            </button>
        </>
    );
};

const Example61 = () => {
    const [brojac, setBrojac] = useState(0);
    return (
        <>
            {brojac}{' '}
            <button
                onClick={() => {
                    setBrojac((b) => b + 1); // Štagod da je stanje, povećaj za jedan
                    setBrojac((b) => b + 1); // Štagod da je stanje, povećaj za jedan
                    setBrojac((b) => b + 1); // Štagod da je stanje, povećaj za jedan
                    setBrojac(brojac + 1); // Zameni stanje sa vrednošću tokom ovog render-a plus jedan.
                }}
            >
                +
            </button>
        </>
    );
};

const NameComponent = ({ ime, prezime }) => {
    return (
        <span>
            <span>
                <strong>{prezime.toUpperCase()}</strong>
            </span>{' '}
            <span>{ime}</span>
        </span>
    );
};

const podaci2 = [
    { id: 0, ime: 'Alice', prezime: 'Alfersson' },
    { id: 1, ime: 'Bob', prezime: 'Bobbert' },
    { id: 2, ime: 'Carol', prezime: 'Carson' },
    { id: 3, ime: 'Drew', prezime: 'Dastardly' },
    { id: 4, ime: 'Elsa', prezime: 'Estavez' },
    { id: 5, ime: 'Frank', prezime: 'Finn' },
    { id: 6, ime: 'Greta', prezime: 'Garland' },
    { id: 7, ime: 'Harold', prezime: 'Hyssop' },
];

// Vrlo bitno je razumeti da vrednosti koje koristi useState ne mogu da se menjaju direktno. To znači da ne možemo da uradimo person.ime = "Bob!" i da očekujemo da to radi. Zbog toga smo koristili 'const' da ako i pokušamo direktnu promenu (koristi se i termin 'mutiranje stanja') da nas kompajler spreči. Jedini način da se promeni bilo koja vrednost koja je stanje jeste da se uvek pravi *potpuno nova vrednost* koja se onda prosledi u set funkciju. To znači da ne možemo da menjamo niz ili da menjamo objekat nego da konstruišemo nov i prosledimo ga dalje. Ovde to radimo sa person promenljivom stanja kojoj šaljemo kao novu vrednost 'novaOsoba.'
const Example7 = ({ osoba }) => {
    const [person, setPerson] = useState(osoba);

    return (
        <div>
            <NameComponent ime={person.ime} prezime={person.prezime} />
            <button
                onClick={() => {
                    let novaOsoba = {
                        id: person.id,
                        ime: 'Bob!',
                        prezime: person.prezime,
                    };
                    setPerson(novaOsoba);
                }}
            >
                Bobbify!
            </button>
        </div>
    );
};

// Promena vrednosti je često oblika da želimo da sve ostane isto i da se promeni _samo jedna stvar._ Kucati beskonačnu listup oblika osobina: staroStanje.osobina je vrlo dosadno i sklono greškama. Srećom ima sintaksa koja znači: "Isto kao ranije samo što..." koju korisitmo ovde gde u našu novu osobu stavimo ceo 'person' objekat, a onda prepišemo preko osobine 'ime' i stavimo 'Bob!'.
const Example8 = ({ osoba }) => {
    const [person, setPerson] = useState(osoba);
    return (
        <div>
            <NameComponent ime={person.ime} prezime={person.prezime} />
            <button
                onClick={() => {
                    let novaOsoba = {
                        ...person,
                        ime: 'Bob!',
                    };
                    setPerson(novaOsoba);
                }}
            >
                Bobbify!
            </button>
        </div>
    );
};

// Trik sa ... možemo da koristimo sa proizvoljno komplikovanim objektima: ovde to koristimo da izmenimo samo dve stvari u objektu koji ima ugnježdene objekte. Ovo je takođe demonstracija da ima stvari koji nismo pominjali u HTML-u, recimo ceo SVG mehanizam koji može da se koristi da definiše proizvoljnu 2D grafiku.
const Example9 = () => {
    const [rectangle, setRectangle] = useState({
        a: {
            x: 0,
            y: 0,
        },
        b: {
            x: 100,
            y: 0,
        },
        c: {
            x: 100,
            y: 100,
        },
        d: {
            x: 0,
            y: 100,
        },
    });
    return (
        <div>
            <svg>
                <polygon
                    stroke='black'
                    fill='none'
                    points={`${rectangle.a.x},${rectangle.a.y} ${rectangle.b.x},${rectangle.b.y} ${rectangle.c.x},${rectangle.c.y} ${rectangle.d.x},${rectangle.d.y}`}
                />
            </svg>
            <button
                onClick={() => {
                    setRectangle({
                        ...rectangle,
                        b: {
                            ...rectangle.b,
                            x: rectangle.b.x + 50,
                        },
                        c: {
                            ...rectangle.c,
                            x: rectangle.c.x + 50,
                        },
                    });
                }}
            >
                Stretch
            </button>
        </div>
    );
};
// Za nizove važi fundamentalno ista priča kao i za druge stvari: ne možemo da menjamo niz možemo samo da pravimo drugi ili, ako to ne može, da konstruišemo kopiju i da menjamo __to.__ U ovom slučaju ne dodajemo stvari sa push nego tako što napravimo nov niz sa svim iz starog niza na čiji kraj dodamo onda ono što hoćemo.
const Example10 = () => {
    const [names, setNames] = useState([]);
    const [index, setIndex] = useState(0);
    return (
        <div>
            <ul>
                {names.map((v) => (
                    <li key={v.id}>
                        <NameComponent ime={v.ime} prezime={v.prezime} />
                    </li>
                ))}
            </ul>
            <button
                onClick={() => {
                    if (index < podaci2.length) {
                        setIndex(index + 1);
                        setNames([...names, podaci2[index]]);
                    }
                }}
            >
                Add
            </button>
        </div>
    );
};

//Ne samo što ne možemo da modifikujemo niz dodavanjem i oduzimanjem stavki nego ne možemo da menjamo objekte u njemu tako što kažemo, recimo, niz[i].ime = "Bob!". Ti elementi niza su objekti, stoga ako ih menjamo moramo da pravimo potpuno nov objekat na njihovom mestu. Ovde to radimo pomoću funkcije mapiranja i višestruke klauzure. Valja napomenuti da za dovoljno kompleksna stanja, ovo postane jako naporno za pisanje stoga postoje alati koji ovo čine lakšim i kada bude red za to pogledaćemo kako radi jedan od njih: Immer. Takođe, ako imate dovoljno komplikovanu kontrolu koja manipuliše ogromnom količinom stanja, može da se desi da vam je logika koja opisuje ponašanje svega 'razbacana.' Ovo se rešava sa još jednom novom tehnologijom koju ćemo analizirati kasnije koja se zove 'reducer.'
const Example11 = () => {
    const [names, setNames] = useState([]);
    const [index, setIndex] = useState(0);
    return (
        <div>
            <ul>
                {names.map((v, i) => {
                    return (
                        <li key={v.id}>
                            <NameComponent ime={v.ime} prezime={v.prezime} />
                            <button
                                onClick={() => {
                                    setNames(
                                        names.map((n) => {
                                            if (n.id === v.id) {
                                                return {
                                                    ...n,
                                                    ime: 'Bob!',
                                                };
                                            } else {
                                                return n;
                                            }
                                        })
                                    );
                                }}
                            >
                                Bobbify!
                            </button>
                        </li>
                    );
                })}
            </ul>
            <button
                onClick={() => {
                    if (index < podaci2.length) {
                        setIndex(index + 1);
                        setNames([...names, podaci2[index]]);
                    }
                }}
            >
                Add
            </button>
        </div>
    );
};

/*Funkcije koje tvore komponente moraju biti *čiste* što znači da ne smeju da rade bilo šta što nije podešavanje izlgeda i ponašanja interfejsa: da li je komponenta renderovana ili ne, ne bi trebalo ništa da radi. Ovo je većinu vremena OK, ali nam ponekad treba da sama komponenta nešto uradi u nekim situacijama, uglavno da na neki način interaguje sa nekim udaljenim sistemom. Tipičan slučaj (kao što ćemo videti kasnije) jeste da komponenta treba da učita podatke sa nekog servera negde kada se prvi put iscrta. Srećom, React pruža hook koji to omogućava: useEffect. U UseEffect šaljemo dve stvari: funkciju, i listu elemenata od kojih zavisimo. Funkcija je ono što se izvršava, a lista elemenata od kojih zavisimo je jedna od tri moguće stvari:
    - undefined (ovo se dešava kada ne stavimo ništa) => Ovo znači da će se efekat izvršavati kada god se funkcija renderuje. Ovo nam retko treba, ali je tu. 
    - prazna lista, [] => Ovo znači da se efekat izvršava tačno *jednom* kada se komponenta prvi put prikaže (ovo se zove 'mounting') 
    - Lista promenljivih stanja, propova, i drugih promenljiva od kojih zavisi proračun u efektu. Efekat će se pozvati opet kada god se neka od ovih vrednosti promeni. 
Funkcija koju prosledimo u useEffect ima povratnu vrednost: to je druga funkcija koju React poziva:
    - Tik pre nego što se efekat pokrene opet i
    - Kada se komponenta ukloni iz DOM stabla 
Ovo služi da se 'počisti' iza našeg efekta. Recimo ako u efektu pravimo nekakvu konekciju, ovde tu konekciju možemo da raskinemo. 
Ako pokrenete ovo videćete nešto zbunjujuće: React će da ispiše
Izvršavam Efekat!
Čistim iza efekta!
Izvršavam efekat!
Što? Veoma je česta forma baga da se efekat ne napiše tako da počisti stvari iza sebe i da bi pomogao da se ti bagovi lako nađu, React u razvojnom režimu, svaku komponentu prikaže a onda odmah obriše i prikaže opet. Ovim svaka komponenta garantovano prođe kroz test da li zna da iza sebe očisti kako treba. 
*/
const Example12 = () => {
    useEffect(() => {
        console.log('Izvršavam efekat!');
        return () => {
            console.log('Čistim iza efekta!');
        };
    }, []);
};

const HooksExample = () => {
    return (
        <div>
            <BrokenExample1 />
            <hr />
            <Example1 />
            <hr />
            <Example2 />
            <hr />
            <Example3 />
            <hr />
            <Example4 />
            <hr />
            <Example5 />
            <hr />
            <Example6 />
            <hr />
            <Example61 />
            <hr />
            <Example7 osoba={podaci2[4]} />
            <hr />
            <Example8 osoba={podaci2[5]} />
            <hr />
            <Example9 />
            <hr />
            <Example10 />
            <hr />
            <Example11 />
            <hr />
            <Example12 />
        </div>
    );
};

export default HooksExample;
