// Hajde da otkrijemo kako kroz JSX možemo da pišemo HTML
// Postoje fine tehničke razlike između JSX-a i HTML-a, ali su za nas, za sada, oni isto
// HTML služi da opiše _strukturu_ stranice: koji su joj delovi, i koji oni imaju funkciju.
// HTML se sastoji od teksta i tag-ova koje karakteriše da ih pišemo <ovako>. Tagovi mogu u sebi
// imati tekst i tada se otvaraju i zatvaraju, <tag>ovako</tag>.

const HTMLTekst = () => {
  //Div je način da u jedno objedinimo više tag-ova i komada teksta. Više o tome kasnije.
  return (
    <div>
      <h1>Ovo je prvi nivo naslova</h1>
      <h2>Ovo drugi</h2>
      <h3>Ovo treći</h3>
      <h4>Ovo četvrti</h4>
      <h5>Ovo je peti </h5>

      <p> Ovo je pasus</p>

      Tekst ne mora da bude u naslovu ili nekom posebnom tag-u, može se kucati
      direktno, kao ovde. Naslovi ne samo što organizuju tekst, oni tekstu i
      daju nekakav podrazumevan izgled. Bez obzira na to što ponekad utiče na
      izgled, HTML ne služi da se menja izgled tekstu, osim u par ograničenih
      slučajeva. Veliku, veliku većinu vremena, sa HTML definišemo strukturu, a
      sa nečim drugim poznatim kao CSS definišemo izgled, dok JS definiše
      ponašanje.
      <p>
        Možda ste primetili da, iako gornji tekst ima par 'enter' u sebi on je
        sav bio jedan ogroman pasus koji poziciju enter ignoriše. Ovo je
        podrazumevano ponašanje. Ako hoćemo poseban pasus, pišemo ga u jednom
        ovakvom p-tagu. P je naravno 'paragraph'
      </p>
      {/* Ovaj tekst se neće videti na stranici. Ovako se kucaju komentari koji su direktno u JSX-u. JavaScript sam ima iste komentare kao i Java. */}
      <p>
        Setite se kako smo rekli da postoji par slučajeva da se izgled ipak
        definiše u okviru HTML? To je slučaj sa oznakama <strong>strong</strong>{" "}
        i <em>em</em> koje čine tekst 'masnim' i iskošenim i poznatije su po
        svojim starijim imenima <b>b</b> i <i>i</i>. Ovo se koristi ne da se
        manipuliše izgledom iz estetskih razloga no da se neki tekst označi kao
        tekst koji je naročisto istaknut, a onda CSS odluči kako će to u stvari
        da izgleda.
      </p>
      Među stvarima koje možemo definisati u okviru HTML tu su i liste od kojih
      se najčešće koriste <em>neuređene</em> i <em>uređene</em> liste.
      <ul>
        <li>Neuređene liste nisu numerisane</li>
        <li>Umesto toga svaka stavka je samo tačka</li>
        <li>Liste mogu biti i višenivojske</li>
        <ul>
          <li>
            Štaviše, verovatno ste videli jednu baš takvu višenivojsku listu kad
            ste kliknuli na ovaj primer.
          </li>
          <li>
            Sve što je potrebno jeste da se jedan ul tag stavi u okviru drugog
          </li>
          <ul>
            <li>Ova tehnika se zove 'ugnježdavanje'</li>
            <li>Time se u HTML rešavaju razni problemi</li>
          </ul>
        </ul>
      </ul>
      <ol>
        <li>Uređene liste baš jesu numerisane</li>
        <li>Primarno sa brojevima, ali kada postanu višenivojske</li>
        <li>(Pošto mogu biti i višenivojske)</li>
        <ol>
          <li>Brojanje počinje od početka</li>
          <li>
            Inače su sasvim iste kao i neuređene liste samo se piše OL umestuo
            UL
          </li>
          <ol>
            <li>Elementi su i dalje 'li'</li>
            <li>Ovo čini liste prilično lakim za pisanje.</li>
          </ol>
        </ol>
      </ol>
      <p>
        Još jedna neobičnost koju moramo a obradimo jeste kako raditi sa
        neobičnim karakterima. Srećom pošto ovo radimo sa modernim editorom,
        možemo skoro bilo koji simbol da jednostavno otkucamo ovde i sve će
        raditi kako što je recimo slučaj ovde: 龍 ovo je Hanzi simbol za 'zmaj'
        i trebalo bi da se prikaže baš kako treba kroz Unicode/UTF-8 standard.
        Problem je kako ovo prikazati ako nas editor iznever ili ako nam treba
        karakter koji ima specijalno značenje u okviru JSX/HTML jezika. Onda nam
        mogu pomoći entiteti koji počinju sa ampersand simbolom pa ih onda prati
        ili ime ili znak '#' praćen jedinstvenim brojem Unicode simbola. Tako da
        možemo i da otkucamo &#40845; ali još bitnije možemo da otkucamo &lt; a
        da sistem ne misli da hoćemo da napišemo tag.
      </p>
      <p>
        U okviru našeg teksta možemo imati i linkove koji vode na neku drugu
        stranicu. Linkovi se predefinisano ponašaju tako da:
        <ul>
          <li>
            Neposećen <a href="https://sr.wikipedia.org/sr/Link_veza">link</a>{" "}
            je podvučen i plav.
          </li>
          <li>
            Posećen <a href="https://sr.wikipedia.org/sr/Link_veza">link</a> je
            podvčen i ljubičast.
          </li>
          <li>
            Aktivan <a href="https://sr.wikipedia.org/sr/Link_veza">link</a> je
            podvučen i crven.
          </li>
        </ul>
        Pored <strong>href</strong> atributa u koji definiše destinaciju link-a,
        možemo definisati i <strong>target</strong> atribut koji nam određuje
        kako će se link otvoriti.
        <ul>
          <li>
            _self vrednost je predefinisana i otvara{" "}
            <a href="https://sr.wikipedia.org/sr/Link_veza" target="_self">
              link
            </a>{" "}
            u istom prozoru u kome se nalazimo.
          </li>
          <li>
            _blank vrednost otvara{" "}
            <a href="https://sr.wikipedia.org/sr/Link_veza" target="_blank">
              link
            </a>{" "}
            u novom prozoru/tabu.
          </li>
          <li>
            _parent vrednost otvara{" "}
            <a href="https://sr.wikipedia.org/sr/Link_veza" target="_parent">
              link
            </a>{" "}
            u roditeljskom frejmu.
          </li>
          <li>
            _top vrednost otvara{" "}
            <a href="https://sr.wikipedia.org/sr/Link_veza" target="_top">
              link
            </a>{" "}
            u celom prozoru.
          </li>
        </ul>
      </p>
    </div>
  );
};

export default HTMLTekst;
