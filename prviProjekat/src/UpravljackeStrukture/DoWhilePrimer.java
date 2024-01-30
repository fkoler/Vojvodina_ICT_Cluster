package UpravljackeStrukture;

import prviProjekat.TextIO;

public class DoWhilePrimer {

	public static void main(String[] args) {

		int ocena;
		System.out.println("Program za ispis uspeha na osnovu unete ocene!");

		// do-while petlja se koristi da se proveri ulazna vrednost
		do {
			System.out.print("\nUnesite ocenu: ");
			ocena = TextIO.getlnInt();
			if ((ocena < 1) || (ocena > 5))
				System.out.println("\nOcena mora biti izmedju 1 i 5.");
		} while ((ocena < 1) || (ocena > 5));
		switch (ocena) {
		case 1:
			System.out.println("\nNedovoljan!");
			break;
		case 2:
			System.out.println("\nDovoljan!");
			break;
		case 3:
			System.out.println("\nDobar!");
			break;
		case 4:
			System.out.println("\nVrlo dobar!");
			break;
		case 5:
			System.out.println("\nOdlican!");
		}

		System.exit(1);
	}
}
