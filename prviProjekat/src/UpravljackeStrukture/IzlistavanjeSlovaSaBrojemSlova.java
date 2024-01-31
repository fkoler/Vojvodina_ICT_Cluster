package UpravljackeStrukture;

import prviProjekat.TextIO;

public class IzlistavanjeSlovaSaBrojemSlova {

	public static void main(String[] args) {

		String str; // linija teksta koju unosi korisnik.
		int ukSlova; // ukupan broj razlicitih slova u str tekstu.

		int ukJednogSlova; // ukupan broj pojavljivanja jednog slova u str tekstu

		char slovo; // Slovo iz alfabeta.
		int i; // indeks slova u nizu karaktera string str.

		System.out.println("Unesite jedan red teksta:");

		str = TextIO.getln();
		str = str.toUpperCase();

		ukSlova = 0;

		System.out.println("Vas red teksta sadrzi sledeca slova:\n");

		for (slovo = 'A'; slovo <= 'Z'; slovo++) {
			ukJednogSlova = 0;
			for (i = 0; i < str.length(); i++) {
				if (slovo == str.charAt(i)) {
					if (ukJednogSlova == 0) {
						System.out.print("  " + slovo);
						System.out.print("[");
						ukSlova++;
						ukJednogSlova++;
					} else {
						ukJednogSlova++;
					}
				}
			}

			if (ukJednogSlova > 0) {
				System.out.print(ukJednogSlova);
				System.out.print("]");
			}
		}

		System.out.println("\n\n Tekst: '" + str + "' sadrzi " + ukSlova + " razlicitih slova.");
	}
}
