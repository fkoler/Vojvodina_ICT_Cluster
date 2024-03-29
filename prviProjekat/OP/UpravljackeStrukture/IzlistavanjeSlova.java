package UpravljackeStrukture;

import prviProjekat.TextIO;

public class IzlistavanjeSlova {

	public static void main(String[] args) {

		String str; // linija teksta koju unosi korisnik.
		int ukSlova; // ukupan broj razlicitih slova u str tekstu.
		char slovo; // Slovo iz alfabeta.
		int i; // indeks slova u nizu karaktera string str.

		System.out.println("Unesite jedan red teksta:");

		str = TextIO.getln();
		str = str.toUpperCase();
		ukSlova = 0;

		System.out.println("Vas red teksta sadrzi sledeca slova:\n");		

		for (slovo = 'A'; slovo <= 'Z'; slovo++) {
			for (i = 0; i < str.length(); i++) {
				if (slovo == str.charAt(i)) {
					System.out.print("  "+ slovo);
					ukSlova++;
					break;
				}				
			}
		}		
		System.out.println("\n\nSadrzi " + ukSlova + " razlicitih slova.");
	}
}
