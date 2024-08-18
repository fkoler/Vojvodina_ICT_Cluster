/*
    Možemo da transformišemo props-e u JSX izlaz preko naših funkcionalnih komponenata, ali ponekad nam je potrebno da donosimo _odluke._ To znači da nacrtamo jednu stvar u jednom slučaju, a drugu u drugom. Naravno, obična if petlja i dalje radi, ali postoje idiomatski načini da se to radi u okviru React okruženja. 
*/

// Najobičniji način da se radi sa uslovima jeste da se jednostavno proveri: u jednom slučaju uradimo jedno, a u drugom, drugo. 
const PrimerIf = ({uslov}) => {
    if(uslov){
        return <h1>Da</h1>;
    }else{
        return <h2>Ne</h2>;
    }
}



//Ponekad želimo da nešto prikažemo samo u jednom slučaju, a u drugom ne želimo da se vidi ništa. Ovo možemo rešiti tako što vratimo 'null'
const PrimerIf2 = ({uslov}) => {
    if(uslov){
        return <h1>Da</h1>;
    }else{
        return null;
    }
}

// Ponekad je ono što se razlikuje između dva uslova relativno malo: recimo da li pored neke stavke napišemo zvezdicu ili ne. Tu možemo da iskoristimo ternarni operator koji, naravno, radi u {} kao i bilo šta drugo.
const PrimerTernarno = ({uslov}) => {
    return <h1>Stavka {uslov ? <i>*</i> : ""}</h1>;
}
// Ovo radi odlično ali ne treba preterivati sa ternarnim stilom zato što može brzo da postane težak za čitanje. 

//Pošto je 'Napiši X' ako je uslov tačan inače ništa tako čest problem, ima vrlo brzo rešenje: ako u okviru {} napišemo uslov i && praćen onim što želimo da se napiše ako je uslov tačan. Ovo se vrlo često koristi za sitne stvari. Razlog što radi jeste osobina jezika koji su naslednici programskog jezika C (JS je jedan od njih, i Java je) koja se zove shortcutting. Ovo znači da ako imamo logički izraz koji sistem evaluira, on odustaje od dalje evaluacije čim zna taj rezultat. Ako je uslov false, onda je ceo izraz false i nikom ništa, ali ako je true, pogleda se sledeća.  
const PrimerLogicko = ({uslov}) => {
    return <h1>Stavka {uslov && <i>*</i>}</h1>;
}

const ConditionalExample = () => {
    return <div>
        <PrimerIf uslov={true}/>
        <PrimerIf uslov={false}/>
        <hr></hr>
        <PrimerIf2 uslov={true}/>
        <PrimerIf2 uslov={false}/>
        <hr></hr>
        <PrimerTernarno uslov={true}/>
        <PrimerTernarno uslov={false}/>
        <hr></hr>
        <PrimerLogicko uslov={true}/>
        <PrimerLogicko uslov={false}/>
        <hr></hr>
    </div>;
}

export default ConditionalExample;