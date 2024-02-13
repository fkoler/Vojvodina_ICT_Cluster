package Potprogrami;

/* 1.Program za praćenje poslovanja agenta za osiguranje
• Evidencija prodaje osiguranja orgranizovana je u 5 kategorija i beleži se za
  svaki dan u mesecu (pretpostaviti da ih je 30).
• Program treba da omogući:

• Unos ostvarenog prihoda za zadatu kategoriju osiguranja i dan u mesecu.
• Izmenu ostvarenog prihoda za zadatu kategoriju osiguranja i dan u mesecu.
• Prikaz rezultata sortiran po kategorijama osiguranja za izabrani dan u mesecu.
• Prikaz rezultata sortiran po danima u mesecu za izabranu kategoriju.
• Izračunavanje i prikaz dana kad je ostvaren najmanji prihod i koliko on iznosi.
• Izračunavanje i prikaz ukupnog mesečnog prihod za svaku kategoriju osiguranja.
• Izračunavanje i prikaz prosečnog mesečnog prihoda.
• Meni iz kojeg se biraju ponuđene funkcije.

• Obavezno koristiti funkcije za implementaciju traženih funkcionalnosti.
• Izabrati korektne tipove podataka i strukture podataka i ograničiti unos tako da
  nije moguće uneti neispravne vrednosti. */

public class Osiguranje {

	static final int DANI = 3;
	static final int KATEGORIJE = 5;

	public static void main(String[] args) {

		double[][] evidOsig = new double[][] {{ 100, 57, 88, 74, 123 }, 
											  { 158, 157, 828, 76, 323 },
											  { 103, 257, 85, 70, 523 }};

		// double[][] evidOsig = new double[DANI][KATEGORIJE];
		char izbor = '0';
		do {

			// meni
			ispisMeni();

			// izbor
			izbor = preuzmiChar("", "Morate odabrati vrednost u opsegu od 0-8", '0', '8');

			switch (izbor) {
			case '1':
				unosPrihoda(evidOsig);
				break;
			case '2':
				povecajPrihod(evidOsig);
				break;
			case '3':
				sortiraniPrikazKategorijaZaDan(evidOsig);
				break;
			case '4':
				sortiraniPrikazDanaZaKategoriju(evidOsig);
				break;
			case '5':
				danSaNajmanjimPrihodom(evidOsig);
				break;
			case '6':
				prihodPoKategorijama(evidOsig);
				break;
			case '7':
				mesecniPrihod(evidOsig);
				break;
			case '8':
				izlistajMatricu(evidOsig, "Dan", "Kategorija");
			}

		} while (izbor != '0');

	}

	static void ispisMeni() {
		System.out.println("--Program za vođenje evidencije agenta osiguranja--");
		System.out.println("  Izaberite jednu od opcija->");
		System.out.println("\t0. Izlazak iz programa");
		System.out.println("\t1. Unos prihoda za željenu kategoriju i željeni dan");
		System.out.println("\t2. ....");
		System.out.println("\t3. ....");
		System.out.println("\t4. ....");
		System.out.println("\t5. ....");
		System.out.println("\t6. ....");
		System.out.println("\t7. ....");
		System.out.println("\t8. ....");
	}

	static char preuzmiChar(String poruka, String porukaGreska, char dole, char gore) {
		char vred = '0';
		do {
			System.out.println(poruka);
			vred = TextIO.getlnChar();
			if (vred < dole || vred > gore)
				System.out.println(porukaGreska);
		} while (vred < dole || vred > gore);

		return vred;
	}

	static int preuzmiInt(String poruka, String porukaGreska, int dole, int gore) {
		int vred = 0;
		do {
			System.out.println(poruka);
			vred = TextIO.getlnInt();
			if (vred < dole || vred > gore)
				System.out.println(porukaGreska);
		} while (vred < dole || vred > gore);

		return vred;
	}

