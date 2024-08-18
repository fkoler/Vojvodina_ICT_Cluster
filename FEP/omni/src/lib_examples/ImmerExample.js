/*
    Immer (nemački: uvek) je mali paket koji omogućava lakši rad sa nepromenjivim (engl. immutable) stanjima.
    Link do dokumentacije: https://immerjs.github.io/immer/


*/

import { Immer, immerable, produce } from "immer";
import { useState } from "react";
import { useImmer } from "use-immer";

const podaci = [
    {id: 0, ime: "Alice", prezime: "Alfersson"},
    {id: 1, ime: "Bob", prezime: "Bobbert"},
    {id: 2, ime: "Carol", prezime: "Carson"},
    {id: 3, ime: "Drew", prezime: "Dastardly"},
    {id: 4, ime: "Elsa", prezime: "Estavez"},
    {id: 5, ime: "Frank", prezime: "Finn"},
    {id: 6, ime: "Greta", prezime: "Garland"},
    {id: 7, ime: "Harold", prezime: "Hyssop"},
];

const NameComponent = ({ime, prezime}) => {
    return <span>
                <span>
                    <strong>{prezime.toUpperCase()}</strong>
                </span>
                {" "}
                <span>
                    {ime}
                </span>
            </span>;  
}
// Ovo gradivo smo već obrađivali u lekciji gde smo učili hook-ove.

// Vrlo bitno je razumeti da vrednosti koje koristi useState ne mogu da se menjaju direktno.
// To znači da ne možemo da uradimo person.ime = "Bob!" i da očekujemo da to radi. 
// Zbog toga smo koristili 'const' da ako i pokušamo direktnu promenu 
// (koristi se i termin 'mutiranje stanja') da nas kompajler spreči. 
// Jedini način da se promeni bilo koja vrednost koja je stanje jeste da se uvek pravi 
// *potpuno nova vrednost* koja se onda prosledi u set funkciju. 
// To znači da ne možemo da menjamo niz ili da menjamo objekat nego da konstruišemo nov i 
// prosledimo ga dalje. Ovde to radimo sa person promenljivom stanja kojoj šaljemo kao novu vrednost 'novaOsoba.' 

const Primer1 = ({osoba}) => {
    const [person, setPerson] = useState(osoba);
    return <div>
        <NameComponent ime={person.ime} prezime={person.prezime}/>
        <button onClick={() => {

            /*
             let novaOsoba = person
             novaOsoba.ime = "Bob!";
            */

            
            let novaOsoba = {
                id: person.id,
                ime: "Bob!",
                prezime: person.prezime
            }
            

            setPerson(novaOsoba);

        }}>Bobbify!</button>
    </div>
}


// Promena vrednosti je često oblika da želimo da sve ostane isto i da se promeni samo jedna stvar. 
// Kucati beskonačnu listu oblika osobina: staroStanje.osobina je vrlo dosadno i sklono greškama. 
// Srećom ima sintaksa koja znači: "Isto kao ranije samo što..." koju korisitmo ovde gde u našu 
// novu osobu stavimo ceo 'person' objekat, a onda prepišemo preko osobine 'ime' i stavimo 'Bob!'. 

const Primer2 = ({osoba}) => {
    const [person, setPerson] = useState(osoba);
    return <div>
        <NameComponent ime={person.ime} prezime={person.prezime}/>
        <button onClick={() => {

            let novaOsoba = {
                ...person,
                ime: "Bob!",
            }

            setPerson(novaOsoba);

        }}>Bobbify!</button>
    </div>
}


/*
    Immer paket nudi produce funkciju koja skraćuje posao

    produce(baseState, recipe: (draftState) => void): nextState

    baseState = nepromenjivo stanje prosleđeno produce funkciji (u našem primeru to je person)
    recipe = drugi argument koji predstavlja deklaraciju funkciju koja opisuje kako treba "izmeniti" stanje
            objekta (naravno, ne menja zapravo stanje postojećeg objekta nego kreira duboku kopiju i izmeni nad
            datom kopijom definisano stanje) 

            unutar recepta mogu da se koriste svi standardni JavaScript API-i
                - push, pop, slice, splice, set, sort, remove, delete, .... 

    draft = prvi argument svakog recepta (nije obavezno da se zove draft ali je neko nepisano pravilo)
            proxy originalnom stanju (baseState) koji sada može da "izmeni"


*/

//Primer najobicnije upotrebe produce funkcije
const Primer3 = ({osoba}) => {
    const [person, setPerson] = useState(osoba);
    return <div>
        <NameComponent ime={person.ime} prezime={person.prezime}/>
        <button onClick={() => {

            const novaOsoba = produce(person, draftState => {
                draftState.ime = "Bob!";
            })
            
            setPerson(novaOsoba);

        }}>Bobbify!</button>
    </div>
}

//Primer direktne upotrebe produce funkcije u okviru useState hook-a
//Ne mora da se navodi baseState, React podrazumeva kao baseState prvu promenljivu iz useState hook-a
const Primer4 = ({osoba}) => {
    const [person, setPerson] = useState(osoba);
    return <div>
        <NameComponent ime={person.ime} prezime={person.prezime}/>
        <button onClick={() => {

            setPerson(
                produce((draftState) => {
                    draftState.ime = "Bob!";
                })
            )
        

        }}>Bobbify!</button>
    </div>
}

//Primer useImmer hook-a koji dodatno olaksava upotrebu ovog paketa
//Ne mora da se poziva funkcija produce!

const Primer5 = ({osoba}) => {
    const [person, setPerson] = useImmer(osoba);
    return <div>
        <NameComponent ime={person.ime} prezime={person.prezime}/>
        <button onClick={() => {

            setPerson(
                (draftState) => {
                    draftState.ime = "Bob!";
                }
            )
        

        }}>Bobbify!</button>
    </div>
}


const ImmerExample = () => {
    return <>
        <Primer1 osoba={podaci[4]}/>
        <Primer2 osoba={podaci[5]}/>
        <Primer3 osoba={podaci[6]}/>
        <Primer4 osoba={podaci[7]}/>
        <Primer5 osoba={podaci[2]}/>
    </>
    
}

export default ImmerExample;