import { useLoaderData } from "react-router-dom";

const AutoLoad = () => {
    const books = useLoaderData(); //useLoaderData je hook koji nam olakšava život: kada ga pozovemo dobijemo ono što smo učitali kroz loader u ruteru. Ovo menja onaj komplikovani useEffect, mada nije primenjivo u svim slučajevima. 
    return <ul>
        {books.map(v => <li>{v.id} : {v.title}</li>)}
    </ul>;
}

export default AutoLoad;