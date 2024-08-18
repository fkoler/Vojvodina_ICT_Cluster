import "./css_example_form.css";
// Primer primene CSS-a na formu
const ExampleForm = () => {
  return (
    <div className="container-form">
      <h2>Primer forme za registraciju korisnika</h2>
      <form action="" method="POST" className="form-container">
        <label className="label">Ime:</label>{" "}
        <input className="input-field text-field" type="text" />
        <label className="label">Prezime: </label>
        <input type="text" className="input-field text-field" />
        <label className="label">Datum rodjenja:</label>{" "}
        <input type="date" className="input-field text-field" />
        <lable className="label">Broj godina:</lable>{" "}
        <input type="number" className="input-field text-field" />
        <label className="label">Pol:</label>
        <div className="input-field radio-button-container">
          <div>
            {" "}
            <input type="radio" name="pol" value="m" />
            <label for="m"> M </label>{" "}
          </div>
          <div>
            <input type="radio" name="pol" value="z" />
            <label for="z"> Z </label>
          </div>
          
        </div>
        <label className="label"> Napišite par reči o sebi: </label>
        <textarea
          name="description"
          rows="4"
          cols="50"
          className="input-field text-field"
        ></textarea>
        <label className="label">Email:</label>{" "}
        <input type="email" className="input-field text-field" />
        <label className="label">Lozinka:</label>{" "}
        <input type="password" className="input-field text-field" />
        <label className="label">Izaberite omiljenu boju:</label>{" "}
        <input type="color" className="input-field text-field" />
        <label for="upit" className="label">Za koju potrebu cete koristiti nas sajt:</label>
        <select name="upit" id="upit" className="input-field select-field">
          <option value="skola">Škola</option>
          <option value="posao">Posao</option>
          <option value="razno">Razno</option>
        </select>
        <label className="label">Mesto prebivalista:</label>
        <fieldset className="input-field checkbox-container" >
            <div>
                <input type="checkbox" name="mp1" />
                <label for="mp1">Beograd</label>
            </div> 
            <div> 
                <input type="checkbox" name="mp2" />
                <label for="mp2">Novi Sad</label>
            </div>
            <div> 
                <input type="checkbox" name="mp3" />
                <label for="mp3">Subotica</label>
            </div>
          
        </fieldset>
        <input type="submit" className="button submit-btn" />
        <input type="reset" className="button" />
        <button type="button" className="button click-btn">Click Me!</button>
      </form>
    </div>
  );
};

export default ExampleForm;
