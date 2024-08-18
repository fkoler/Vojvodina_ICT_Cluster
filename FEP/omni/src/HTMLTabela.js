//     * tabela u HTML-u predstavlja skup ćelija organizovan u redove i kolone
//     * <table> element definiše tabelu
//     * <td> (table data) je element koji označava jednu ćeliju u tabeli
//     * <tr> (table row) je element koji označava jedan red u tabeli
//            - tabela može da ima proizvoljan broj redova
//     * <th> (table header) je element koji označava zaglavlje tabele
//            - ako je potrebno da neka ćelija u tabeli označava zaglavlje tabele tj. da bude jače naglašena
//              umesto td taga koristimo th tag
const HTMLTabela = () => {
  return (
    <div>
      <h1>Tabele u HTML-u</h1>

      {/*Primer tabele bez zaglavlja*/}

      <table>
        <tr>
          <td>Podatak 1</td>
          <td>Podatak 2</td>
          <td>Podatak 3</td>
        </tr>
        <tr>
          <td>Podatak 4</td>
          <td>Podatak 5</td>
          <td>Podatak 6</td>
        </tr>
      </table>

      <br />
      <br />
      <br />

      {/*Primer tabele sa zaglavljem*/}

      <table>
        <tr>
          <th>Kolona 1</th>
          <th>Kolona 2</th>
          <th>Kolona 3</th>
        </tr>
        <tr>
          <td>Podatak 1</td>
          <td>Podatak 2</td>
          <td>Podatak 3</td>
        </tr>
        <tr>
          <td>Podatak 4</td>
          <td>Podatak 5</td>
          <td>Podatak 6</td>
        </tr>
      </table>
    </div>
  );
};

export default HTMLTabela;
