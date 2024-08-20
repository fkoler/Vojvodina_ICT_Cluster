/* 
    Zadatak 8
    Napisati funkciju koja preuzme funkciju, listu, i naziv i vrati novu funkciju koja se ponaša isto kao i prosleđena funkcija samo što, se u listu upisuje svaki poziv funkcije sa parametrima u obliku stringa koji, ako je funkcija pozvana sa parametrima 3 i 4, recimo, bude "f(3,4)" gde je 'f' štagod da je u nazivu
*/

import { useState, useEffect } from 'react';

const logFunctionCalls =
    (func, logList) =>
    (...args) => {
        console.log(`Pozvana funkcija: ${func.name}()`);

        logList.push(`${func.name}(${args.join(',')})`);

        return func(...args);
    };

const JSV8 = () => {
    const [log, setLog] = useState([]);

    const [result, setResult] = useState(null);

    const add = (a, b) => a ** b;

    const loggedAdd = logFunctionCalls(add, log);

    const handleAddition = () => {
        const res = loggedAdd(3, 4);

        setResult(res);
        setLog([...log]);
    };

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

    useEffect(() => {
        log.length > 0 && console.log('Log updated:', log);
    }, [log]);

    return (
        <div
            style={{
                backgroundColor: '#000000',
                color: '#f5f5f5',
                height: '100vh',
                padding: '30px',
            }}
        >
            <h2 style={{ margin: '0px 0px 20px 0px' }}>JSV8</h2>
            <button onClick={handleAddition}>Izvrši Stepenovanje</button>

            <p>Rezultat: {result !== null && <span>{result}</span>}</p>

            <h3>Log:</h3>

            <ol>
                {log.map((entry, k) => (
                    <li key={k}>{entry}</li>
                ))}
            </ol>
        </div>
    );
};

export default JSV8;
