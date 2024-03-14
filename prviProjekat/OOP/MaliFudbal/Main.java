package MaliFudbal;

import MaliFudbal.KlasaUtakmica.RezultatUtakmice;

public class Main {
    public static void main(String[] args) {
        // Kreiranje turnira
        KlasaTurnir klasaTurnir = new KlasaTurnir();
        ListaTimova listaTimova = new ListaTimova();
        ListaIgraca listaIgraca = new ListaIgraca();        
        
        KlasaTim tim1 = new KlasaTim("MiGazimo", "Grgurevci", 5);
        String tim2 = "Kobasičari";
        
        KlasaIgrac svezeMeso = new KlasaIgrac("Djura", "Surovi", "1234567890123", "MnogoSmoJaki");
        KlasaIgrac zaBrisanje = new KlasaIgrac("Ana",  "Popović", "3110874698357", "Kobasičari");
       
        
        listaTimova.ucitajPodatkeOTimovima(klasaTurnir, "OOP\\MaliFudbal\\timovi.txt");        
        listaIgraca.ucitajPodatkeOIgracima(klasaTurnir, "OOP\\MaliFudbal\\igraci.txt");        
        
        listaIgraca.dodajIgraca(svezeMeso);
        listaIgraca.obrisiIgraca(zaBrisanje);
        listaIgraca.pronadjiIgraca("1234567890123");
        
        listaTimova.dodajTim(tim1);
        listaTimova.pronadjiTim(tim2);
        listaTimova.obrisiTim(tim1);
        // Dodavanje nekoliko odigranih i neodigranih utakmica
        dodajUtakmice(klasaTurnir);
        
     // Upis podataka o utakmicama u izlaznu datoteku utakmice.txt
        klasaTurnir.upisPodatakaUDatoteku("OOP\\MaliFudbal\\utakmice.txt");

        // Ispis podataka o fondu i nagradama na konzoli
        klasaTurnir.izracunajFondINagrade(listaTimova);

        
    }   

    // Metoda za dodavanje utakmica
    private static void dodajUtakmice(KlasaTurnir klasaTurnir) {
        // Simulacija dodavanja utakmica
        KlasaUtakmica utakmica1 = new KlasaUtakmica("MnogoSmoJaki", "Kobasičari", RezultatUtakmice.NEODIGRANA);
        KlasaUtakmica utakmica2 = new KlasaUtakmica("Kobasičari", "Banda", RezultatUtakmice.DRUGI_POBEDIO);
        KlasaUtakmica utakmica3 = new KlasaUtakmica("MnogoSmoJaki", "Banda", RezultatUtakmice.PRVI_POBEDIO);
        klasaTurnir.upravljanjeUtakmicama(utakmica1);
        klasaTurnir.upravljanjeUtakmicama(utakmica2);
        klasaTurnir.upravljanjeUtakmicama(utakmica3);
    }
}
