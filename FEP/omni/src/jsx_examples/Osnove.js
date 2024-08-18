/*
    Mi smo do ovog momenta koristili jako puno JSX komponenti u stvari: svaki zadatak je imao barem jednu funkciju, tipično onu koja je bila na kraju i koja je bila 'export default' koja je bila JSX komponenta i koju smo (iza kulisa) koristili da ispišemo na ekran naš primer. 

    Šta je u stvari JSX komponenta? To je ili funkcija (i onda je to funkcionalna komponenta) ili klasa (i onda je to klasna komponenta) koja kreira, efektivno, nov HTML tag koji možemo da koristimo slobodno. Mi se ovde, za sada, koncentrišemo isključivo na funkcionalne komponente (njih preporučuje Facebook koji je, naravno, tvorac React biblioteke) ali pokazaćemo i klasne. 

    U funkcionalnim pravila su:
        - Počinje velikim slovom
        - Prima 0 ili 1 parametar (više o tome za minut)
        - Vraća ono što treba da se ispiše kao komponenta koristeći JSX izraz. 

    Kada se poštuju pravila možemo da koristimo komponentu tako što napišemo njeno ime između < i />
*/

const Primer1 = () => {
    return <h1>Ovo je minimalna komponenta,</h1>;
};

const Primer2 = () => {
    return (
        <div>
            <Primer1 />
            <h2>
                Komponente mogu da se koriste u drugim komponentama potpuno
                slobodno.
            </h2>
        </div>
    );
};

const Primer3 = () => {
    let o =
        'U JSX, da kažemo to i formalno, možemo umetnuti bilo koju vrednost iz JS';
    let x = 3;
    let y = Array.from('Hello World');
    return (
        <div>
            <h1>
                {o} : {x + 3}
            </h1>
            To mogu biti i izrazi čak i komplikovani izrazi. Sve što treba je da
            ih umetnemo između velikih zagrada. Ugnježdavanje tih zagrada je
            moguće.
            <ul>
                {y.map((v, k) => {
                    console.log(typeof k);
                    return <li key={k}>{v}</li>;
                })}
            </ul>
            <p>
                Iste zagrade se koriste i da se proslede parametri atributima
                tag-ova koji su u promenljivama ili koji nisu stringovi (koji i
                dalje mogu u navodnike), na primer 'border' sledeće tabele.
            </p>
            <table border={1}>
                <tr>
                    <td>A</td>
                    <td>B</td>
                </tr>
            </table>
            <p style={{ backgroundColor: '#9999cc' }}>
                To znači da smo konačno spremni da razumemo zašto CSS inline
                sintaksa u JSX izgleda kao što smo navikli: zato što inline CSS
                u JSX-u živi u objektima, a pošto objekat nije string (prirodno)
                onda mora u velike zagrade, a sama sintaksa za pisanje objekata
                uključuje zagrade. Misterija{' '}
                <span style={{ fontWeight: 700 }}>rešena!.</span>
            </p>
        </div>
    );
};

/*
    Naravno ovakve komponente rade nešto ali nisu osobito korisne zato što, fundamentalno, uvek prikazuju istu stvar. Ovo ih čini ne osobito korisnim za ponovno korišćenje. Naravno, React ima rešenje (u stvari, mnogo rešenja) za ovaj problem: props. Svaka komponenta može da primi parametar 'props' koji je objekat čiji su atributi atributi koji su navedeni kao atributi tag-a kada je korišćena komponenta. To znači da ako napišemo <Primer4 poruka="Hello world!"/> to će da pozove Primer4 funkciju sa props atributom koji izgleda ovako {poruka: "Hello world!"}. 
*/
const Primer4 = (props) => {
    return <h1>{props.poruka}</h1>;
};

/* 
    Često, imamo tačno na umu šta može da bude u 'props' to jest imamo samo određeni broj parametara na umu. U tim slučajeivma, staviti samo prosto nemo 'props' je sa jedne strane malo mučno za upotrebu (jer moramo kalemiti jedno 'props.' svaki put kada hoćemo da se referišemo), a sa druge je teško razumeti iz koda kako neku komponentu koristiti. Ovaj problem se tipično leči kroz destrukturiranje objekta props.
*/

const Primer5 = ({ poruka }) => {
    return <h1>{poruka}</h1>;
};

/*
    Zgodno je imati podrazumevane vrednosti. Srećom, to je moguće uraditi u ovoj sintaksi destruktuiranja. Ovo je najbliže što JS može da priđe argumentima sa ključnim rečima koji postoje u drugim jezicima. 
 */
const Primer6 = ({ poruka = 'Nema poruke' }) => {
    return <h1>{poruka}</h1>;
};

/*
    Kao što možemo da stavljamo <span> u <div> u drugi <div> i tako dalje, to možemo i sa našim komponentama. To znači da možemo da imamo komponente koje imaju proizvoljno specificirane potomke-komponente koje idu u neko mesto u toj komponenti. Koje komponente su umetnute u komponentu specificira osobina (kaže se i vrlo često 'prop') 'children' 
*/

const Primer7 = ({ children }) => {
    return <div style={{ border: '2px double black' }}>{children}</div>;
};

const JSXOsnove = () => {
    return (
        <div>
            <Primer1 />
            <hr />
            <Primer2 />
            <hr />
            <Primer3 />
            <hr />
            <Primer4 poruka='Hello world!' />
            <hr />
            <Primer5 poruka='Hello world!' />
            <hr />
            <Primer6 />
            <Primer7>
                <Primer6 poruka='A' />
                <Primer6 poruka='B' />
                <Primer6 poruka='C' />
            </Primer7>
        </div>
    );
};

export default JSXOsnove;
