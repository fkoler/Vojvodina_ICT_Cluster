//Ovo je najprostiji mogući React primer - Samo prikazuje poruku 'Hello World!' 
//Uprkos tome sastoji se od mnogo delova i neki od njih nam nisu još jasni
const HW = () => {
// Nismo još spremni da razumemo liniju gore 100%, ali ovim definišemo funkciju: strukturu u JS
// jeziku koja mapira nešto (ovde je to prazno) na nešto drugo. Razumećete detalje kasnije. 
    return <h1>Hello World!</h1>;
// Ova linija bi trebala da je poznatija: 'return' radi isto što i u Javi: dakle vraćamo nešto
// Specifično vraćamo iskaz u jeziku JSX koji je način da se u okviru ovog jezika, JavaScript-a
// Može pisati HTML: jezik koji definiše strukturu Web stranica. 
// Ova linija je jednostavna: Vrati tekst Hello World! koji ima strukturu (i izgled!) 'h1' 
// Ovo je naslov prvog, odnosno, najvišeg reda. 
}

export default HW;
// Ovo je još jedna stvar koja nam neće biti odmah jasna: ovo služi da kada neko zatraži šta ima u ovom fajlu
// dobije baš HW.