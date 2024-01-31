package UpravljackeStrukture;

import prviProjekat.TextIO;

public class IzlistavanjeSlovaSaBrojemSlova2 {

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
		boolean vecNadjeno;

		System.out.println("Vas red teksta sadrzi sledeca slova:\n");

		for (slovo = 'A'; slovo <= 'Z'; slovo++) {
			vecNadjeno = false;
			ukJednogSlova = 0;
			for (i = 0; i < str.length(); i++) {
				if (slovo == str.charAt(i)) {
					if (vecNadjeno == true) {
						ukJednogSlova++;
					} else {
						System.out.print("  " + slovo);
						System.out.print("[");
						ukJednogSlova++;
						ukSlova++;
						vecNadjeno = true;
					}
				}
			}

			if (vecNadjeno) {
				System.out.print(ukJednogSlova);
				System.out.print("]");
			}
		}

		System.out.println("\n\nTekst: '" + str + "' sadrzi " + ukSlova + " razlicitih slova.");
	}
}
