package ZaposleniThis;

import Zaposleni.TextIO;

public class Main {

	public static void main(String[] args) {

		String imeZaposlenog = "";
		String prezimeZaposlenog = "";
		int koeficijentZaposlenog = 0;

		Zaposleni radnik = new Zaposleni(imeZaposlenog, prezimeZaposlenog, koeficijentZaposlenog);

		do {
			System.out.print("Unesite ime zaposlenog: \t");
			imeZaposlenog = TextIO.getlnString();

			System.out.print("Unesite prezime zaposlenog: \t");
			prezimeZaposlenog = TextIO.getlnString();

			System.out.print("Unesite koeficijent zaposlenog: ");
			koeficijentZaposlenog = TextIO.getlnInt();

			if (imeZaposlenog == "" || prezimeZaposlenog == "" || koeficijentZaposlenog == 0) {
				System.out.println("Molimo Vas unesite ispravne podatke");
			}

			radnik.setIme(imeZaposlenog);
			radnik.setPrezime(prezimeZaposlenog);
			radnik.setKoeficijent(koeficijentZaposlenog);

		} while (imeZaposlenog == "" || prezimeZaposlenog == "" || koeficijentZaposlenog == 0);

		radnik.racunanjePlate();

		radnik.ispisPlate();
	}
}
