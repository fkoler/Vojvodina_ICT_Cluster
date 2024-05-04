package Potprogrami;

public class PotprogramiVezba4PolazniciJMBG_Milovan {

	// Napraviti program koji prihvata podatke o polaznicima
	// (ime, prezime, jmbg, grad), dobijene podatke sortira po jmbg-u i prikazuje ih
	// korisniku.
	// Podaci se smeštajuu niz, može biti maksimalno 40 polaznika.
	// Implementirati unos, prikaz i sortiranje kao zasebne potprograme.

	// Modifikovati prethodnu vežbu tako da korisnik može da bira kriterijum po
	// kojem će se vršiti sortiranje.
	// Implementirati program oslanjajući se na funkcije.

	static int MAXPOLAZNIKA = 40;

	public static void main(String[] args) {
		String[][] listaPolaznika = new String[MAXPOLAZNIKA][4];
		int brPolaznika = 0;
		System.out.println("-- Program za unos i sortiranje liste polaznika --");
		brPolaznika = unosBrojaPolaznika();
		unosPolaznika(listaPolaznika, brPolaznika);
		int kriterijumSorta = unosVrsteSorta(); // Modifikacija zadatka
		System.out.println("kriterijumSorta = " + kriterijumSorta + "\n");

		sortiranje(listaPolaznika, brPolaznika, kriterijumSorta); // Modifikacija zadatka (dodat treci argument)

		prikazPolaznika(listaPolaznika, brPolaznika, kriterijumSorta); // Modifikacija zadatka (kriterijumSorta umesto
																		// "JMBG")
	}

	static int unosBrojaPolaznika() {
		int brojEl = 0;
		System.out.print("Unesite broj polaznika (maksimalno 40): ");
		brojEl = TextIO.getlnInt();
		return brojEl;
	}

	static void unosPolaznika(String[][] polaznici, int brPolaznika) {
		int i = 0;
		System.out.println("--------------------------------------------");
		for (i = 0; i < brPolaznika; i++) {
			System.out.println("Unesite podatke za " + (i + 1) + ". polaznika: ");
			System.out.println("Ime:\t\t");
			polaznici[i][0] = TextIO.getlnWord();
			System.out.println("Prezime:\t");
			polaznici[i][1] = TextIO.getlnWord();
			System.out.println("JMBG:\t\t");
			polaznici[i][2] = TextIO.getlnWord();
			System.out.println("Grad:\t\t");
			polaznici[i][3] = TextIO.getlnWord();
			System.out.println("--------------------------------------------");
		}
	}

	// Modifikacija zadatka (metoda unosVrsteSorta):
	static int unosVrsteSorta() {
		int kriterijumInt = -1;

		System.out.println("Izaberite kriterijum sortiranja:");
		System.out.println("0 - Ime");
		System.out.println("1 - Prezime");
		System.out.println("2 - JMBG");
		System.out.println("3 - Grad");

		do {
			if (kriterijumInt < 0 || kriterijumInt > 3) {
				System.out.println("Izaberite opciju od 0 do 3.");
			}

			kriterijumInt = TextIO.getlnInt();
		} while (kriterijumInt < 0 || kriterijumInt > 3);

		return kriterijumInt;
	}

	static void sortiranje(String[][] polaznici, int brPolaznika, int kriterijumSortiranja) { // Modifikacija zadatka
																								// (treci parametar)
		int i, j;
		for (i = 0; i < brPolaznika; i++) {
			for (j = i + 1; j < brPolaznika; j++) {
				if (polaznici[i][kriterijumSortiranja].compareTo(polaznici[j][kriterijumSortiranja]) > 0) {
					zamena(polaznici, i, j);
				}
			}
		}
	}

	static void zamena(String[][] polaznici, int koga, int kim) {
		int i = 0;
		String podatakOPolazniku;

		// U ovoj for petlji zamenjujem sva 4 podatka o polaznicima:
		for (i = 0; i < 4; i++) {
			podatakOPolazniku = polaznici[koga][i];
			polaznici[koga][i] = polaznici[kim][i];
			polaznici[kim][i] = podatakOPolazniku;
		}
	}

	static void prikazPolaznika(String[][] polaznici, int brPolaznika, int vrstaSorta) { // Modifikacija zadatka (int
																							// vrstaSorta umesto
																							// stringa)
		int i;

		// Modifikacija zadatka (ceo switch)
		String nazivVrsteSorta;
		switch (vrstaSorta) {
		case 0:
			nazivVrsteSorta = "Imenu";
			break;
		case 1:
			nazivVrsteSorta = "Prezimenu";
			break;
		case 2:
			nazivVrsteSorta = "JMBG-u";
			break;
		case 3:
			nazivVrsteSorta = "Gradu";
			break;
		default:
			nazivVrsteSorta = "";
			break;
		}

		System.out.println("Lista polaznika sortirana prema " + nazivVrsteSorta + ":");
		System.out.println("--------------------------------------------");
		for (i = 0; i < brPolaznika; i++) {
			System.out.println("R.br:\t\t_" + (i + 1) + "_");
			System.out.println("Ime:\t\t" + polaznici[i][0]);
			System.out.println("Prezime:\t" + polaznici[i][1]);
			System.out.println("JMBG:\t\t" + polaznici[i][2]);
			System.out.println("Grad:\t\t" + polaznici[i][3]);
			System.out.println("--------------------------------------------");
		}
	}
}
