/*
    Vi dolazite iz Jave, jezika koji je izuzetno objektno orijentisan, toliko da je nemoguće napisati bilo kakav program bez toga da koristite klasu. JavaScript nije ovakav: možete pisati izuzetno kompleksne programa a da nikada ne napišete klasu. Klase su za nas uglavnom opcione i koristimo ih samo kada od toga dobijemo nešto. 

    Sintaksa se znatno razlikuje od Jave ali su ideje gotovo identične. 

    Vodite računa da ovde pričamo o tkzv. ES6 klasama, koje su modernizovane i lake za upotrebu. Ako vidite online neke stare primere (čuvajte se da prvi Stack Overflow odgovor na Google rezultatima može vrlo lako da bude 10+ godina star) videćete potpuno drugačiji sistem za definisanje klasa. To ne koristimo niti treba da se danas koristi. 
*/

//Pravimo sve klase na isti način: kažemo class i koje je ime klase, baš kao u javi
//Za razliku od jave nemamo baš, ali baš nikakvo ograničenje u tome koliko imamo klasa po fajlu, kako se zove fajl, niti bilo šta slično.
class Boja {
    #r; //Ako hoćemo atribut samo treba da ga pomenemo u telu klase kao ovde. Ako atribut počinje sa # onda je privatan.
    #g;
    #b;
    constructor(r, g, b) {
        //Umesto da se zove isto kao i ime klase, konstruktor u JS-u se zove 'constructor'
        this.#r = r;
        this.#g = g;
        this.#b = b;
    }
    //Sintaksa za metode je vrlo jednostavna i slična je Javi, samo što nema povratnih tipova ni tipova argumenata
    //Bonus pitanje: da li je ovo dobra metoda, uzimajući u obzir šta radimo sa klasom kasnije?
    getFloatTriplet() {
        return [this.#r / 255, this.#g / 255, this.#b / 255];
    }

    toString() {
        return `(${this.#r}, ${this.#g}, ${this.#b})`;
    }

    //Evo nove stvari: umesto da koristimo klasične getX i setX metode kao u Javi (mada načisto možemo ako hoćemo) u JS-u koristimo drugačiju strukturu gde definišemo 'get' i 'set' za neko ime (ovde red) gde get ne prima parametre a set prima jedan. Tu napišemo logiku za očitavanje i nameštanje vrednosti i kasnije u kodu koristimo .red (ili koje god da smo ime dali) kao da je običan javni atribut. Možemo da ostavimo samo get, a ne set, u kom slučaju atribut ne može da se menja, samo očitava.
    get red() {
        return this.#r;
    }
    set red(r) {
        this.#r = r;
    }

    get green() {
        return this.#g;
    }
    set green(g) {
        this.#g = g;
    }

    get blue() {
        return this.#b;
    }
    set blue(b) {
        this.#b = b;
    }
}

//Nasleđivanje radi sa 'extends' kao i u Javi
class AlfaBoja extends Boja {
    #a;
    constructor(r, g, b, a) {
        super(r, g, b); //Ovo poziva konstruktor nadklase, baš kao i u Javi
        this.#a = a;
    }
    //Ništa posebno ne moramo da radimo da bi imali override
    toString() {
        return `(${this.red}, ${this.green}, ${this.blue}, ${this.#a})`;
    }

    get alpha() {
        return this.#a;
    }
    set alpha(a) {
        this.#a = a;
    }
}

const Objektno = () => {
    let b = new Boja(123, 123, 123);
    let ab = new AlfaBoja(64, 128, 255, 255);
    ab.red = 65;
    return (
        <table border={1}>
            <tr>
                <th>Izraz</th>
                <th>Vrednost</th>
            </tr>
            <tr>
                <td>
                    <pre>b.red</pre>
                </td>
                <td>{b.red}</td>
            </tr>
            <tr>
                <td>
                    <pre>b.getFloatTriplet()</pre>
                </td>
                <td>{JSON.stringify(b.getFloatTriplet())}</td>
            </tr>
            <tr>
                <td>
                    <pre>ab.red</pre>
                </td>
                <td>{ab.red}</td>
            </tr>
            <tr>
                <td>
                    <pre>b.toString()</pre>
                </td>
                <td>{b.toString()}</td>
            </tr>
            <tr>
                <td>
                    <pre>ab.toString()</pre>
                </td>
                <td>{ab.toString()}</td>
            </tr>
        </table>
    );
};

export default Objektno;
