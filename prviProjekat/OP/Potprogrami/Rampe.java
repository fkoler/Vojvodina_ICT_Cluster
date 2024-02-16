package Potprogrami;

/*Program za pracenje statistike rada naplatnih rampi na auto putu u nekom mesecu.
Ukupno ima 10 naplatnih rampi i svakog dana (pretpostaviti da ih je 30) belezi se broj automobila koji su prosli kroz tu rampu.
Program treba da omoguci:

1) izbor broja proslih automobila za zadatu rampu i dan.
2) Prikaz ukupnog broja automobila koji su prosli kroz izabranu rampu.
3) Prikaz kojim je sve danima proslo ukupno automobila vise od nekog broja automobila koje zadaje korisnik.
4) Izracunavanje i prikaz ukupnog broja automobila koji su tog meseca presli kroz rampe.
5) Meni iz kojeg se biraju ponuđene funkcije.

Obavezno koristiti funkcije za implementaciju trazenih funkcionalnosti.
Izabrati korektne tipove podataka i strukture podataka i ograniciti izbor tako da nije moguce uneti neispravne vrednosti. */

public class Rampe {
	/*
	private static final int DANI = 30;
	private static final int RAMPE = 10;
	private static int[][] ulazAutomobila = new int[DANI][RAMPE];
	 */
	
//	/* za testiranje hard coded	 
	private static final int DANI = 3;
	private static final int RAMPE = 5;
	private static int[][] ulazAutomobila = new int[][] {
		{ 150, 200, 250, 200, 150 },
		{ 100, 200, 300, 200, 100 },
		{ 100, 150, 200, 150, 100 } };

//	*/
	public static void main(String[] args) {
		int izbor;
		
		do {
			meniFunkcija();
			izbor = preuzmiChar("", "Neispravan izbor. Pokusajte ponovo.", '0', '4');

			switch (izbor) {
				case '0':
					System.out.println("\n\t Dovidjenja");
					break;
				case '1':
					unosAutomobiliRampaDan(ulazAutomobila);
					break;
				case '2':
					prikazAutomobiliRampa(ulazAutomobila);
					break;
				case '3':
					prikazDaniAutomobili(ulazAutomobila);
					break;
				case '4':
					prikazAutomobiliMesecRampa(ulazAutomobila);
					izlistajMatricu(ulazAutomobila, "Dan", "Rampa");
					break;
				default:
					break;
			}
			
		} while (izbor != '0');
	}

	// 5. Meni iz kojeg se biraju ponuđene funkcije.
	private static void meniFunkcija() {
		System.out.println("\n\t ** Program za pracenje statistike rada naplatnih rampi na auto putu u nekom mesecu **");
		System.out.println("\t\t\t\t      ** Izaberite opciju: **");
		System.out.println("\nOpcija 0: Izlazak iz programa.");
		System.out.println("Opcija 1: Unos broja proslih automobila za zadatu rampu i dan.");
		System.out.println("Opcija 2: Prikaz ukupnog broja automobila koji su prosli kroz izabranu rampu.");
		System.out.println("Opcija 3: Prikaz kojim je sve danima proslo ukupno automobila vise od nekog broja automobila.");
		System.out.println("Opcija 4: Izracunavanje i prikaz ukupnog broja automobila koji su tog meseca presli kroz rampe.");
	}

	static char preuzmiChar(String poruka, String greska, char donja, char gornja) {
		char izbor;
		
		do {
			System.out.println(poruka);
			izbor = TextIO.getlnChar();
			if (izbor < donja || izbor > gornja)
				System.out.println(greska);
		} while (izbor < donja || izbor > gornja);

		return izbor;
	}

	static int preuzmiInt(String poruka, String greska, int donja, int gornja) {
		int izbor;
		
		do {
			System.out.println(poruka);
			izbor = TextIO.getlnInt();
			if (izbor < donja || izbor > gornja)
				System.out.println(greska);
		} while (izbor < donja || izbor > gornja);

		return izbor;
	}

	// 1. Unos broja proslih automobila za zadatu rampu i dan.
	private static void unosAutomobiliRampaDan(int[][] ulazAutomobila) {
		int rampa, dan;
		char odg = 'n';

		do {			
			rampa = preuzmiInt("Unesite rampu br: \t", "Neispravan unos. Pokusajte ponovo. \t", 1, RAMPE);
			dan = preuzmiInt("Unesite dan: \t", "Neispravan unos. Pokusajte ponovo. \t", 1, DANI);

			System.out.printf("Unesite broj automobila za dan: %d na rampi br: %d \t", dan, rampa);			
			
			ulazAutomobila[dan-1][rampa-1] = TextIO.getlnInt();
			
			izlistajMatricu(ulazAutomobila, "Dan", "Rampa");
			
			System.out.println("Zelite ponovni unos? y/n \t");
			odg = TextIO.getChar();
		} while (odg == 'y');
	}

	// 2. Prikaz ukupnog broja automobila koji su prosli kroz izabranu rampu.
	private static void prikazAutomobiliRampa(int[][] ulazAutomobila) {
		int rampa = preuzmiInt("Unesite broj rampe: \t", "Greska, pokusajte ponovo \t", 1, RAMPE);

		int auto = 0;
		for (int i = 0; i < DANI; i++) {
			auto += ulazAutomobila[i][rampa - 1];
		}
		
		System.out.printf("Ukupno %d automobila prosli su kroz rampu broj: %d. \n", auto, rampa);
	}

	// 3. Prikaz kojim je sve danima proslo ukupno automobila vise od nekog broja automobila koje zadaje korisnik.
	private static void prikazDaniAutomobili(int[][] ulazAutomobila) {		
		int unos = preuzmiInt("Unesite broj automobila: \t", "Uneta vrednost mora biti veca od 0 \t", 0, 1000000);
		boolean odgovara = false;

		for (int i = 0; i < DANI; i++) {
			int auto = 0;
			for (int j = 0; j < RAMPE; j++) {
				auto += ulazAutomobila[i][j];
			}
			if (auto > unos) {
				System.out.printf("Na dan %d, ukupno je proslo %d automobila. \n", i + 1, auto);
				odgovara = true;
			}
		}
		
		if (!odgovara)
			System.out.println("Za uneti broj automobila nisu pronadjeni dani.");
	}

	// 4. Izracunavanje i prikaz ukupnog broja automobila koji su tog meseca presli kroz rampe.
	private static void prikazAutomobiliMesecRampa(int[][] ulazAutomobila) {
		int auto = 0;
		for (int i = 0; i < DANI; i++) {
			for (int j = 0; j < RAMPE; j++) {
				auto += ulazAutomobila[i][j];
			}
		}
		
		System.out.printf("Ukupno %d automobila je proslo kroz sve rampe u ovom mesecu.\n\n", auto);
	}

	// 4. Prikaz Matrice
	static void izlistajMatricu(int ulazAutomobila[][], String nazivVrste, String nazivKolone) {
		int i, j;
		int duzinaNazivaVrste = nazivVrste.length();
		
		ispisiPraznaMesta(duzinaNazivaVrste + 18);		
		System.out.println(nazivKolone);
		System.out.println(nazivVrste);

		for (i = 0; i < DANI; i++) {
			ispisiPraznaMesta(duzinaNazivaVrste + 2);
			for (j = 0; j < RAMPE; j++)
				System.out.printf("   %d   ", ulazAutomobila[i][j]);
			System.out.println();
		}
	}

	static void ispisiPraznaMesta(int brPraznihMesta) {
		for (int i = 0; i < brPraznihMesta; i++)
			System.out.print("  ");
	}
}
