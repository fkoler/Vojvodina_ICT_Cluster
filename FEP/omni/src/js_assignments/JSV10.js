/* 
    Napisati program koji dobije početnu poziciju (kao x i y) i orijentaciju (N, S, W, E) Lengtonovog mrava https://en.wikipedia.org/wiki/Langton%27s_ant (videti i na slajdovima) i broj generacija i vrati poziciju i orijentaciju mrava posle toliko generacija. 

    Pravila Lengtonovog mrava (za nas):
    1. Svet je beskonačna 2D ravan podeljena na kvadrate jednake veličine koji mogu biti beli ili crni. 
    2. Negde u svetu je mrav. Mrav ima poziciju i rotaciju. 
    3. U svakom potezu (ili generaciji) mrav prati sledeća pravila:
        a. Ako stoji na polju koje je belo, mrav se okrene za 90 stepeni u smeru kazaljke na satu, promeni boju ispod sebe iz bele u crnu i pomeri se napred za jedan korak. 
        b. Ako stoji na polju koje je crno, mrav se okrene za 90 stepeni u smeru suprotnom od kazaljke na satu, promeni boju ispod sebe iz crne u belu i pomeri se napred za jedan korak.
    4. Na početku igre, ceo svet je crn. 

    Lengtonov mrav je primer teoretske tvorevine poznate kao 'ćelijski automat' i ima kolosalan značaj u teoretskim računarskim naukama. Za nas je to odlična vežba veštine programiranja. 
*/


const JSV10 = () => {
  return <div>
  </div>;
};

export default JSV10;
