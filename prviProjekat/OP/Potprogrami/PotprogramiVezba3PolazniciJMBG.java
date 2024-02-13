package Potprogrami;
/* Napraviti program koji prihvata podatke o polaznicima
(ime, prezime, jmbg, grad), dobijene podatke sortira po
jmbg-u i prikazuje ih korisniku. Podaci se smeštaju u niz,
može biti maksimalno 40 polaznika. Implementirati unos,
prikaz i sortiranje kao zasebne potprograme. */

public class PotprogramiVezba3PolazniciJMBG {
	
	static int MAXPOLAZNIKA = 40;

	public static void main(String[] args) {
		String[][] listaPolaznika = new String[MAXPOLAZNIKA][4];
		int brPolaznika = 0;
		System.out.println("-- Program za unos i sortiranje liste polaznika --");
		brPolaznika = unosBrojaPolaznika();
		unosPolaznika(listaPolaznika, brPolaznika);
		sortiranjeJmbg(listaPolaznika, brPolaznika);
		prikazPolaznika(listaPolaznika, brPolaznika, "JMBG");
	}

	static int unosBrojaPolaznika() {
		int brojEl = 0;
		System.out.println("Unesite broj polaznika (maksimalno 40):");
		brojEl = TextIO.getlnInt();
		return brojEl;
	}

	static void unosPolaznika(String[][] polaznici, int brPolaznika) {
		int i = 0;
		System.out.println("------------------------------------------------");
		for (i = 0; i < brPolaznika; i++) {
			System.out.println("Unesite podatke za " + (i + 1) + ". polaznika:");
			System.out.print("Ime:\t\t");
			polaznici[i][0] = TextIO.getlnWord();
			System.out.print("Prezime:\t");
			polaznici[i][1] = TextIO.getlnWord();
			System.out.print("JMBG:\t\t");
			polaznici[i][2] = TextIO.getlnWord();
			System.out.print("Grad:\t\t");
			polaznici[i][3] = TextIO.getlnWord();
			System.out.println("-------------------------------------------------");
		}
	}

	static void sortiranjeJmbg(String[][] polaznici, int brPolaznika) {
		int i, j;
		for (i = 0; i < brPolaznika - 1; i++)
			for (j = i + 1; j < brPolaznika; j++)
				if (polaznici[i][2].compareTo(polaznici[j][2]) > 0)
					zamena(polaznici, i, j);
	}

	static void zamena(String[][] polaznici, int koga, int kim) {
		int i = 0;
		String podatakOPolazniku;
		for (i = 0; i < 4; i++) {
			podatakOPolazniku = polaznici[koga][i];
			polaznici[koga][i] = polaznici[kim][i];
			polaznici[kim][i] = podatakOPolazniku;
		}
	}

	static void prikazPolaznika(String[][] polaznici, int brPolaznika, String vrstaSorta) {
		int i;
		System.out.println("Lista polaznika sortirana prema " + vrstaSorta + ":");
		System.out.println("--------------------------------------------------");
		for (i = 0; i < brPolaznika; i++) {
			System.out.println("R.br:\t\t_" + (i + 1) + "_");
			System.out.println("Ime:\t\t" + polaznici[i][0]);
			System.out.println("Prezime:\t" + polaznici[i][1]);
			System.out.println("JMBG:\t\t" + polaznici[i][2]);
			System.out.println("Grad:\t\t" + polaznici[i][3]);
			System.out.println("--------------------------------------------------");
		}
	}
}
