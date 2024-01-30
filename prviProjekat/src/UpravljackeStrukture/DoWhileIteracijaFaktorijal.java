package UpravljackeStrukture;

import prviProjekat.TextIO;

public class DoWhileIteracijaFaktorijal {

	public static void main(String[] args) {

		int broj = 1, i = 1, fakt = 1;

		System.out.println("Program za racunanje faktorijala unetog broja.");
		System.out.println("\nUnesite broj: ");

		do {
			broj = TextIO.getlnInt();
			if (broj < 0)
				System.out.println("\nBroj mora biti veci ili jednak 0. Unesite ponovo broj: ");
		} while (broj < 0);

		while (i <= broj) {
			fakt *= i;
			i++; // uzrokuje da (i <= broj) konvergira nuli
		}
		System.out.println("\nFaktorijal broja " + broj + " je: " + fakt + ".");
	}
}
