package prviProjekat;

import prviProjekat.EnumPrimerMeseciDani.Dan;
import prviProjekat.EnumPrimerMeseciDani.Mesec;

public class EnumISwitch {

	enum Dan {
		PONEDELJAK, UTORAK, SREDA, CETVRTAK, PETAK, SUBOTA, NEDELJA
	}

	enum Mesec {
		JANUAR, FEBRUAR, MART, APRIL, MAJ, JUN, JUL, AUGUST, SEPTEMBAR, OKTOBAR, NOVEMBAR, DECEMBAR
	}

	public static void main(String[] args) {
		Dan danRodjenja; // promenljiva tipa Dan.
		Mesec mesecRodjenja; // promenljiva tipa Mesec.

		int unos;

		unos = TextIO.getlnInt();

		switch (unos) {
		case 1:
			danRodjenja = Dan.PONEDELJAK;
			break;
		case 2:
			danRodjenja = Dan.UTORAK;
			break;
		case 3:
			danRodjenja = Dan.SREDA;
			break;
		case 4:
			danRodjenja = Dan.CETVRTAK;
			break;
		case 5:
			danRodjenja = Dan.PETAK;
			break;
		case 6:
			danRodjenja = Dan.SUBOTA;
			break;
		case 7:
			danRodjenja = Dan.NEDELJA;
			break;
		}

	}
}