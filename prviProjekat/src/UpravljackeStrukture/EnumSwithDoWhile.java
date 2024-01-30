package UpravljackeStrukture;

import prviProjekat.TextIO;

enum Dan {
	PONEDELJAK, UTORAK, SREDA, CETVRTAK, PETAK, SUBOTA, NEDELJA
}

public class EnumSwithDoWhile {

	public static void main(String[] args) {

		Dan danRodjenja = Dan.NEDELJA;

		int unos;

		do {
			System.out.println("Unesite dan (1 - 7) >>");
			unos = TextIO.getlnInt();
			if ((unos < 1) || (unos > 7))
				System.out.println("Vrednost je van opsega");
		} while ((unos < 1) || (unos > 7));

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

		System.out.println("Uneli ste >> " + danRodjenja);
	}
}
