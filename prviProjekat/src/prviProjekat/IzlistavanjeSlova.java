package prviProjekat;

public class IzlistavanjeSlova {

	public static void main(String[] args) {
		String str; // linija teksta koju unosi korisnik.
		int ukSlova; // ukupan broj razlicitih slova u str tekstu.
		char slovo; // Slovo iz alfabeta.
		int i; // indeks slova u nizu karaktera string str.
		System.out.println("Unesite jedan red teskta:");
		str = TextIO.getln();
		str = str.toUpperCase();
		ukSlova = 0;
		System.out.println("Vas red teksta sadrzi sledeca slova:");
		System.out.println();
		System.out.print(" ");

		for (slovo = 'A'; slovo <= 'Z'; slovo++) {
			for (i = 0; i < str.length(); i++) {
				if (slovo == str.charAt(i)) {
					System.out.print(slovo);
					System.out.print(' ');
					ukSlova++;
					break;
				}
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("Otkriveno je " + ukSlova + " razlicitih slova.");
	}
}
