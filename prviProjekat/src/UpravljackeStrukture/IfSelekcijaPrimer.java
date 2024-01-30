package UpravljackeStrukture;

import prviProjekat.TextIO;

public class IfSelekcijaPrimer {

	public static void main(String[] args) {

		/* Definicija promenljive */
		int ocena;
		/* Unos podatka */
		System.out.println("Program za ispis uspeha na osnovu unete ocene!");
		System.out.print("Unesite ocenu: ");
		ocena = TextIO.getlnInt();

		/* Odredjivanje uspeha i ispis */
		if (ocena == 1) {
			System.out.println("Nedovoljan!");
		} else if (ocena == 2) {
			System.out.println("Dovoljan!");
		} else if (ocena == 3) {
			System.out.println("Dobar!");
		} else if (ocena == 4) {
			System.out.println("Vrlo dobar!");
		} else if (ocena == 5) {
			System.out.println("Odlican!");
		} else {
			System.out.println("Nije dobro uneta vrednost");
		}
	}
}
