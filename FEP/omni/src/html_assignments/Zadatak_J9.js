/*
Kreirati stranicu sa naslovom "Olympic Athletes"
Napraviti sledeću tabelu na datoj stranici:

First name    Last name    Country   Sport
Simone        Biles        USA       Artistic Gymnastics
Darya         Klishina     Russia    Athletics
Ivana         Spanovic     Serbia    Athletics
Luka          Doncic       Slovenia  Basketball
Filip         Filipovic    Serbia    Water Polo
Evgeniya      Startseva    Russia    Volleyball
Novak         Djokovic     Serbia    Tennis

Ispod tabele sa prikazanim sportistima dodati sledeći tekst:

The order of the medal winners
1. People's Republic Of China
2. United States of America
3. Japan
4. Australia
5. ROC
*/

import './Zadatak_J9.css';

const Zadatak_J9 = () => {
    return (
        <div>
            <h1>Olympic Athletes</h1>
            <table>
                <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Country</th>
                        <th>Sport</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Simone</td>
                        <td>Biles</td>
                        <td>USA</td>
                        <td>Artistic Gymnastics</td>
                    </tr>

                    <tr>
                        <td>Darya</td>
                        <td>Klishina</td>
                        <td>Russia</td>
                        <td>Athletics</td>
                    </tr>

                    <tr>
                        <td>Ivana</td>
                        <td>Spanovic</td>
                        <td>Serbia</td>
                        <td>Athletics</td>
                    </tr>

                    <tr>
                        <td>Luka</td>
                        <td>Doncic</td>
                        <td>Slovenia</td>
                        <td>Basketball</td>
                    </tr>

                    <tr>
                        <td>Filip</td>
                        <td>Filipovic</td>
                        <td>Serbia</td>
                        <td>Water Polo</td>
                    </tr>

                    <tr>
                        <td>Evgeniya</td>
                        <td>Startseva</td>
                        <td>Russia</td>
                        <td>Volleyball</td>
                    </tr>

                    <tr>
                        <td>Novak</td>
                        <td>Djokovic</td>
                        <td>Serbia</td>
                        <td>Tennis</td>
                    </tr>
                </tbody>
            </table>

            <h3>The order of the medal winners:</h3>

            <ol>
                <li>People's Republic Of China</li>
                <li>United States of America</li>
                <li>Japan</li>
                <li>Australia</li>
                <li>ROC</li>
            </ol>
        </div>
    );
};

export default Zadatak_J9;
