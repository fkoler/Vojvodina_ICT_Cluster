/*
Napraviti tabelu koja izgleda na sledeci nacin: 
|Quick | brown fox  | jumps |
|------|------------|-------|
|over  | lazy | dog | and   |
|      |------|-----|-------|
|the   | then | it  | fall  | 
|      |--------------------|
|      |   prey to a lion   |
|---------------------------|      

CSS DEO ZADATKA (ovo radite tek kada budemo uradili CSS)
Zahtevi:
    - Tekst u celijama treba da bude centriran, velicine 20px, Roman stila
    - Zaglavlje treba da bude podebljano i obojeno u sivo 
    - Okviri oko celija treba da budu debljine 2px i da se sastoje od dve linije
*/

import "./zadatak1.css"
const ZadatakJ3 = () => {
    return <div>
        <h1> Zadatak 3</h1>
        <table className="tabela">
            <tr>
                <th> Quick </th>
                <th colspan="2">brown fox</th>
                <th> jumps </th>
            </tr>
            <tr>
                <td rowspan="3">over the</td>
                <td>lazy</td>
                <td>dog</td>
                <td>and</td>
            </tr>
            <tr>
                <td>then</td>
                <td>it</td>
                <td>fall</td>
            </tr>
            <tr>
                <td colspan="3">prey to a lion</td>
            </tr>
        </table>
    </div>
}

export default ZadatakJ3;