	static void unosPrihoda(double[][] eo) {
		int dan, kat;
		char odg = 'n';

		do {
			dan = preuzmiInt("Unesite dan za koji unosite prihod", "Dan mora biti u opsegu 1-" + DANI, 1, DANI);
			kat = preuzmiInt("Unesite kategoriju za koju unosite prihod",
					"Kategorija mora biti u opsegu 1-" + KATEGORIJE, 1, KATEGORIJE);
			System.out.println("Unesite prihod za " + dan + ". i kategoriju " + kat + ":");
			eo[dan - 1][kat - 1] = TextIO.getlnDouble();
			izlistajMatricu(eo, "Dan", "Kategorija");
			System.out.println("Za unos još jednog prihoda pritisnite taster d");
			odg = TextIO.getlnChar();
		} while (odg == 'd' || odg == 'D');
	}

	static void povecajPrihod(double[][] eo) {
		int dan, kat;
		char odg = 'n';

		do {
			dan = preuzmiInt("Unesite dan za koji povećavate prihod", "Dan mora biti u opsegu 1-" + DANI, 1, DANI);
			kat = preuzmiInt("Unesite kategoriju za koju povećavate prihod",
					"Kategorija mora biti u opsegu 1-" + KATEGORIJE, 1, KATEGORIJE);
			System.out.println("Unesite povećanje prihoda za " + dan + ". i kategoriju " + kat + ":");
			eo[dan - 1][kat - 1] += TextIO.getlnDouble();
			izlistajMatricu(eo, "Dan", "Kategorija");
			System.out.println("Za unos još jednog prihoda pritisnite taster d");
			odg = TextIO.getlnChar();
		} while (odg == 'd' || odg == 'D');
	}

	static void prikazDanaZaKategoriju(double[][] eo) {
		int kat;
		char odg = 'n';
		do {
			kat = preuzmiInt("Unesite kategoriju za koju povećavate prihod",
					"Kategorija mora biti u opsegu 1-" + KATEGORIJE, 1, KATEGORIJE);

			System.out.println("Prodaja kategorije " + kat + " po danima izgleda:");
			for (int i = 0; i < DANI; i++)
				System.out.println("Dan " + (i + 1) + ": " + eo[i][kat - 1]);

			System.out.println("Za unos još jednog prihoda pritisnite taster d");
			odg = TextIO.getlnChar();
		} while (odg == 'd' || odg == 'D');
	}

	static void sortiraniPrikazDanaZaKategoriju(double[][] eo) {
		double[] sortDani = new double[DANI];
		int[] indeksSortDani = new int[DANI];
		int kat;
		char odg = 'n';

		do {
			kat = preuzmiInt("Unesite kategoriju za koju povećavate prihod",
					"Kategorija mora biti u opsegu 1-" + KATEGORIJE, 1, KATEGORIJE);

			for (int i = 0; i < DANI; i++) {
				sortDani[i] = eo[i][kat - 1];
				indeksSortDani[i] = i;
			}

			sortirajNizove(sortDani, indeksSortDani, DANI);
			System.out.println("Prodaja kategorije " + kat + " po danima izgleda:");
			for (int i = 0; i < DANI; i++)
				System.out.println("Dan " + (indeksSortDani[i] + 1) + ": " + sortDani[i]);

			System.out.println("Za unos još jednog prihoda pritisnite taster d");
			odg = TextIO.getlnChar();
		} while (odg == 'd' || odg == 'D');
	}

	static void prikazKategorijaZaDan(double[][] eo) {
		int dan;
		char odg = 'n';
		do {
			dan = preuzmiInt("Unesite dan za koji povećavate prihod", "Dan mora biti u opsegu 1-" + DANI, 1, DANI);
			System.out.println("Prodaja kategorija za " + dan + ". dana izgleda:");
			for (int i = 0; i < KATEGORIJE; i++)
				System.out.println("Kategorija " + (i + 1) + ": " + eo[dan - 1][i]);

			System.out.println("Za unos još jednog prihoda pritisnite taster d");
			odg = TextIO.getlnChar();
		} while (odg == 'd' || odg == 'D');
	}

