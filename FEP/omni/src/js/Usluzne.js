/*
    Ovo je dodatak na prvi primer koji preleće neke uslužne klase koje su prisutne u standardnoj JS biblioteci koje mogu pomoći prilikom implementacije stvari. Naravno, imamo celu moć NPM-a da preuzmemo biblioteke koje rade... praktično bilo šta, ali to je na meniju kasnije. 
*/

const p01_brojevi = () => {
    let ispis = [];
    let a = 1;
    let b = 4.23;
    // Brojevi rade, kao što smo rekli, slično u Javi samo što imamo jedan jedini tip, Number koji pokriva sve.
    let c = b / 0; //Deljenje sa nulom proizvodi specijalnu vrednost koja je beskonačno. Ovo je matematički pogrešno (deljenje sa nulom nije definisano) ali pomaže nam u programiranju da detektujemo da je situacija deljnje nenula vrednosti sa nulom.
    let d = 0 / 0;
    // Ponekad imamo vrednost koja je sasvim nedefinisana: ne teži ničemu, nismo u stanju da kažemo išta smisleno o tome, e to je za JavaScript posebna vrednost 'NaN' što znači 'not a number.'
    ispis.push(
        <tr>
            <td>a = {a}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>b = {b}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>c = {c}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>d = {d}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>isNaN(a) = {isNaN(a) ? 'true' : 'false'}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>isNaN(c) = {isNaN(c) ? 'true' : 'false'}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>isNaN(d) = {isNaN(d) ? 'true' : 'false'}</td>
        </tr>
    );
    // Imamo ugrađenu funkciju isNaN koja će proveriti da li je nešto NaN. Što nam ovo treba? Zato što NaN ima dve čudne osobine. Prvo je 'lepljiv' u smislu da ako interagujemo sa NaN na bilo koji način rezultat koji dobijemo je uvek NaN.
    ispis.push(
        <tr>
            <td>a + b = {a + b}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>a + c = {a + c}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>a + d = {a + d}</td>
        </tr>
    );
    // Druga osobina je to što, jedinstveno, NaN nije jednak sam sebi.
    ispis.push(
        <tr>
            <td>d == d = {d == d ? 'true' : 'false'}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>d === d = {d === d ? 'true' : 'false'}</td>
        </tr>
    );
    // Ove dve bizarne osobine su namenjene tome da, ako nešto pođe naopako, numerički govoreći, ta greška definitivno stigne do nas na način koji ne možemo da ignorišemo umesto da generiše rezultate koji izgledaju OK, čak i kada nisu.

    //Još jedan problem koji treba da razrešimo jeste da imamo string koji hoćemo da prebacimo u broj ako može (i da otkrijemo ako ne može). JS nam nudi dve funkcije: jednu za celobrojne vrednosti i jednu za vrednosti sa zarezom. Pazite da obe vraćaju Number, samo se razlikuju kako interpretiuraju ono što vide.

    let e = parseInt('42'); //Ovo će jednostavno tretirati string kao običan celi broj i konvertovati string u broj
    ispis.push(
        <tr>
            <td>e = parseInt("42") = {e}</td>
        </tr>
    );
    let f = parseInt('42', 6); //Možemo da specificiramo koju bazu hoćemo: ovo je u senarnom brojnom sistemo, tj. baza 6 gde brojimo 0, 1, 2, 3, 4, 5, 10, te je u tom sistemu 42 oznaka za broj koji u decimalnom zovemo 36. Možemo koristiti bilo koju bazu od 2 do 36. Obrnuta operacija od ove je .toString za Number kome prosledimo broj baze.
    ispis.push(
        <tr>
            <td>f = parseInt("42",6) = {f}</td>
        </tr>
    );
    let f_2 = f.toString(6);
    ispis.push(
        <tr>
            <td>f_2 = parseInt("42",6).toString(6) = {f_2}</td>
        </tr>
    );
    let g = parseInt('Dva'); // Ako napišemo nešto što JS ne zna da pročita dobijemo NaN.
    ispis.push(
        <tr>
            <td>g = parseInt("Dva") = {g}</td>
        </tr>
    );
    let h = parseFloat('70.43170744321'); //Naravno ovo radi i na float vrednostima
    ispis.push(
        <tr>
            <td>h = parseFloat("70.43170744321") = {h}</td>
        </tr>
    );

    //Ako sa svim ovim brojevima hođemo da uradimo neku kompleksniju matematiku to apsolutno možemo: Math ugrađeni objekat je pun funkcija koje rade razne korisne matematičke operacije.
    let tacke = [];
    let r = 2.54;
    for (let theta = 0; theta <= 2 * Math.PI; theta += 1.0) {
        tacke.push(
            JSON.stringify({ x: r * Math.sin(theta), y: r * Math.cos(theta) })
        );
    }
    ispis.push(
        <tr>
            <td>Tacke kruga: [{tacke.join(',')}]</td>
        </tr>
    ); //Join smo pominjali, to je obrnuto od split: gde split nađe sva mesta gde se nalazi separator, podeli po njima i napravi niz, join uzme niz i umetne između elemenata separator koji mi specificiramo.

    return <table border={1}>{ispis}</table>;
};

