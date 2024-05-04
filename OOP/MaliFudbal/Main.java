package MaliFudbal;

import MaliFudbal.KlasaUtakmica.RezultatUtakmice;

public class Main {
	public static void main(String[] args) {
		// Kreiranje turnira
		KlasaTurnir klasaTurnir = new KlasaTurnir();
		ListaTimova listaTimova = new ListaTimova();
		ListaIgraca listaIgraca = new ListaIgraca();
		ListaUtakmica listaUtakmica = new ListaUtakmica();

		// Test tim
		KlasaTim tim1 = new KlasaTim("MiGazimo", "Grgurevci", 5);
		String imeTim1 = "MiGazimo";
		// Test igrac
		KlasaIgrac svezeMeso = new KlasaIgrac(
				"Djura", 
				"Surovi",
				"1234567890123",
				"MnogoSmoJaki"
		);

		// Test utakmice
		KlasaUtakmica utakmica1 = new KlasaUtakmica(
				"MnogoSmoJaki",
				"Kobasičari",
				RezultatUtakmice.NEODIGRANA
		);
		KlasaUtakmica utakmica2 = new KlasaUtakmica(
				"Kobasičari",
				"Banda",
				RezultatUtakmice.DRUGI_POBEDIO
		);
		KlasaUtakmica utakmica3 = new KlasaUtakmica(
				"MnogoSmoJaki",
				"Banda",
				RezultatUtakmice.PRVI_POBEDIO
		);
		KlasaUtakmica utakmica4 = new KlasaUtakmica(
				"MnogoSmoJaki",
				"Kobasičari",
				RezultatUtakmice.NERESENO
		);

		// Ucitavanje podataka o igracima i timovima iz ulaznih datoteka
		listaTimova.ucitajPodatkeOTimovima(klasaTurnir, "OOP\\MaliFudbal\\timovi.txt");
		listaIgraca.ucitajPodatkeOIgracima(klasaTurnir, "OOP\\MaliFudbal\\igraci.txt");

		// Simulacija igraci
		listaIgraca.dodajIgraca(svezeMeso);
		listaIgraca.obrisiIgraca(svezeMeso);
		listaIgraca.pronadjiIgracaPoJmbg("1234567890123");
		listaIgraca.pronadjiIgracaPoImenu("Djura");

		System.out.println("\n+ + + + + + + + + + + + + + + + + + + + + + + + + + +\n");

		// Simulacija timovi
		listaTimova.dodajTim(tim1);
		listaTimova.obrisiTim(tim1);
		listaTimova.pronadjiTim(imeTim1);

		System.out.println("\n+ + + + + + + + + + + + + + + + + + + + + + + + + + +\n");

		// Simulacija nekoliko odigranih i neodigranih utakmica
		listaUtakmica.dodajUtakmicu(utakmica1);
		listaUtakmica.obrisiUtakmicu(utakmica1);
		listaUtakmica.dodajUtakmicu(utakmica2);
		listaUtakmica.dodajUtakmicu(utakmica3);
		listaUtakmica.dodajUtakmicu(utakmica4);
		listaUtakmica.pronadjiUtakmicu("Kobasičari", imeTim1);

		System.out.println("\n+ + + + + + + + + + + + + + + + + + + + + + + + + + +\n");

		// Upis podataka o utakmicama u izlaznu datoteku utakmice.txt
		klasaTurnir.upravljanjeUtakmicama(utakmica2);
		klasaTurnir.upravljanjeUtakmicama(utakmica3);
		klasaTurnir.upravljanjeUtakmicama(utakmica4);
		klasaTurnir.upisPodatakaUDatoteku("OOP\\MaliFudbal\\utakmice.txt");

		System.out.println("\n+ + + + + + + + + + + + + + + + + + + + + + + + + + +\n");

		// Ispis podataka o fondu i nagradama u konzoli
		klasaTurnir.izracunajFondINagrade(listaTimova);
	}
}
