/* 
    Zadatak 9
    a) Napisati funkciju koja za dati tekst vrati procenat upotrebe svih slova u redosledu abecede. Mala i velika slova se ignorišu, razmaci i znakovi interpunkcije se ignorišu. Za potrebe ovoga, samo se razmatra engleska abeceda. 

    b) Napisati kontrolu koja kako kucam string tako osvezava displej procenata upotrebe svih slova abecede.
    
    c) Modifikovati display grafikona koji prikazuje istu stvar.
*/

import { useState, useEffect } from 'react';

const calculateLetterFrequency = (text) => {
    const alphabetSize = 26;
    const frequencies = Array(alphabetSize).fill(0);

    const getLettersOnly = (text) =>
        text
            .toLowerCase()
            .split('')
            .filter((char) => char >= 'a' && char <= 'z');

    const letters = getLettersOnly(text);

    const calculateTotalLetters = (letters) =>
        letters.reduce((count, char) => {
            const letterIndex = char.charCodeAt(0) - 'a'.charCodeAt(0);
            frequencies[letterIndex]++;

            return count + 1;
        }, 0);

    const totalLetters = calculateTotalLetters(letters);

    return frequencies.map((count) =>
        totalLetters === 0 ? 0 : (count / totalLetters) * 100
    );
};

const JSV9 = () => {
    const [text, setText] = useState('');
    const [letterFrequencies, setLetterFrequencies] = useState([]);

    useEffect(() => {
        setLetterFrequencies(calculateLetterFrequency(text));
    }, [text]);

    const handleChange = (e) => {
        setText(e.target.value);
    };

    const renderTableRows = () => {
        return letterFrequencies.map((frequency, k) => (
            <tr key={k}>
                <td>
                    {String.fromCharCode('a'.charCodeAt(0) + k).toUpperCase()}
                </td>
                <td>{frequency.toFixed(2)}%</td>
            </tr>
        ));
    };

    return (
        <div>
            <label>
                Unesite tekst:{' '}
                <input
                    type='text'
                    value={text}
                    onChange={handleChange}
                    style={{ width: '50%' }}
                />
            </label>
            <br />
            <br />
            <table>
                <thead>
                    <tr>
                        <th>Slovo</th>
                        <th>Procenat</th>
                    </tr>
                </thead>
                <tbody>{renderTableRows()}</tbody>
            </table>
        </div>
    );
};

export default JSV9;
