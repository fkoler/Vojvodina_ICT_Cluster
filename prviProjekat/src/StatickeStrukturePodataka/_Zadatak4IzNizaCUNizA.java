package StatickeStrukturePodataka;

/* Dat je niz C od maksimalno 15 karaktera. Učitati n karaktera u niz C i
formirati niz A, pri čemu su elementi niza A samo brojevi iz niza C. */

public class _Zadatak4IzNizaCUNizA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int maxNiza = 15; // maksimalan broj elemenata u nizu
		int unos = -1; // broj elemenata u nizu koji bira korisnik

		while (unos < 0 || maxNiza < unos) {
			System.out.printf("Unesite duzinu niza C (maksimalno %d): %n", maxNiza);
			unos = TextIO.getlnInt();
		}

		int brojac = 0;
		char[] nizKarakteraC = new char[unos];
		int[] nizBrojevaA = new int[unos];

		for (int i = 0; i < unos; i++) {
			System.out.printf("Unesite %d. karakter u niz C: %n", i + 1);
			nizKarakteraC[i] = TextIO.getlnChar();

			if (Character.isDigit(nizKarakteraC[i])) {
				nizBrojevaA[brojac] = Character.getNumericValue(nizKarakteraC[i]);
				brojac++;
			}
		}

		System.out.println("---------------------------------");
		for (int i = 0; i < brojac; i++) {
			System.out.printf("%d. Elemenat niza A je: %d %n", (i + 1), nizBrojevaA[i]);			
		}
	}
}
