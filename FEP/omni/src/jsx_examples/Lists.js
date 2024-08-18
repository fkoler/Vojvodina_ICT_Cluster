/*
    Jedna od najčešćih stvari koju imamo da prikažemo korisniku jesu razne liste: kolekcije nekakvih stavki nekakvim redom. Budući da je JSX JavaScript izraz, kao i sve ostalo, prirodan metod da se ovo radi jeste kroz nizove. 
*/
const podaci = [
    {ime: "Alice", prezime: "Alfersson"},
    {ime: "Bob", prezime: "Bobbert"},
    {ime: "Carol", prezime: "Carson"},
    {ime: "Drew", prezime: "Dastardly"},
    {ime: "Elsa", prezime: "Estavez"},
    {ime: "Frank", prezime: "Finn"},
    {ime: "Greta", prezime: "Garland"},
    {ime: "Harold", prezime: "Hyssop"},
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

//Ovde koristimo mapiranje niza podataka na niz JSX izraza koji, kada ga vratimo iz komponente, postane niz na stranici. Ovde smo to uradili sa LI tag-ovima ali moglo bi da bude apsolutno bilo šta, samo da treba da se ponavlja. Ako pokrenete ovo videćete poruku u konzoli gde se React žali na to što nemamo nekakav 'key' atribut. 
const Example1 = () => {
    const list = podaci.map((p) => <li><NameComponent ime={p.ime} prezime={p.prezime}/></li>)
    return <div>
        <ul>
            {list}
        </ul>
    </div>
}

const podaci2 = [
    {id: 0, ime: "Alice", prezime: "Alfersson"},
    {id: 1, ime: "Bob", prezime: "Bobbert"},
    {id: 2, ime: "Carol", prezime: "Carson"},
    {id: 3, ime: "Drew", prezime: "Dastardly"},
    {id: 4, ime: "Elsa", prezime: "Estavez"},
    {id: 5, ime: "Frank", prezime: "Finn"},
    {id: 6, ime: "Greta", prezime: "Garland"},
    {id: 7, ime: "Harold", prezime: "Hyssop"},
];

//React zahteva da kada radimo sa listama, damo svakom elementu jedinstven ključ. To je ili ključ iz baze ili, ako nemamo bazu, nešto što generišemo _jedno_ i pridodamo podacima. Recimo vrednost brojača. Valja voditi računa da se ovi ključevi nikako ne mogu praviti u vreme renderovanja: tj. u funkciji koja tvori komponentu. Ključevi moraju da budu isti svaki put kada se stavka prikaže: to je njihova svrha. 
const Example2 = () => {
    const list = podaci2.map((p) => <li key={p.id}><NameComponent  ime={p.ime} prezime={p.prezime}/></li>)
    return <div>
        <ul>
            {list}
        </ul>
    </div>
}

const ListsExample = () => {
    return <div>
        <Example1/>
        <hr></hr>
        <Example2/>
        <hr></hr>
    </div>;
}

export default ListsExample;