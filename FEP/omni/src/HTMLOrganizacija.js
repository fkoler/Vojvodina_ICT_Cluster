//    *** <div> ***
//
//    * <div> element potiče od reči division/divide i služi tome da izdelimo/podelimo
//      našu stranicu na određene grupe tagova po izboru tj. na blokove
//    * <div> tag u suštini ne radi **NIŠTA**
//    * <div> tag dobija smisao tek kada na njega primenimo ili CSS kako bismo stilizovali dati blok teksta ili
//      JavaScript kako bi dati blok dobio određenu funkcionalnost
//    * unutar <div> taga možemo staviti bilo koji drugi sadržaj (bilo koji drugi tag)
//    * <div> tag je block-level (blokovski) element odnosno predefinisano je da pretraživači postavljaju liniju razmaka pre i posle <div> taga
//
//    PRIMER 1: BLOK A i BLOK B demonstriraju kako samo postojanje <div> taga ne utiče na izgled naše stranice
//           (BLOK A i BLOK B se prikazuju identično iako su tagovi u BLOK-u B obuhvaćeni tagom <div>)
//    PRIMER 2: BLOK C demonstrira kako izgleda stranica kada se na <div> tag primene određeni stilovi
//           (više o stilizovanju u narednim lekcijama)
//
//    *** <span> ***
//
//    * <span> element služi za markiranje manjeg dela teksta/dokumenta
//    * <span> tag isto kao i <div> u suštini ne radi **NIŠTA**
//    * <span> tag dobija smisao tek kada na njega primenimo ili CSS kako bismo stilizovali dati deo teksta ili
//    JavaScript kako bi dati deo teksta dobio određenu funkcionalnost.
//    * <span> tag je inline (linijski) element odnosno ovaj element ne podrazumeva početak nove linije već nastavak postojeće (PRIMER 4)
//
//    PRIMER 3: BLOK D demonstrira kako span tag ne utiče na izgled naše stranice pre nego što se primeni CSS ili JavaScript na njega.
//    PRIMER 4: BLOK E demonstrira razliku između <div> i <span> taga.

const HTMLOrganizacija = () => {
  return (
    <>
      {/* BLOK A */}
      {/* tagovi koji nisu grupisani sa tagom <div> */}

      <h1>Ovo je naslov</h1>
      <p>Ovo je prvi paragraf.</p>
      <p>Ovo je drugi paragraf.</p>

      {/* horizontalna linija koja slući za odvajanje dva teksta*/}
      <hr />

      {/* BLOK B */}
      {/* tagovi grupisani sa tagom <div> */}

      <div>
        <h1>Ovo je naslov</h1>
        <p>Ovo je prvi paragraf.</p>
        <p>Ovo je drugi paragraf.</p>
      </div>

      <hr />

      {/* BLOK C */}
      {/* tagovi koji su grupisani sa tagom <div> kako bi se stilizovao dati blok tagova u okviru naše stranice*/}

      <div
        style={{
          backgroundColor: "lightblue",
          color: "darkblue",
          padding: "5px",
          textAlign: "center",
        }}
      >
        <h1>Ovo je naslov</h1>
        <p>Ovo je prvi paragraf.</p>
        <p>Ovo je drugi paragraf.</p>
      </div>

      <hr />

      {/* BLOK D */}
      {/* demonstracija span taga*/}

      <div style={{ padding: 10 }}>
        <div>Primer teksta bez span tag-a.</div>
        <div>
          Primer teksta sa <span>span</span> tag-om.
        </div>
        <div>
          Primer teksta sa <span style={{ color: "red" }}>span</span> tag-om.
        </div>
      </div>

      <hr />

      {/* BLOK E*/}

      <div style={{ padding: 10 }}>
        <div>
          Div i span tag se razlikuju po tome što je div{" "}
          <div style={{ color: "green" }}>block-level</div>
          element, a span <div style={{ color: "orange" }}>inline</div> element.
        </div>

        {/*prikazuje jednu praznu liniju*/}
        <br />

        <div>
          Div i span tag se razlikuju po tome što je div
          <span style={{ color: "green" }}> block-level </span>
          element, a span <span style={{ color: "orange" }}>inline</span>{" "}
          element.
        </div>
      </div>
    </>
  );
};

export default HTMLOrganizacija;
