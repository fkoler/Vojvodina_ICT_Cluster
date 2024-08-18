import './Events.css';
/*
Do sada smo se uglavnom bavili, barem kada je Reactu pitanju, izgledom onoga što vidimo. To je, sa komponentama bukvalno i jedino što možemo da uradimo: komponente su kao matematičke jednačine: transformišu nekakav ulaz (props) u nekakav izlaz (renderovan JSX koji return-ujemo). Baš kao što 2 + 2 uvek 'vrati' 4 tako naše komponente za isti ulaz uvek vrate isti izlaz. U računarskim naukama ovo se zovu 'čiste funkcije.' 

Čiste funkcije imaju mnoge prednosti, ali ne mogu biti reaktivne. Za to su nam potrebni mehanizmi koji proširuju naše komponente i daju nekakvo ponašanje. Ti mehanizmi su događaji i hook-ovi. Događaje je lakše razumeti: To je način da kažemo sistemu da, kada korisnik nešto uradi, mi odgovorimo sa nekakvom akcijom. Dakle ako korinsik klikne na dugme, onda možemo nešto da uradimo. 

Događaji su, doduše, samo pola našeg recepta za interaktivnost: doagađaj može da reaguje na ono što uradimo, ali ne može da promeni našu (čistu) funkciju: ona će i dalje da vrati isti JSX. Zato će naši događaji u ovim primerima delovati malo nemoćno, budući da sve što možemo da ih nateramo da rade jeste da štampaju stvari u konzolu sa console.log(). Kada budemo imali i hook mehaizam, možemo da uradimo mnogo više: bilo šta, u stvari. 
*/

// Način na koji reagujemo na događaje jeste tako što imamo propove u HTML tagovima sa nazivima oblika onNesto gde je 'nesto' opis onoga što korisnik mora da uradi da bi se 'okinuo' ovaj događaj. Napunimo taj prop sa funkcijom koju hoćemo da se pozove u tom trenutku i to je to. Možemo proslediti funkciju po imenu ili da prosledimo lambda izraz, po želji.
const Example1 = () => {
    const klik = () => console.log('Klik!');
    return (
        <div>
            <button onClick={klik}>Dugme koje reaguje na klik</button>
            <button onClick={() => console.log('Lambda klik!')}>
                Dugme koje reaguje na klik ali prosleđivanjem lambde.
            </button>
            <button onClick={klik()}>
                Dugme koje ne reaguje zato što smo prosledili povratnu vrednost
                'klik' funkcije, a ne samu funkciju.
            </button>
        </div>
    );
};

// Funkcije koje reaguju na događaje (obrađivači ili 'handler'-i je termin koji se koristi) primaju jedan argument, konvencionalno nazvan 'e' koji je objekat koji daje i sve podatke o događaju i plus još ima metode kojima možemo da manipulišemo ponašanjem događaja. Tip podataka koje možemo dobiti jesu gde, tačno, u dugmetu je kliknuto, tačan timestamp kada je kliknuto, da li je u tom trenutku bio pritisnut neki modifikatorski taster, pozicija na ekranu koja odgovara pozicija klika, koji pointerski uređaj je odgovoran za klik i još dosta drugih osobina. Dokumentacija sadrži detalje.
const Example2 = () => {
    const klik = (e) => console.log(e);
    return (
        <div>
            <button onClick={klik}>
                Dugme koje ispisuje sve detalje događaja
            </button>
        </div>
    );
};

// Vrlo često imamo kontrole koje se poklapaju: na kraju krajeve sve što je u div-u se tehnički preklapa sa njim. Onda se postavlja pitanje: ako sam kliknuo na dugme, da li sam onda automaski kliknuo i na div u kome se dugme nalazi (plus div iza toga i tako dalje...). React i JS kažu 'da.' Podrazumevano ponašanje za svaki događaj (osim Scroll) jeste da ako se desi nekom elementu, onda se desio i svakom sadržavajućem elementu u hijerarhiji stranice koji se nalazi iznad.
const Example3 = () => {
    const klik_button = () => console.log('Ja regaujem na klik dugmeta!');
    const klik_div = () => console.log('Ja regaujem na klik div-a!');
    return (
        <div onClick={klik_div}>
            <button onClick={klik_button}>
                Dugme koje demonstrira propagaciju događaja
            </button>
        </div>
    );
};

// Ponekad ne želimo ovu propagaciju nego da, kada jednom 'sredimo' događaj, da on ne ide nigde dalje. To se postiže tako što, nad 'event' objektom mi pozovemo 'stopPropagation' metodu što garantuje da događaj ne ide nigde dalje.
const Example4 = () => {
    const klik_button = () => console.log('Ja regaujem na klik dugmeta!');
    const klik_button2 = (e) => {
        e.stopPropagation();
        console.log('Ja regaujem na klik dugmeta!');
    };
    const klik_div = () => console.log('Ja regaujem na klik div-a!');
    return (
        <div onClick={klik_div}>
            <button onClick={klik_button}>
                Dugme koje demonstrira propagaciju događaja
            </button>
            <button onClick={klik_button2}>
                Dugme koje demonstrira blokiranje propagacije događaja
            </button>
        </div>
    );
};

