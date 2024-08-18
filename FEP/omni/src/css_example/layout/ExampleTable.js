// Primer kako se podaci mogu prikazati tabelarno, ukljucne i css

// obavezno uvezemo stil koji smo napravili u css datoteci
import './css_example_table.css';

const ExampleTable = () => {
   return <div className='container_table'> 
        <table className='table_students'>
            <caption>Spisak ucenika</caption>
            <tr> 
                <th> Prezime </th>
                <th> Ime </th>
                <th> JMBG </th>
                <th> Ime jednog roditelja </th>
            </tr>
            <tr> 
                <td> Aleksic </td>
                <td> Ana </td>
                <td> 12030057798110</td>
                <td> Tadija </td>
            </tr>
            <tr> 
                <td> Banic </td>
                <td> Bane </td>
                <td> 12110057799110</td>
                <td> Petar </td>
            </tr>
            <tr> 
                <td> Jankovic </td>
                <td> Jana </td>
                <td> 10030057789110</td>
                <td> Marko </td>
            </tr>
            <tr> 
                <td> Petrovic </td>
                <td> Petar </td>
                <td> 01010057798110</td>
                <td> Dusan </td>
            </tr>
        </table>
    </div>
}

export default ExampleTable;