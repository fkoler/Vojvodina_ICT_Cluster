/*
Zadatak 2: Na stranici ispisati sledecu pesmu. 

Опрости, мајко света, опрости,
што наших гора пожалих бор,
на ком се, устук свакоје злости,
блаженој теби подиже двор;
презри, небеснице, врело милости,
што ти земаљски сагреши створ:
Кајан ти љубим пречисте скуте,
Santa Maria della Salute.

Зар није лепше носит лепоту,
сводова твојих постати стуб,
него грејући светску грехоту
у пепо спалит срце и луб;
тонут о броду, трнут у плоту,
ђаволу јелу а врагу дуб?
Зар није лепше вековат у те,
Santa Maria della Salute?

Iznad stihova pesme treba da pise:
    - Santa Maria della Salute
    - Laza Kostic, treba da bude link, klikom na link otvori se stranica o pesniku
Ispod pesme staviti sliku crkve Santa Maria della Salute


CSS DEO ZADATKA (ovo radite tek kada budemo uradili CSS)
Zahtevi:
    - tekst pesme i slika treba da se prikazu jedno pored drugog, sa leve strane tekst pesme, a sa desne slika
    - tekst pesme centrirati i uokviriti okvirom debljine 2px koji je obojen po zelji
    - recenicu 'Santa Maria della Salute?' obojiti bojom po izboru i slova podebljati 
    - ime pesnika i naziv pesme takodje centrirati i podebljati
    - ime pesnika prikazati zelenom bojom
*/

import './Zadatak_J2.css';

const Zadatak_J2 = () => {
    return (
        <>
            <h1 className='title'>Zadatak 2</h1>
            <div className='container'>
                <div className='text-section'>
                    <h1>Santa Maria della Salute</h1>
                    <h2>
                        <a
                            href='https://sr.wikipedia.org/wiki/Лаза_Костић'
                            target='_blank'
                            rel='noopener noreferrer'
                        >
                            Laza Kostic
                        </a>
                    </h2>
                    <pre className='song-text'>
                        Опрости, мајко света, опрости,
                        <br />
                        што наших гора пожалих бор,
                        <br />
                        на ком се, устук свакоје злости,
                        <br />
                        блаженој теби подиже двор;
                        <br />
                        презри, небеснице, врело милости,
                        <br />
                        што ти земаљски сагреши створ:
                        <br />
                        Кајан ти љубим пречисте скуте,
                        <br />
                        Santa Maria della Salute.
                        <br />
                        <br />
                        Зар није лепше носит лепоту,
                        <br />
                        сводова твојих постати стуб,
                        <br />
                        него грејући светску грехоту
                        <br />
                        у пепо спалит срце и луб;
                        <br />
                        тонут о броду, трнут у плоту,
                        <br />
                        ђаволу јелу а врагу дуб?
                        <br />
                        Зар није лепше вековат у те,
                        <br />
                        <span className='highlight'>
                            Santa Maria della Salute?
                        </span>
                    </pre>
                </div>
                <div className='image-section'>
                    <img
                        src='https://upload.wikimedia.org/wikipedia/commons/9/91/Santa_Maria_della_Salute_Venice.JPG'
                        alt='Santa Maria della Salute'
                    />
                </div>
            </div>
        </>
    );
};

export default Zadatak_J2;
