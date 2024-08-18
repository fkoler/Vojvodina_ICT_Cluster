import { useEffect, useState } from 'react';
import './Stopwatch2.css';

const format_time = (time) => {
    let ms = time;
    let s = Math.floor(ms / 1000);
    ms = ms - s * 1000;
    let m = Math.floor(s / 60);
    s = s - 60 * m;
    let h = Math.floor(m / 60);
    m = m - 60 * h;
    let d = Math.floor(h / 24);
    h = h - 24 * d;

    ms = ms.toString().padStart(3, '0');
    s = s.toString().padStart(2, '0');
    m = m.toString().padStart(2, '0');
    h = h.toString().padStart(2, '0');
    d = d.toString().padStart(2, '0');

    return `${d}:${h}:${m}:${s}.${ms}`;
};

const TimeDisplay = ({ time }) => {
    return <div className='time-display'>{format_time(time)}</div>;
};

const Stopwatch2 = () => {
    const [time, setTime] = useState(0);
    const [on, setOn] = useState(false);
    const [laps, setLaps] = useState([]);

    useEffect(() => {
        let id = setInterval(() => {
            if (on) {
                setTime((t) => t + 100);
            }
        }, 100);

        return () => {
            clearInterval(id);
        };
    }, [on]);

    const start_stop = () => {
        setOn((o) => !o);
    };

    return (
        <div className='stopwatch-main'>
            <TimeDisplay time={time} />

            <button onClick={() => setTime(0)} className='button reset'>
                Reset
            </button>

            <button
                onClick={() => {
                    setLaps([...laps, { t: time, id: crypto.randomUUID() }]);
                }}
                className='button lap'
            >
                Lap
            </button>
            {on ? (
                <button onClick={start_stop} className='button pause'>
                    Pause
                </button>
            ) : (
                <button onClick={start_stop} className='button start'>
                    Start
                </button>
            )}
            <ul className='lap-list'>
                {laps.map((v) => (
                    <li key={v.id}>{format_time(v.t)}</li>
                ))}
            </ul>
        </div>
    );
};

export default Stopwatch2;
