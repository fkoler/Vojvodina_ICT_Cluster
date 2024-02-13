package UpravljackeStrukture;

import prviProjekat.TextIO;

public class IfSwitchSelekcijaPrimer {

	public static void main(String[] args) {

		/* Definicija promenljive */
		int ocena;

		/* Unos podatka */
		System.out.println("Program za ispis uspeha na osnovu unete ocene!");
		System.out.print("Unesite ocenu: ");
		ocena = TextIO.getlnInt();

		/* Odredjivanje uspeha i ispis */
		switch (ocena) {
		case 1:
			System.out.println("Nedovoljan!");
			break;
		case 2:
			System.out.println("Dovoljan!");
			break;
		case 3:
			System.out.println("Dobar!");
			break;
		case 4:
			System.out.println("Vrlo dobar!");
			break;
		case 5:
			System.out.println("Odlican!");
			break;
		default:
			System.out.println("Nije dobro uneta vrednost");
		}

//		int x;
		int x = 0;

		if (ocena == 2) {
			x = 32;
		} else {
			x = 0;
		}

		System.out.println("x = " + x);
	}
}
