import { useEffect } from "react";
import { useFetcher } from "react-router-dom";

/*
    Ponekad nam treba pristup ponašanju rutera koje je automatsko, ali ne želimo da to radimo kada se ruteru sviđa.
    Onda ovo radimo kroz mehnizam koji se oslanja na useFetcher koji nam da objekat kojim možemo da kontrolišemo učitavanje na ruteru. 
*/

const AutoLoad2 = () => {
    const fetcher = useFetcher(); //Ovim dobijemo fetcher
    useEffect(() => {
        if(fetcher.state === 'idle' && !fetcher.data){ //Samo kada je fetcher slobodan (idle) i kada nema podataka pozovemo učitavanje
            fetcher.load("/lib/routes/automatic_loading"); //Ovo ne poziva učitavanje bilo čega, nego specifične rute u našem sistemu. 
        }
    }, [fetcher]);
    return <ul>
        {fetcher.data ? fetcher.data.map(v => <li>{v.id} : {v.title}</li>) : ""}
    </ul>;
}

export default AutoLoad2;