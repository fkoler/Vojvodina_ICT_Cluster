import './Stopwatch1.css';

/*
Ovo je kontrola koja služi za prikaz vremena. Jedini prop koji prima je vreme u milisekundama koje odna konvertuje u interval. Naravno postoje i bolji metodi da se ovo uradi, ali ovde smo eskplicitni i to uradimo sa malo lake matematike. 
 */
const TimeDisplay = ({time}) => {
    let ms = time; 
    let s = Math.floor(ms / 1000);
    ms = ms - s * 1000;
    let m = Math.floor(s / 60);
    s = s - 60 * m;
    let h = Math.floor(m / 60);
    m = m - 60 * h;
    let d = Math.floor(h / 24);
    h = h - 24 * d;
    ms = ms.toString().padStart(3, "0");
    s = s.toString().padStart(2, "0");
    m = m.toString().padStart(2, "0");
    h = h.toString().padStart(2, "0");
    d = d.toString().padStart(2, "0");    
    return <div className="time-display">{d}:{h}:{m}:{s}.{ms}</div>
}
// Ovo prikazuje interfejs uspešno ali fali reaktivnost. Normalne funkcionalne komponente rade samo jednu stvar: transformišu props u JSX koji ih prikazuje i to je sve. Svaki put kada treba da se izrenderuje komponenta na ekranu, pozove se funkcija i dobije se JSX. Ako se prop-ovi promene, pozove se opet i to je to. Mi iz funkcije nemamo 'pamćenje:' svako pokretanje je kao prvo. 
const Stopwatch1 = () => {
    return <div className="stopwatch-main">
        <TimeDisplay time={(new Date("1970-01-02T04:35:07Z")).valueOf()}/> 
        <button className="button reset">Reset</button>
        <button className="button lap">Lap</button>
        <button className="button start">Start</button>
    </div>;
}

export default Stopwatch1;