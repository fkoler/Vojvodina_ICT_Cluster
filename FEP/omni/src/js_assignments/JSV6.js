/* 
    Zadatak 6
    a. Napisati funkciju koja računa koliko je dobar pangram neki string. Pangram je rečenica koja ima u sebi sva slova nekog jezika. Ovde nas samo zanima engleski jezik radi jednostavnosti. Velika i mala slova ignorišemo, baš kao i apsolutno sve što nije slovo. Kvalitet pangrama definiše sledeće pravilo: ako nemamo sva slova, onda je kvalitet 0. Ako imamo sva slova, onda je kvalitet jednak broju slova u azbuci jezika (26 ovde) podeljenom sa brojem slova koji pangram u stvari ima. Savršen pangram (bez ponavljanja) onda ima rezultat 1.

    b. Napraviti React kontrolu koja omogucava da se pangram otkuca u tekst polje i onda na pritisak dugmeta racuna kvalitet i prikazuje ga pored kontrole

    c. Prosiriti kontrolu iz b. tako da ispod kontrole stoji lista svih slova koja još nisu upotrebljena. Ta lista treba da se menja u toku kucanja. Ta lista treba da sadrži sva slova sa tim da su prisutna slova zelena, a odsutna crvena.
*/

import { useState } from 'react';
import * as R from 'ramda';

const JSV6 = () => {
    const [input, setInput] = useState('');
    const [pangramQuality, setPangramQuality] = useState(0);

    const alphabet = 'abcdefghijklmnopqrstuvwxyz'.split('');

    const evaluate_pangram = (pangram) => {
        const cleanedString = R.replace(/[^a-z]/g, '', R.toLower(pangram));

        const uniqueLetters = R.uniq(R.split('', cleanedString));

        const uniqueLetterCount = R.length(uniqueLetters);

        return uniqueLetterCount === 26 ? 26 / R.length(cleanedString) : 0;
    };

    const usedLetters = R.uniq(
        R.split('', R.replace(/[^a-z]/g, '', R.toLower(input)))
    );

    const handleCheck = () => {
        const quality = evaluate_pangram(input);

        setPangramQuality(quality.toFixed(2));
    };

    return (
        <div
            style={{
                textAlign: 'center',
                color: '#f5f5f5',
                backgroundColor: '#000000',
                height: '100vh',
            }}
        >
            <input
                style={{ width: '400px', height: '40px', marginTop: '20px' }}
                type='text'
                value={input}
                onChange={(e) => setInput(e.target.value)}
            />
            <br />
            <button
                style={{ width: '180px', marginTop: '20px', color: '#000000' }}
                onClick={handleCheck}
            >
                Izračunaj kvalitet
            </button>

            <p style={{ marginTop: '20px' }}>
                Kvalitet Pangrama: &nbsp;
                <span style={{ color: '#e5ed70', fontSize: '20px' }}>
                    {pangramQuality}
                </span>
            </p>

            <div
                style={{
                    display: 'flex',
                    justifyContent: 'center',
                    marginTop: '20px',
                    fontFamily: 'monospace',
                }}
            >
                {alphabet.map((letter) => (
                    <span
                        key={letter}
                        style={{
                            color: usedLetters.includes(letter)
                                ? 'green'
                                : 'red',
                            fontWeight: usedLetters.includes(letter)
                                ? '900'
                                : '200',
                            margin: '0 10px',
                            fontSize: '25px',
                        }}
                    >
                        {letter}
                    </span>
                ))}
            </div>
        </div>
    );
};

export default JSV6;