const p02_JSON = () => {
    /*
        Već smo savladali malo o tome kako da radimo sa JSON ovde. .stringify pretvara objekat u njegovu string reprezentaciju, a operacija .parse radi obrnuto: uzme string predstavu JSON-a i pretvori ga u objekat.
    */
    let ispis = [];
    let obj = { x: 40, y: 50 };
    let json_obj = JSON.stringify(obj);
    let obj2 = JSON.parse(json_obj);
    //let obj3 = JSON.parse("Ovo ne valja");
    // Ovo je zakomentarisano zato što baca grešku. Otkomentarišate i probajte!
    ispis.push(
        <tr>
            <td>json_obj = {json_obj}</td>
        </tr>
    );
    ispis.push(
        <tr>
            <td>
                obj2.x = {obj2.x}; obj2.y = {obj2.y}
            </td>
        </tr>
    );
    // Ono što može da bude problem jeste šta raditi kada imamo objekat koji hoćemo da pretvorimo u JSON koji nema standardan način za reprezentaciju. Divan primer za to je Map koji JS takav-kakav je ne zna da pretvori u JSON. Onda to moramo da uradimo mi. Više o tome kako to možemo da uradimo u sledećem primeru.
    return <table>{ispis}</table>;
};

const p03_Datum = () => {
    /*
        JS ima ugrađen mehanizam za korišćenje datuma koji je dobar za prvu pomoć mada postoje bolje metode kroz posebne biblioteke o kojima više kasnije. Centralna ideja jeste da klasa 'Date' uvek čuva vreme kao broj milisekundi koji je prošao od 00:00:00, prvog januara 1970 u UTC vremenskoj zoni. Kada zatražimo datum u string formi onda se on formatira u skladu sa našim zahtevima i u našoj vremenskoj zoni. 
    */
    let d1 = new Date(); //Ovo je tekući datum
    let d2 = new Date('2022-03-13T17:30:00.000'); //Ovo generiše datum na osnovu stringa koji mora biti (za pouzdane rezultate) u ISO8601 formatu što znači godina (četiri cifre), te indeks meseca (dve cifre), te dan u mesecu (dve cifre) te slovo T te sati, dvotačka, minuti, dvotačka, sekunde, dtačka tri cifre milisekundi, i konačno vremenska zona specifcirana kao plus ili minus praćen sa satima, dvotačkom, i minutima ili slovom Z što znači da je vreme u UTC. Ako se ne specificira mesec ili dan podrazumeva se 1. Ako se ne specificira sat, minut, sekunda ili milisekunda onda je to nula. Ako se ne specificra vremenska zona onda se za datume podrazumeva UTC, a za kombinaicije datuma i vremena (kao ovde) podrazumeva lokalna vremenska zona.
    //Date se može modifikovati tako što se pozivaju .get i .set metode za različite komponente.
    d2.setMilliseconds(d2.getMilliseconds() + 350); // Ovo poveća broj milisekundi i ništa više za 350ms.
    return (
        <table border={1}>
            <tr>
                <td>
                    d1 = {d1.toString()} (lokalni format) = {d1.toISOString()}{' '}
                    (ISO standardni format) = {d1.valueOf()} (u milisekundama od
                    početka epohe)
                </td>
            </tr>
            <tr>
                <td>
                    d2 = {d2.toString()} (lokalni format) = {d2.toISOString()}{' '}
                    (ISO standardni format) = {d2.valueOf()} (u milisekundama od
                    početka epohe)
                </td>
            </tr>
        </table>
    );
};

const Usluzne = () => {
    return <div>{p01_brojevi()}</div>;
};

export default Usluzne;