	static void sortiraniPrikazKategorijaZaDan(double[][] eo) {
		int dan;
		char odg = 'n';

		double[] sortKategorije = new double[KATEGORIJE];
		int[] indeksSortKategorije = new int[KATEGORIJE];

		do {
			dan = preuzmiInt("Unesite dan za koji povećavate prihod", "Dan mora biti u opsegu 1-" + DANI, 1, DANI);

			for (int i = 0; i < KATEGORIJE; i++) {
				sortKategorije[i] = eo[dan - 1][i];
				indeksSortKategorije[i] = i;
			}
			// sortiranje
			/*
			 * for (int i = 0; i < KATEGORIJE-1; i++) for (int j = i+1; j < KATEGORIJE; j++)
			 * { if(sortKategorije[i] < sortKategorije[j]) { double tmpD =
			 * sortKategorije[i]; sortKategorije[i] = sortKategorije[j]; sortKategorije[j] =
			 * tmpD;
			 * 
			 * int tmpI = indeksSortKategorije[i]; indeksSortKategorije[i] =
			 * indeksSortKategorije[j]; indeksSortKategorije[j] = tmpI; } }
			 */

			sortirajNizove(sortKategorije, indeksSortKategorije, KATEGORIJE);
			System.out.println("Prodaja kategorija za " + dan + ". dana izgleda:");
			for (int i = 0; i < KATEGORIJE; i++)
				System.out.println("Kategorija " + (indeksSortKategorije[i] + 1) + ": " + sortKategorije[i]);

			System.out.println("Za unos još jednog prihoda pritisnite taster d");
			odg = TextIO.getlnChar();
		} while (odg == 'd' || odg == 'D');
	}

	static void sortirajNizove(double[] sortVred, int[] sortIndeks, int brEl) {
		for (int i = 0; i < brEl - 1; i++)
			for (int j = i + 1; j < brEl; j++) {
				if (sortVred[i] < sortVred[j]) {
					double tmpD = sortVred[i];
					sortVred[i] = sortVred[j];
					sortVred[j] = tmpD;

					int tmpI = sortIndeks[i];
					sortIndeks[i] = sortIndeks[j];
					sortIndeks[j] = tmpI;
				}
			}
	}

	static void danSaNajmanjimPrihodom(double eo[][]) {
		int pozMin = 0;

		double[] zaradaPoDanu = new double[DANI];

		for (int i = 0; i < DANI; i++) {
			for (int j = 0; j < KATEGORIJE; j++)
				zaradaPoDanu[i] += eo[i][j];
			System.out.println((i + 1) + ". dana je ostvaren " + zaradaPoDanu[i] + " prihod");
		}
		for (int i = 1; i < DANI; i++) {
			if (zaradaPoDanu[i] < zaradaPoDanu[pozMin])
				pozMin = i;
		}
		System.out.println((pozMin + 1) + ". dana je ostvaren najmanji prihod koji iznosi " + zaradaPoDanu[pozMin]);

	}

	static void prihodPoKategorijama(double eo[][]) {
		double[] zaradaPoKategorijama = new double[KATEGORIJE];

		for (int j = 0; j < KATEGORIJE; j++) {
			for (int i = 0; i < DANI; i++)
				zaradaPoKategorijama[j] += eo[i][j];
			System.out.println((j + 1) + ". kategorija je ostvarila " + zaradaPoKategorijama[j] + " prihod");
		}

	}

	static void mesecniPrihod(double eo[][]) {
		double suma = 0;
		for (int j = 0; j < KATEGORIJE; j++)
			for (int i = 0; i < DANI; i++)
				suma += eo[i][j];
		suma /= (KATEGORIJE * DANI);
		System.out.println("Prosečni mesečni prihod je: " + suma);
	}

	static void izlistajMatricu(double eo[][], String nazivVrste, String nazivKolone) {
		int i, j;

		int duzinaNazivaVrste = nazivVrste.length();
		ispisiPraznaMesta(duzinaNazivaVrste + 20);
		System.out.println(nazivKolone);
		System.out.println(nazivVrste);

		for (i = 0; i < DANI; i++) {
			ispisiPraznaMesta(duzinaNazivaVrste + 2);
			for (j = 0; j < KATEGORIJE; j++)
				System.out.printf("%10.2f", eo[i][j]);
			System.out.println();
		}
	}

	static void ispisiPraznaMesta(int brPraznihMesta) {
		for (int i = 0; i < brPraznihMesta; i++)
			System.out.print(" ");
	}
}
