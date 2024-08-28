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

const initialGridSize = 91;

const COLOR_BLACK = 'Crna';
const COLOR_WHITE = 'Bela';

const langtonsAnt = (grid, x, y, orientation) => {
    const directions = ['N', 'E', 'S', 'W'];
    const moves = {
        N: { dx: 0, dy: 1 },
        E: { dx: 1, dy: 0 },
        S: { dx: 0, dy: -1 },
        W: { dx: -1, dy: 0 },
    };

    const centerOffset = Math.floor(initialGridSize / 2);
    const currentColor = grid[centerOffset - y][centerOffset + x];

    const directionChange = currentColor ? -1 : 1;
    const newOrientation =
        directions[(directions.indexOf(orientation) + directionChange + 4) % 4];

    grid[centerOffset - y][centerOffset + x] = !currentColor;

    const newX = x + moves[newOrientation].dx;
    const newY = y + moves[newOrientation].dy;

    const outOfBounds =
        newX < -centerOffset ||
        newX > centerOffset ||
        newY < -centerOffset ||
        newY > centerOffset;

    return {
        grid,
        x: outOfBounds ? x : newX,
        y: outOfBounds ? y : newY,
        orientation: outOfBounds ? orientation : newOrientation,
        outOfBounds,
    };
};

const JSV10b = () => {
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
            color: COLOR_BLACK,
        },
    ]);

    const [desiredGenerations, setDesiredGenerations] = useState(1);
    const [isAntOutOfBounds, setIsAntOutOfBounds] = useState(false);

    const handleMultipleGenerations = () => {
        const newHistory = [...history];

        let tempGrid = grid.map((row) => [...row]);
        let currentX = antState.x;
        let currentY = antState.y;
        let currentOrientation = antState.orientation;

        for (let i = 0; i < desiredGenerations; i++) {
            const result = langtonsAnt(
                tempGrid,
                currentX,
                currentY,
                currentOrientation
            );

            if (result.outOfBounds) {
                setIsAntOutOfBounds(true);
                console.warn('Mrav je izašao izvan granice sveta');
                break;
            }

            tempGrid = result.grid;
            currentX = result.x;
            currentY = result.y;
            currentOrientation = result.orientation;

            const currentColor = tempGrid[
                Math.floor(initialGridSize / 2) - currentY
            ][Math.floor(initialGridSize / 2) + currentX]
                ? COLOR_BLACK
                : COLOR_WHITE;

            newHistory.push({
                generation: generation + i + 1,
                x: currentX,
                y: currentY,
                orientation: currentOrientation,
                color: currentColor,
            });
        }

        setGrid(tempGrid);
        setAntState({
            x: currentX,
            y: currentY,
            orientation: currentOrientation,
        });
        setHistory(newHistory);
        setGeneration((prev) => prev + desiredGenerations);
    };

    const resetSimulation = () => {
        setGeneration(0);
        setGrid(
            Array(initialGridSize)
                .fill(null)
                .map(() => Array(initialGridSize).fill(true))
        );
        setAntState({ x: 0, y: 0, orientation: 'N' });
        setHistory([
            { generation: 0, x: 0, y: 0, orientation: 'N', color: COLOR_BLACK },
        ]);
        setIsAntOutOfBounds(false);
        setDesiredGenerations(1);
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

    const downloadHistoryAsJSON = () => {
        const jsonString = JSON.stringify(history, null, 2);
        const blob = new Blob([jsonString], { type: 'application/json' });
        const url = URL.createObjectURL(blob);
        const link = document.createElement('a');

        link.href = url;
        link.download = 'history.json';
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    };

    return (
        <div className='container'>
            <div>
                <h2>
                    Lengtonov mrav - Generacija{' '}
                    {Math.max(...history.map((entry) => entry.generation))}
                </h2>

                <input
                    type='number'
                    value={desiredGenerations}
                    onChange={(e) => setDesiredGenerations(+e.target.value)}
                />

                <button
                    onClick={handleMultipleGenerations}
                    disabled={isAntOutOfBounds}
                >
                    Izvrši generacije
                </button>
                <br />
                <br />
                <button onClick={resetSimulation}>Resetuj simulaciju</button>
                <br />
                <br />
                <button onClick={downloadHistoryAsJSON}>
                    Preuzmi Istoriju (JSON)
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

                {isAntOutOfBounds && (
                    <p
                        style={{
                            color: '#ff0000',
                            backgroundColor: '#000000',
                            fontWeight: '900',
                            textTransform: 'uppercase',
                            fontSize: '24px',
                            marginBottom: '40px',
                            padding: '10px',
                        }}
                    >
                        Mrav je izašao izvan granice sveta
                    </p>
                )}

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
                            {history
                                .slice()
                                .reverse()
                                .map((entry, index) => (
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
        </div>
    );
};

export default JSV10b;
