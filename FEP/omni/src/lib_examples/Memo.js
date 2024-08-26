/**
 * useMemo hook se koristi za cuvanje rezultata izmedju ponovnog prikazivanja (renderovanja)
 *
 * Primer:
 *      const cachedValue = useMemo(calculateValue, dependencies)
 *
 * Parametri:
 *   - calculateValue - funkcija koja izracunava vrednost koju zelite da kesirate. Nema argumente i trebalo bi da vrati vrednost bilo kog tipa.
 *                    - React ce sam da pozove funkciju tokom pocetnog renderovanja, a svaki sledeci put prilikom renderovanja vratice istu vrednost osim ako se zavisnosti nisu promenile. Ako su se zavisnosti promenile pozvace funkciju da ponovo izracuna vrednost, a zatim sacuvati novu vrednost kako bi kasnije mogao da je koristi.
 *   - dependencies - lista svih reaktivnih vrednosti na koje se upucuje untar calculateValue
 *                  - reaktivna vrednost ukljucuje props, stanje i sve varijable i funkcije deklarisane direktno unutar tela vase komponente
 *
 * Povratna vrednost:
 *  - pocetni prikaz - rezultat poziva calculateValue f-je bez argumenata
 *  - sledece prikazivanje - ili ce vratiti sacuvanu vrednost iz poslednjeg renderovanja (ako se zavisnosti nisu promenile) ili ce ponovo pozvati calculateValue i vratiti rezultat funkcije
 */

import { useCallback, useMemo, useState } from 'react';

// funkcija koja racun vrednost koja ce biti kesirana
const calculateValue = (value, component) => {
    const nova_vrednost = value * 42;
    // ovde mozemo imati komplikovane proracune ali posto je ovo primer onda je funkcija je jednostavna
    console.log(
        `Pozvana funkcija calculateValue za vrednost ${value} i komponentu ${component}`
    );
    return nova_vrednost;
};

const PrimerBezMemo = () => {
    const [value, setValue] = useState(3);
    const [txt, setTxt] = useState(''); //dodatno stanje kako bih prikazali da se i izmenom ovog stanja pozvati funkcija za izracunavanje

    // vrednost proracuna koji je odradjen u funkciji
    // ovo znaci da ce funkcija calculateValue izvrsiti svaki put kada se komponenta prikazuje, a to moze da se desi promenom stanja ili bilo cega drugog, da se to ne bi stalno desavalo koristimo useMemo
    const nova_vrednost = calculateValue(value, 'primer bez memo');

    return (
        <div>
            {' '}
            <h3> Primer bez useMemo </h3>
            <p> Vrednost je: {nova_vrednost} </p>
            <br />
            <label> Tekst: </label>
            <input type='text' onChange={(e) => setTxt(e.target.value)} />
            <br />
            <label> Vrednost: </label>
            <input
                type='number'
                value={value}
                onChange={(e) => setValue(e.target.value)}
            />
        </div>
    );
};

const PrimerMemo = () => {
    const [value, setValue] = useState(2);
    const [txt, setTxt] = useState(''); // izmenom ovog stanja nece doci do poziva funkcije calculateValue
    // za razliku od prethodnog primer ovde ce se funcija calculateValue pozvati samo kada se promeni vrednost stanja value
    const nova_vrednost = useMemo(
        () => calculateValue(value, 'primer memo'),
        [value]
    );

    return (
        <div>
            <h3> Primer sa useMemo </h3>
            <p> Vrednost je: {nova_vrednost} </p>
            <label> Tekst: </label>
            <input type='text' onChange={(e) => setTxt(e.target.value)} />
            <br />
            <label> Vrednost: </label>
            <input
                type='number'
                value={value}
                onChange={(e) => setValue(e.target.value)}
            />
        </div>
    );
};

/**
 * useCallback je hook koji omogucava da kesirate definiciju funkcije izmedju ponovonog prikazivanja
 *
 * Primer:
 *      useCallback(fn, dependencies)
 *
 * Parametri:
 *      - fn - vrednost funkcije koju zelite da kesirate. Funkcija moze da primi bilo koje argumente i da vrati bilo koju vrednost.
 *           - Povratna vrednost:
 *              - ako je prvo renderovanje onda se vraca funkcija
 *              - ako nije prvo renderovanje React ce vratiti istu funkciju ako se zavisnosti nisu promenile od poslednjeg renderovanja, a ako je doslo do promene zavisnosti React ce vratiti funkciju koju ste preneli tokom trenutnog renderovanja i sacuvace je u slucaju da se kasnije moze ponovo koristiti
 *              - BITNO: React ce samo da vrati funkciju, nece je pozvati, nego vi odlucujete kad ce se funkcija pozvati
 *
 *      - dependencies - lista zavisnosti
 *
 * Povratna vrednost
 *  - vraca funkciju u zavisnosti od toga da li su se zavisnosti promenile ili ne
 */

const saberi = (a, b, komponenta) => {
    console.log(`${komponenta} - Sabiranje brojeva`);
    return a + b;
};

const PrimerBezCallback = () => {
    const [name, setName] = useState(''); //stanje koje cemo koristiti samo da prikazemo kada se sve pozove funkcija
    const [a, setA] = useState(0);
    const [b, setB] = useState(0);

    // funkcija ce da se pozove svaki put kada se komponenta renderuje
    const zbir = saberi(+a, +b, 'bez callback');

    return (
        <div>
            <h3> Bez Callback</h3>
            <input
                placeholder='name'
                value={name}
                onChange={(e) => setName(e.target.value)}
            />
            <input
                placeholder='A'
                value={a}
                onChange={(e) => setA(e.target.value)}
            />
            <input
                placeholder='B'
                value={b}
                onChange={(e) => setB(e.target.value)}
            />
            {zbir}
        </div>
    );
};

const PrimerSaCallback = () => {
    const [name, setName] = useState('');
    const [a, setA] = useState(0);
    const [b, setB] = useState(0);
    const [zbir, setZbir] = useState(0);

    // funkcija ce da se pozove samo kada se promene vrednosti stanja a i b
    const handleClick = useCallback(() => {
        setZbir(+a + +b);
    }, [a, b]);

    return (
        <div>
            <h3>Callback</h3>
            <input
                placeholder='name'
                value={name}
                onChange={(e) => setName(e.target.value)}
            />
            <input
                placeholder='A'
                value={a}
                onChange={(e) => setA(e.target.value)}
            />
            <input
                placeholder='B'
                value={b}
                onChange={(e) => setB(e.target.value)}
            />
            <button onClick={handleClick}>Saberi</button>
            {zbir}
        </div>
    );
};

const MemoAndCallback = () => {
    return (
        <div>
            <PrimerBezMemo />
            <hr />
            <PrimerMemo />
            <hr />
            <PrimerBezCallback />
            <hr />
            <PrimerSaCallback />
        </div>
    );
};

export default MemoAndCallback;
