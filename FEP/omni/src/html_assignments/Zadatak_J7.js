/*
    Napraviti stranicu koja odgovara primeru koji je dat.
    Slika je dostupna na sledećem linku: https://www.logo.wine/logo/Apache_Tomcat
*/
import slika from "./../assets/images/zad7.png";

const Zadatak_J7 = () => {
  return (
    <div>
      <h2> Zadatak 7</h2>
      <div className="zad_container">
        <div>
          <p> Prikazati tekst kao što je na slici: </p>
          <img src={slika} />
        </div>
        <div>{/* to do: ovde strukturirati tekst */}</div>
        <p> TO DO:</p>
      </div>
    </div>
  );
};

export default Zadatak_J7;
