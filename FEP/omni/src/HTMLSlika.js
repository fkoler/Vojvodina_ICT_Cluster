//     * <img> tag se koristi da se ugradi slika u HTML stranicu
//     * <img> tag je prazan tag koji sadrži samo atribute i zato ne zahteva zatvarajući tag (piše se ovako: <img/>)
//     * <img> tag ima dva atributa:
//          - src: definiše putanju do slike (obavezan atribut)
//                 putanja do slike može da bude:
//                      - apsolutna: link do slike koja je host-ovana na nekom drugom vebsajtu
//                      - relativna: link do slike koja je host-ovana u okviru našeg vebsajta.
//                                   (slika se nalazi u nekom direktorijumu u okviru našeg projekta)
//          - alt: definiše tekst koji će se prikazati na stranici ako slika nije dostupna (proizvoljan atribut)
//          - height (pikseli): definisanje visine i širine slike je poželjno kako stranica ne bi treperila dok se slika učitava
//          - width (pikseli): definisanje visine i širine slike je poželjno kako stranica ne bi treperila dok se slika učitava
//                   (pretraživač rezerviše mesto na stranici potrebno da se prikaže slika)

import picture from '../src/assets/images/programmer.jfif';

const HTMLSlika = () => {
    return (
        <div>
            <h1>Primer HTML stranice sa slikom</h1>
            <div>
                <h2>Funkcionalan link do slike - apsolutna putanja</h2>
                <img
                    src='https://media.gcflearnfree.org/content/5e31ca08bc7eff08e4063776_01_29_2020/ProgrammingIllustration.png'
                    height={200}
                    width={300}
                    alt='slika laptopa'
                />
            </div>
            <div>
                <h2>Funkcionalan link do slike - relativna putanja</h2>
                <img
                    src={picture}
                    height={200}
                    width={300}
                    alt='slika programera'
                />
            </div>
            <div>
                <h2>Nefunkcionalan link do slike</h2>
                <img
                    src='https://media.gcflearnfree.org/content/5e31ca08bc7eff08e4063776_01_29_2020/ProgrammingIllustration.pn'
                    height={200}
                    width={300}
                    alt='slika laptopa'
                />
            </div>
        </div>
    );
};
export default HTMLSlika;