// Rekto se može desiti da postoji podrazumevano ponašanje koje se desi svaki put kada se desi neki događaj, bez potrebe da mi išta uradimo povodom toga. Recimo, forme imaju 'submit' događaj koji se desi kada se pritisne submit dugme u njima. Podrazumevano, ovo ponovo učita čitavu stranicu. Mi to obično ne želimo na modernim sajtovima. Mehanizam koji se koristi da se to blokira se opet oslanja na parametar e, samo što se ovaj put pozove .preventDefault() metoda.
const Example5 = () => {
    const klik_button = () => console.log('Ja regaujem na klik dugmeta!');
    const klik_button2 = (e) => {
        e.preventDefault();
        console.log('Ja regaujem na klik dugmeta!');
    };
    return (
        <div>
            <form onSubmit={klik_button}>
                <input
                    type='submit'
                    value='Dugme sa podrazumevanim ponašanjem'
                />
            </form>
            <form onSubmit={klik_button2}>
                <input
                    type='submit'
                    value='Dugme koje blokira podrazumevano ponašanje'
                />
            </form>
        </div>
    );
};

// Imamo na raspolaganju jako puno događaja: više nego što možemo i da pobrojimo. U ovom primeru posmatramo samo neke od češćih događaja miša koji nam omogućavaju da razlikujemo klik od desnog klika od toga da je taster samo pritisnut (pošto je klik i pritiskanje i puštanje), samo pušten, samo pomeren preko teritorije komponente, ili ušao ili izašao na područije komponente. Imamo dovoljno događaja da možemo da reagujemo na ponašanje korisnika sa ekstremnim granularitetom.
const Example6 = () => {
    return (
        <div
            className='e6'
            onClick={(e) =>
                console.log(`Kliknuto na ${e.clientX}, ${e.clientY}`)
            }
            onContextMenu={(e) =>
                console.log(`Desni klik na ${e.clientX}, ${e.clientY}`)
            }
            onMouseDown={(e) =>
                console.log(
                    `Dugme miša pritisnuto na ${e.clientX}, ${e.clientY}`
                )
            }
            onMouseUp={(e) =>
                console.log(`Dugme miša pušteno na ${e.clientX}, ${e.clientY}`)
            }
            onMouseEnter={(e) =>
                console.log(`Kursor miša ušao na ${e.clientX}, ${e.clientY}`)
            }
            onMouseLeave={(e) =>
                console.log(`Kursor miša izašao na ${e.clientX}, ${e.clientY}`)
            }
            onMouseMove={(e) =>
                console.log(
                    `Kursor miša se kreće na ${e.clientX}, ${e.clientY}`
                )
            }
        ></div>
    );
};

// Nećemo napraviti od ovoga katalog događaja (za to služi dokumentacija, i React i MDN) ali postoje i događaji koji nisu vezani za miš nego za tastaturu ili to da li neka kontrola ima fokus (tj. prima događaje sa tastature) ili ne.
const Example7 = () => {
    return (
        <div>
            A:{' '}
            <input
                type='text'
                onFocus={(e) => console.log('A dobio fokus.')}
                onBlur={(e) => console.log('A izgubio fokus.')}
                onKeyDown={(e) =>
                    console.log(`Nad A pristisnut taster ${e.key}`)
                }
                onKeyUp={(e) => console.log(`Nad A pušten taster ${e.key}`)}
                onInput={(e) => console.log(`Nad A uneseno nešto.`)}
                onChange={(e) => console.log(`A promenjen.`)}
            />
            <br />
            B:{' '}
            <input
                type='text'
                onFocus={(e) => console.log('B dobio fokus.')}
                onBlur={(e) => console.log('B izgubio fokus.')}
                onKeyDown={(e) =>
                    console.log(`Nad B pristisnut taster ${e.key}`)
                }
                onKeyUp={(e) => console.log(`Nad B pušten taster ${e.key}`)}
                onInput={(e) => console.log(`Nad B uneseno nešto.`)}
                onChange={(e) => console.log(`B promenjen.`)}
            />
        </div>
    );
};

// React i naročito React kontrole koje možemo da importujemo iz biblioteka imaju bolje načine da se ovo uradi, ali evo demonstracije kako možemo da koristimo događaje da napravimo tekst polje u koje korisnik __ne može__ da unese pogrešnu vrednost.
const Example8 = () => {
    return (
        <div>
            Uneti pozitivan celi broj:{' '}
            <input
                type='text'
                onBeforeInput={(e) => {
                    if (!e.data.match(/^[0-9]*$/)) {
                        e.preventDefault();
                        e.stopPropagation();
                    }
                    console.log(e.data);
                }}
            ></input>
        </div>
    );
};

const EventsExample = () => {
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
            <Example5 />
            <hr />
            <Example6 />
            <hr />
            <Example7 />
            <hr />
            <Example8 />
        </div>
    );
};

export default EventsExample;
