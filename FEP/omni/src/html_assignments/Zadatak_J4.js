/*
Kreirati formu za unos podataka na osnovu slike koja je data u prilogu kada se otvori stranica. 
Zahtevi
    • Ime i vrednost potrebno je izabrati parametre ime i vrednost za elemente forme.
    • Akcija koristiti akciju https://cscie12.dce.harvard.edu/echo
    • Metod koristiti post metod
    • Legenda koristiti skup polja i legende da biste grupisali obrazac u odeljke
    • Labele kreirati labele za sve tekst, radio i checkbox polja
    • Dani i sendviči u redu je navesti sve dane u nedelji kao što to čini papirni obrazac.
      Omogućavanje izbora „Petkom“ dostupnog samo u petak je vrsta potvrde obrasca
      koja je izvan opsega ovog zadatka.
    • Polja za unos:
        • Tekstualno polje za unos imena
        • Radio dugme za here/to go, izbor sendviča i užine
        • Checkbox dugme za izbor hrane sa glutenom i veliki izbor pića
        • Padajući meni za izbor pića
CSS zahtevi:
    - formu dizajnirati po zelji
*/
import slika from './../assets/images/zad4.PNG';
import './zadatak4_css.css';
const Zadatak_J4 = () => {
  return <div>
    <h2 className="z4_h2"> Zadatak 4</h2>
    <div className='zad_container'>
      <div> 
     
          <img src={slika}/>
      </div>
      <div>
      <h1>Lunch special</h1>

<h3>monday thru friday, 11 am ~ 3pm</h3>

<h3>$9.95</h3>



<form action="https://cscie12.dce.harvard.edu/echo" method="post">


  <br></br>
  <br></br>
  <label for="ime">Ime</label>
  <input type="text" name="ime"></input>
  <label for="Prezime">Prezime</label>
  <input type="text" name="prezime"></input>
  <br></br>
  <br></br>

  
  <fieldset>
  <h3>sandwiches:</h3>
<p className="z4_p">Monday: </p>
<label for="Tommato">Tommato Mozarela</label>
  <input type="radio" name="Tommato" value="Tommato"></input>
  <label for="Tommato"></label>

  <label for="Chicken">Chicken Salat</label>
<input type="radio" name="Tommato" value="Chicken"></input>
<label for="Chicken"></label>

<p className="z4_p">Tuesday:</p>
 
<label for="Greek">Greek Salad Wrap</label>
<input type="radio" name="Greek" value="Greek"></input>
<label for="Greek"></label>

<label for="Toto">Toto Wrap</label>
<input type="radio" name="Greek" value="Toto"></input>
<label for="Toto"></label>

<p className="z4_p">Wednesday:</p>

<label for="Red">Red Pepper Hummus</label>
<input type="radio" name="Red" value="Red"></input>
<label for="Red"></label>

<label for="Roasted">Roasted Turkey</label>
<input type="radio" name="Red" value="Roasted"></input>
<label for="Roasted"></label>

<p className="z4_p">Thursday:</p>

<label for="Carrot">Carrot-Ginger Hummus Wrap</label>
<input type="radio" name="Carrot" value="Carrot"></input>
<label for="Carrot"></label>

<label for="Egg">Egg Salad</label>
<input type="radio" name="Carrot" value="Egg"></input>
<label for="Egg"></label>

<p className="z4_p">Friday:</p>

<label for="Dado">Dado Wrap</label>
<input type="radio" name="Dado" value="Dado"></input>
<label for="Dado"></label>

<label for="Tuna">Tuna Salad</label>
<input type="radio" name="Dado" value="Tuna"></input>
<label for="Tuna"></label>
<br></br>
<br></br>
Gluten Free Bread 75c
<input type="checkbox" name="mp1" />
<label for="mp1"></label>
</fieldset>
<fieldset>

<h3>Snacks:</h3>

<input type="checkbox" name="mp1" />
<label for="mp1">Apple</label>
<input type="checkbox" name="mp2" />
<label for="mp2">Bannana</label>
<input type="checkbox" name="mp3" />
<label for="mp3">Potato Chips</label>
</fieldset>
<br></br>
  <br></br>
  <h3>Drinks</h3>
  <fieldset>
  <label for="Pica">Regular Sized Drinks</label>
  <select name="Pica">
    <option value="Kafa">Coffee or Iced Coffee</option>
    <option value="Sok od Jabuke">Organic Peppermint</option>
    <option value="Sok od Narandze">Hot or Iced Sencha Green Tea</option>
    <option value="Ledeni caj">Hot or Iced Keenmun Black Tea</option>
  </select>

  <input type="checkbox" name="Bubble" />
<label for="Bubble">$1.50 extra for any regular size Bubble Tea</label>
<input type="checkbox" name="Large" />
<label for="Large">75c extra for Large Drink</label>

</fieldset>

<h3>- NO SUBBSTITUTIONS -</h3>
<br></br>
  <br></br>
  <input type="submit" value="Submit"></input>

</form>

    </div>
    </div>
    

   
  </div>

}

export default Zadatak_J4;