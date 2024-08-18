/* 
    Zadatak 7
    a) Napisati funkciju koja za dati dan (1-31), mesec (1-12), i godinu (četiri cifre) koji predstavljaju datum rođenja, vrati koliko je osoba rođena na taj dan bila živa, u sekundama. Program ne treba da radi za datume pre 1970. 

    b) Napraviti React kontrolu koja omogucava da se unese datum i dobije vreme u sekundama kada se pritisne dugme

    c) Prosiriti kontrolu tako da se izracunato vreme osvezava u realnom vremenu
*/

import { useState, useEffect } from 'react';
import moment from 'moment';

const calculateAgeInSeconds = (day, month, year) => {
    const birthDate = moment({ year, month: month - 1, day });
    const currentDate = moment();
    const duration = moment.duration(currentDate.diff(birthDate));

    return Math.floor(duration.asSeconds());
};

const JSV7 = () => {
    const [date, setDate] = useState({ day: '', month: '', year: '' });
    const [result, setResult] = useState(null);
    const [error, setError] = useState('');

    useEffect(() => {
        const { day, month, year } = date;

        const updateResult = () => {
            const birthDate = moment({ year, month: month - 1, day });
            const currentDate = moment();
            const ageInSeconds = calculateAgeInSeconds(day, month, year);

            if (!day || !month || !year) {
                setError('Svi podaci moraju biti uneti.');
                setResult(null);
                return;
            }

            if (!birthDate.isValid()) {
                setError('Datum nije validan. Molimo proverite unos.');
                setResult(null);
                return;
            }

            if (birthDate.isAfter(currentDate)) {
                setError('Datum rođenja ne može biti u budućnosti.');
                setResult(null);
                return;
            }

            if (year < 1970) {
                setError(
                    'Datum nije validan. Datum mora biti posle 1970. godine.'
                );
                setResult(null);
                return;
            }

            setError('');
            setResult(ageInSeconds);
        };

        updateResult();

        const intervalId = setInterval(updateResult, 1000);

        return () => clearInterval(intervalId);
    }, [date]);

    return (
        <div
            style={{
                height: '100vh',
                color: '#f5f5f5',
                backgroundColor: '#000000',
                textAlign: 'center',
            }}
        >
            <h1
                style={{
                    margin: '0px 0px 15px 0px',
                }}
            >
                Izračunaj vreme u sekundama
            </h1>

            <input
                type='number'
                min='1'
                max='31'
                placeholder='Dan'
                value={date.day}
                onChange={(e) =>
                    setDate((prev) => ({ ...prev, day: e.target.value }))
                }
            />

            <input
                type='number'
                min='1'
                max='12'
                placeholder='Mesec'
                value={date.month}
                onChange={(e) =>
                    setDate((prev) => ({ ...prev, month: e.target.value }))
                }
            />

            <input
                type='number'
                min='1970'
                max={new Date().getFullYear()}
                placeholder='Godina'
                value={date.year}
                onChange={(e) =>
                    setDate((prev) => ({ ...prev, year: e.target.value }))
                }
            />

            {error ? (
                <p style={{ color: 'red' }}>{error}</p>
            ) : (
                result !== null && (
                    <p>
                        Osoba rođena{' '}
                        <span style={{ color: 'red', fontSize: '20px' }}>
                            {date.day}/{date.month}/{date.year}
                        </span>{' '}
                        je živa{' '}
                        <span style={{ color: 'red', fontSize: '20px' }}>
                            {result}
                        </span>{' '}
                        sekundi.
                    </p>
                )
            )}
        </div>
    );
};

export default JSV7;
