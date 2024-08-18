/* 
    Zadatak 5
    a. Napisati funkciju koja za dati string kaže da li je palindrom (čita se isto i sa jedne i sa druge strane). Razmaci i mala/velika slova nisu bitni, a interpunkcija nije podržana. 

    b. Realoizovati React kontrolu koja se sastoji od text polja i dugmeta, gde dugme proveri tekst unesen u polje i ispod ispise "Jeste palindrom" u zavisnosti od toga sta je rezultat funkcije

    c. Modifikovati React kontrolu tako da umesto da moram da pritisnem dugme, jednostavno ispod kontrole pise da li je ono sto je uneto je palindrom ili nije.
*/

import React, { useState } from 'react';
import _ from 'lodash';

const is_palindrome = (str) => {
    const cleanedString = _.toLower(_.replace(str, /\s+/g, ''));

    const reversedString = _.reverse(_.toArray(cleanedString)).join('');

    return cleanedString === reversedString;
};

const debouncedHandleChange = _.debounce((newValue, setResult) => {
    if (is_palindrome(newValue)) {
        setResult('Jeste palindrom');
    } else {
        setResult('Nije palindrom');
    }
}, 300);

const JSV5 = () => {
    const [input, setInput] = useState('');
    const [result, setResult] = useState('');

    const handleChange = (e) => {
        const newValue = e.target.value;
        setInput(newValue);

        debouncedHandleChange(newValue, setResult);
    };

    return (
        <div style={{ textAlign: 'center' }}>
            <input
                style={{ width: '400px', height: '40px' }}
                type='text'
                value={input}
                onChange={handleChange}
            />
            <p>{result}</p>
        </div>
    );
};

export default JSV5;
