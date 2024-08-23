/* 
    Zadatak 3
    Iskoristiti funkciju iz Zadatka 2 da se sortira sledeća lista podataka

    let studenti = [
        {indeks: "XY 409/2072", ime: "Alice", prezime: "Alferson"},
        {indeks: "ZW 133/2072", ime: "Bob", prezime: "Bobbert"},
        {indeks: "XY 112/2073", ime: "Carol", prezime: "Creed"},
        {indeks: "XY 507/2071", ime: "Drew", prezime: "Danger"},
        {indeks: "ZW 233/2070", ime: "Eve", prezime: "Emmerson"},
        {indeks: "ZW 57/2072", ime: "Trent", prezime: "Tweed"},
        {indeks: "XY 111/2071", ime: "Fred", prezime: "Franks"},
        {indeks: "ZW 404/2073", ime: "George", prezime: "Green"}
    ];

    I to po indeksu tako što se prvo sortira abecedno po smeru, pa zatim po godini, i konačno po broju indeksa. Da bi se sortiralo abecedno samo treba porediti stringove kao da su brojevi. 
*/

import { useEffect } from 'react';

const sortiranje = () => {
    let studenti = [
        { indeks: 'XY 409/2072', ime: 'Alice', prezime: 'Alferson' },
        { indeks: 'ZW 133/2072', ime: 'Bob', prezime: 'Bobbert' },
        { indeks: 'XY 112/2073', ime: 'Carol', prezime: 'Creed' },
        { indeks: 'XY 507/2071', ime: 'Drew', prezime: 'Danger' },
        { indeks: 'ZW 233/2070', ime: 'Eve', prezime: 'Emmerson' },
        { indeks: 'ZW 57/2072', ime: 'Trent', prezime: 'Tweed' },
        { indeks: 'XY 111/2071', ime: 'Fred', prezime: 'Franks' },
        { indeks: 'ZW 404/2073', ime: 'George', prezime: 'Green' },
    ];

    const splitIndex = (indeks) => {
        const [smer, ostatak] = indeks.split(' ');
        const [brojIndeksa, godina] = ostatak.split('/');
        return {
            smer,
            godina: +godina,
            brojIndeksa: +brojIndeksa,
        };
    };

    studenti.sort((a, b) => {
        const aIndex = splitIndex(a.indeks);
        const bIndex = splitIndex(b.indeks);

        const smerComparison = aIndex.smer.localeCompare(bIndex.smer);
        if (smerComparison !== 0) return smerComparison;

        if (aIndex.godina !== bIndex.godina)
            return aIndex.godina - bIndex.godina;

        return aIndex.brojIndeksa - bIndex.brojIndeksa;
    });

    return (
        <div>
            {studenti.map((student) => (
                <div key={student.indeks}>
                    {student.indeks} - {student.ime} {student.prezime}
                </div>
            ))}
        </div>
    );
};

const JSV3 = () => {
    useEffect(() => {
        const bodyStyle = document.body.style;
        bodyStyle.margin = '0';
        bodyStyle.padding = '0';
        bodyStyle.boxSizing = 'border-box';

        return () => {
            bodyStyle.margin = '';
            bodyStyle.padding = '';
            bodyStyle.boxSizing = '';
        };
    }, []);

    return (
        <pre
            style={{
                margin: 0,
                padding: 0,
                height: '100vh',
                backgroundColor: '#000000',
                color: '#f5f5f5',
            }}
        >
            {sortiranje()}
        </pre>
    );
};

export default JSV3;
