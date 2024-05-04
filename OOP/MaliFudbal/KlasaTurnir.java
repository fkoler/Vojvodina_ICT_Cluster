package MaliFudbal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KlasaTurnir {
	
    private ListaTimova listaTimova;
    private ListaIgraca listaIgraca;
    private ListaUtakmica listaUtakmica;

    // Konstruktor
    public KlasaTurnir() {
        this.listaTimova = new ListaTimova();
        this.listaIgraca = new ListaIgraca();
        this.listaUtakmica = new ListaUtakmica();
    }

    // Get metode
    public ListaTimova getListaTimova() {
		return listaTimova;
	}
    
    public ListaIgraca getListaIgraca() {
		return listaIgraca;
	}
    
    public ListaUtakmica getListaUtakmica() {
		return listaUtakmica;
	}
    
    // Set metode
	public void setListaTimova(ListaTimova listaTimova) {
		this.listaTimova = listaTimova;
	}
	
	public void setListaIgraca(ListaIgraca listaIgraca) {
		this.listaIgraca = listaIgraca;
	}	

	public void setListaUtakmica(ListaUtakmica listaUtakmica) {
		this.listaUtakmica = listaUtakmica;
	}

	// Metode za upravljanje timovima, igracima i utakmicama
	public void upravljanjeTimovima(KlasaTim klasaTim) {
        listaTimova.dodajTim(klasaTim);
    }

    public void upravljanjeIgracima(KlasaIgrac klasaIgrac) {
        listaIgraca.dodajIgraca(klasaIgrac);
    }

    public void upravljanjeUtakmicama(KlasaUtakmica klasaUtakmica) {
        listaUtakmica.dodajUtakmicu(klasaUtakmica);
    }

    // Metoda za izračunavanje i ispis ukupnog fonda takmičenja i iznosa nagrada
    public void izracunajFondINagrade(ListaTimova timovi) {
        ArrayList<KlasaTim> klasaTimovi = timovi.getTimovi();
        int brTimova = klasaTimovi.size();
        double fondTimova = 500 * brTimova;
        double fondIgraca = 0;

        for (KlasaTim tim : klasaTimovi) {
            fondIgraca += 100 * tim.getBrojIgraca();
        }

        double ukupanFond = fondTimova + fondIgraca;
        
        double prvaNagrada = ukupanFond * 0.5;
        double drugaNagrada = ukupanFond * 0.3;
        double trecaNagrada = ukupanFond * 0.1;

        System.out.println("Ukupan fond takmičenja: " + ukupanFond);
        System.out.println("1. nagrada: " + prvaNagrada);
        System.out.println("2. nagrada: " + drugaNagrada);
        System.out.println("3. nagrada: " + trecaNagrada);
    }

    // Metoda za upis podataka u datoteku
    public void upisPodatakaUDatoteku(String imeDatoteke) {
        try (FileWriter writer = new FileWriter(imeDatoteke)) {
            for (KlasaUtakmica klasaUtakmica : listaUtakmica.getUtakmice()) {
                writer.write(
                		klasaUtakmica.getPrviTim() + " vs " +
                		klasaUtakmica.getDrugiTim() + ", Rezultat: " +
                		klasaUtakmica.getRezultat() + "\n"
                );
            }
        } catch (IOException e) {
            System.err.println("Greška prilikom upisa podataka u datoteku.");
            e.printStackTrace();
        }
    }
}
