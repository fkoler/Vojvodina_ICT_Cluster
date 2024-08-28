/* 
    Napisati program koji dobije početnu poziciju (kao x i y) i orijentaciju (N, S, W, E) Lengtonovog mrava https://en.wikipedia.org/wiki/Langton%27s_ant (videti i na slajdovima) i broj generacija i vrati poziciju i orijentaciju mrava posle toliko generacija. 

    Pravila Lengtonovog mrava (za nas):

    1. Svet je beskonačna 2D ravan podeljena na kvadrate jednake veličine koji mogu biti beli ili crni.

    2. Negde u svetu je mrav. Mrav ima poziciju i rotaciju. 

    3. U svakom potezu (ili generaciji) mrav prati sledeća pravila:

        a. Ako stoji na polju koje je belo, mrav se okrene za 90 stepeni u smeru kazaljke na satu, promeni boju ispod sebe iz bele u crnu i pomeri se napred za jedan korak. 

        b. Ako stoji na polju koje je crno, mrav se okrene za 90 stepeni u smeru suprotnom od kazaljke na satu, promeni boju ispod sebe iz crne u belu i pomeri se napred za jedan korak.

    4. Na početku igre, ceo svet je crn. 

    Lengtonov mrav je primer teoretske tvorevine poznate kao 'ćelijski automat' i ima kolosalan značaj u teoretskim računarskim naukama. Za nas je to odlična vežba veštine programiranja. 
*/

import { useState } from 'react';
import './JSV10a.css';

const initialGridSize = 15;

const langtonsAnt = (grid, x, y, orientation, generations) => {
    const directions = ['N', 'E', 'S', 'W'];

    const moves = {
        N: { dx: 0, dy: 1 },
        E: { dx: 1, dy: 0 },
        S: { dx: 0, dy: -1 },
        W: { dx: -1, dy: 0 },
    };

    let currentOrientation = orientation;
    let currentX = x;
    let currentY = y;

    for (let i = 0; i < generations; i++) {
        const currentColor =
            grid[Math.floor(initialGridSize / 2) - currentY][
                Math.floor(initialGridSize / 2) + currentX
            ];

        grid[Math.floor(initialGridSize / 2) - currentY][
            Math.floor(initialGridSize / 2) + currentX
        ] = !currentColor;

        if (currentColor) {
            currentOrientation =
                directions[(directions.indexOf(currentOrientation) + 3) % 4];
        } else {
            currentOrientation =
                directions[(directions.indexOf(currentOrientation) + 1) % 4];
        }

        currentX += moves[currentOrientation].dx;
        currentY += moves[currentOrientation].dy;

        if (
            currentX < -Math.floor(initialGridSize / 2) ||
            currentX > Math.floor(initialGridSize / 2) ||
            currentY < -Math.floor(initialGridSize / 2) ||
            currentY > Math.floor(initialGridSize / 2)
        ) {
            return {
                grid,
                x: currentX,
                y: currentY,
                orientation: currentOrientation,
                outOfBounds: true,
            };
        }
    }

    return {
        grid,
        x: currentX,
        y: currentY,
        orientation: currentOrientation,
        outOfBounds: false,
    };
};

const JSV10a = () => {
    const [generation, setGeneration] = useState(0);
    const [grid, setGrid] = useState(
        Array(initialGridSize)
            .fill(null)
            .map(() => Array(initialGridSize).fill(true))
    );

    const [antState, setAntState] = useState({
        x: 0,
        y: 0,
        orientation: 'N',
    });

    const [history, setHistory] = useState([
        {
            generation: 0,
            x: 0,
            y: 0,
            orientation: 'N',
            color: 'Crna',
        },
    ]);

    const [isAntOutOfBounds, setIsAntOutOfBounds] = useState(false);

    const handleNextGeneration = () => {
        const {
            grid: newGrid,
            x,
            y,
            orientation,
            outOfBounds,
        } = langtonsAnt(grid, antState.x, antState.y, antState.orientation, 1);

        setGrid(newGrid);
        setAntState({ x, y, orientation });
        setGeneration(generation + 1);
        setIsAntOutOfBounds(outOfBounds);

        if (!outOfBounds) {
            const currentColor = newGrid[Math.floor(initialGridSize / 2) - y][
                Math.floor(initialGridSize / 2) + x
            ]
                ? 'Crna'
                : 'Bela';

            setHistory((prevHistory) => [
                ...prevHistory,
                {
                    generation: generation + 1,
                    x,
                    y,
                    orientation,
                    color: currentColor,
                },
            ]);
        } else {
            console.warn('Mrav je izašao izvan granica tabele.');
        }
    };

    const getAntSymbol = (orientation) => {
        switch (orientation) {
            case 'N':
                return '👆🏽';
            case 'E':
                return '👉🏽';
            case 'S':
                return '👇🏽';
            case 'W':
                return '👈🏽';
            default:
                return ' ';
        }
    };

    return (
        <div className='container'>
            <div>
                <h2>Lengtonov mrav - Generacija {generation}</h2>

                <button
                    onClick={handleNextGeneration}
                    disabled={isAntOutOfBounds}
                >
                    Sledeća generacija
                </button>
                <br />
                <br />
                <div className='grid'>
                    {grid.map((row, rowIndex) => (
                        <div key={rowIndex} className='row'>
                            {row.map((cell, colIndex) => (
                                <div
                                    key={colIndex}
                                    className={`cell ${
                                        cell ? 'black' : 'white'
                                    } ${
                                        colIndex ===
                                            Math.floor(initialGridSize / 2) &&
                                        rowIndex ===
                                            Math.floor(initialGridSize / 2)
                                            ? 'start'
                                            : ''
                                    }`}
                                >
                                    {antState.x ===
                                        colIndex -
                                            Math.floor(initialGridSize / 2) &&
                                    antState.y ===
                                        Math.floor(initialGridSize / 2) -
                                            rowIndex
                                        ? getAntSymbol(antState.orientation)
                                        : ''}
                                </div>
                            ))}
                        </div>
                    ))}
                </div>
            </div>

            <div className='table-display'>
                <h3>Istorija pozicija mrava</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Generacija</th>
                            <th>X Pozicija</th>
                            <th>Y Pozicija</th>
                            <th>Orijentacija</th>
                            <th>Boja Polja</th>
                        </tr>
                    </thead>

                    <tbody>
                        {history.map((entry, index) => (
                            <tr key={index}>
                                <td>{entry.generation}</td>
                                <td>{entry.x}</td>
                                <td>{entry.y}</td>
                                <td>{entry.orientation}</td>
                                <td>{entry.color}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default JSV10a;
