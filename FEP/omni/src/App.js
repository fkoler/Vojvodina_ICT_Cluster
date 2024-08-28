import { Link } from 'react-router-dom';

function App() {
    return (
        <div>
            <h1>Univerzalni primer za React</h1>
            <p>
                Ovaj primer sadrži primere za prekvalifikacioni kurs za React.
                Primeri su prokomentarisani, i svaki je namerno napravljen da
                bude onoliko jednostavan koliko je to moguće.
            </p>
            <ul>
                <li>Deo 1 - Osnove</li>
                <ul>
                    <li>
                        <Link to='hello_world'>React Hello World</Link>
                    </li>
                    <li>
                        <Link to='html_text'>React uvod u HTML - Tekst</Link>
                    </li>
                    <li>
                        <Link to='html_organisation'>
                            React uvod u HTML - Organizacija
                        </Link>
                    </li>
                    <li>
                        <Link to='html_image'>React uvod u HTML - Slike</Link>
                    </li>
                    <li>
                        <Link to='html_table'>React uvod u HTML - Tabele</Link>
                    </li>
                    <li>
                        <Link to='html_form'>React uvod u HTML - Forme</Link>
                    </li>
                    <li>
                        <Link to='css_basic'>
                            React uvod u CSS - Klase, selektori, pravila
                        </Link>
                    </li>
                    <li>
                        <Link to='css_text'>
                            React uvod u CSS - Modifikacija teksta
                        </Link>
                    </li>
                    <li>
                        <Link to='css_layout'>React uvod u CSS - Layout</Link>
                    </li>
                    <li>
                        <Link to='js_osnove'>React uvod u JS - Osnove</Link>
                    </li>
                    <li>
                        <Link to='js_usluzne'>
                            React uvod u JS - Uslužne klase
                        </Link>
                    </li>
                    <li>
                        <Link to='js_funkcionalno'>
                            React uvod u JS - Funkcionalno programiranje
                        </Link>
                    </li>
                    <li>
                        <Link to='js_objektno'>
                            React uvod u JS - Objektno orijentisano
                            programiranje
                        </Link>
                    </li>
                </ul>
                <li>Deo 2 - Uvod u React</li>
                <ul>
                    <li>
                        <Link to='jsx/osnove'>
                            React funkcionalne komponente
                        </Link>
                    </li>
                    <li>
                        <Link to='jsx/stopwatch1'>JSX - primer štoperice</Link>
                    </li>
                    <li>
                        <Link to='jsx/conditional'>
                            Kondicionalno renderovanje u React-u
                        </Link>
                    </li>
                    <li>
                        <Link to='jsx/lists'>Liste i React</Link>
                    </li>
                    <li>
                        <Link to='jsx/events'>React događaji</Link>
                    </li>
                    <li>
                        <Link to='jsx/hooks'>
                            Hook programiranje u React: effect i state
                        </Link>
                    </li>
                    <li>
                        <Link to='jsx/fetch'>Fetch API i React</Link>
                    </li>
                    <li>
                        <Link to='jsx/stopwatch2'>
                            JSX - operativan primer štoperice
                        </Link>
                    </li>
                    <li>
                        <Link to='jsx/pretraga'>Primer dinamičke pretrage</Link>
                    </li>
                    <li>
                        <Link to='lib/moduli'>JS i moduli</Link>
                    </li>
                    <li>
                        <Link to='lib/routes'>React i Rutiranje</Link>
                    </li>
                </ul>
                <li>Deo 3 - Napredan React</li>
                <ul>
                    <li>
                        <Link to='lib/immer'>Korišćenje biblioteke: immer</Link>
                    </li>
                    <li>
                        <Link to='lib/context'>React context</Link>
                    </li>
                    <li>
                        <Link to='lib/reducer'>React reducer</Link>
                    </li>
                    <li>
                        <Link to='lib/memo'>React memo</Link>
                    </li>
                </ul>
                <li> Zadaci </li>
                <ul>
                    <li>
                        {' '}
                        <Link to='html_assignment'> HTML i CSS Zadaci </Link>
                    </li>
                    <li>
                        <Link to='js_assignments'>JS zadaci</Link>
                    </li>
                </ul>
            </ul>
        </div>
    );
}

export default App;
