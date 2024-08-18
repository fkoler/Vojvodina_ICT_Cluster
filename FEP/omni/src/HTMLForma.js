//    * HTML forme služe tome da korisnik unese potrebne podatke, te da se ti podaci šalju dalje na neku obradu
//    * Svaka forma je jedan grupisan unos sa više ulaznih elemenata
//    * <form> tag služi za kreiranje HTML forme za unos podataka
//    * <form> element može da sadrži neki od sledećih elemenata:
//          - <input>
//          - <label>
//          - <textarea>
//          - <button>
//          - <select>
//          - <option>
//          - <fieldset>

//    * Unosi se definišu preko taga <input>,
//      a tip unosa se specificira preko atributa type koji može biti podešen na neku od sledećih vrednosti:
//          - text: običan tekst (defaultni)
//          - password: lozinka
//          - submit: dugme za upisivanje
//          - reset: dugme za resetovanje
//          - radio: dugme za izbor jedne od više vrednosti
//          - checkbox. "kućice" koje mogu biti popunjene ili ne
//          - button: dugme
//          - color: odabir boje
//          - date: odabir datuma
//          - email: unos adrese elektronske pošte
//          - number: unos broja

//    * <label> tag definiše labelu za <input> element
//    * <label> tag nije obavezan da bi unos podataka u formu bio uspešan (može da stoji i samo tekst bez labele)
//              međutim korisno je za korisnike čitača teskta i korisnike koji imaju problem sa time da kliknu na malu površinu
//    * for atribut <label> elementa mora biti jednak id-u input elementa na koji se odnosi kako bi oni bili povezani

//    * <textarea> definiše više-linijski unos teksta
//    * često se koristi za unos komentara, recenzija, itd.
//    * veličina <textarea> definiše se cols i rows atributima
//    * name atribut se koristi kako bi se podaci pokupili nakon što je forma submitovana

//    * <button></button> i <input type="button"/> razlikuju se po tome što <button> element može da sadrži tagove kao što su
//      <i>, <b>, <strong>, <br>, <img>, itd.

//    * <select> element se koristi za kreiranje drop-down liste
//    * <option> element se koristi unutar <select> elementa za definisanje mogućih opcija

//    * <fieldset> služi za grupisanje određenih elemenata u okviru forme
//    * <fieldset> iscrtava okvir oko datih elemenata

const HTMLForma = () => {
  return (
    <div>
      <h1>HTML - Forme</h1>
      <h2>Primer forme za registraciju korisnika</h2>
      <form action="" method="POST">
        <label>Ime:</label> <input type="text" />
        <label>Prezime: </label>
        <input type="text" />
        <br />
        <br />
        Datum rodjenja: <input type="date" />
        Broj godina: <input type="number" />
        <br />
        <br />
        Pol:
        <input type="radio" name="pol" value="m" />
        <label for="m"> M </label>
        <input type="radio" name="pol" value="z" />
        <label for="z"> Z </label>
        <br />
        <br />
        Napišite par reči o sebi:
        <br />
        <textarea name="description" rows="4" cols="50"></textarea>
        <br />
        <br />
        Email: <input type="email" />
        <br />
        <br />
        Lozinka: <input type="password" />
        <br />
        <br />
        Izaberite omiljenu boju: <input type="color" />
        <br />
        <br />
        <label for="upit">Za koju potrebu cete koristiti nas sajt:</label>
        <select name="upit" id="upit">
          <option value="skola">Škola</option>
          <option value="posao">Posao</option>
          <option value="razno">Razno</option>
        </select>
        <br />
        <br />
        <fieldset>
          Mesto prebivalista:
          <input type="checkbox" name="mp1" />
          <label for="mp1">Beograd</label>
          <input type="checkbox" name="mp2" />
          <label for="mp2">Novi Sad</label>
          <input type="checkbox" name="mp3" />
          <label for="mp3">Subotica</label>
        </fieldset>
        <br />
        <br />
        <input type="submit" /> <input type="reset" />
        <button type="button">Click Me!</button>
      </form>
    </div>
  );
};

export default HTMLForma;
