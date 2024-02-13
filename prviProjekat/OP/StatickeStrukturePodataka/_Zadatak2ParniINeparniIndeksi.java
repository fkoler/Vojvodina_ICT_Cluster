package StatickeStrukturePodataka;

/* Dat je niz X od maksimalno 10 realnih elemenata. Učitati n elemenata u
niz X i formirati nizove A i B, pri čemu su elementi niza A elementi niza X
sa parnim indeksom, a elementi niza B su elementi niza X sa neparnim
indeksom. */

public class _Zadatak2ParniINeparniIndeksi {

	public static void main(String[] args) {

		final int maxNiza = 10;
		final int[] X = new int[maxNiza]; 
		final int[] A = new int[maxNiza / 2];
		final int[] B = new int[maxNiza / 2]; 
		int n = 0; // broj elemenata u X nizu
		int brElA = 0; // broj elemenata u A nizu
		int brElB = 0; // broj elemenata u B nizu

		// deo za unosenje "n" vrednosti
		System.out.println("Program za deljenje niza na podnizove parnih i neparnih indeksa.");
		do {
			System.out.print("Unesite n:\t");
			n = TextIO.getlnInt();
			if (n < 1 || n > 10) {
				System.out.print("Greška! Broj mora biti veći od 0 a manji od 10");
			}
		} while (n < 1 || n > 10);

		// prihvatanje elemente niza od korisnika i smestanje u niz "X"
		for (int i = 0; i < n; i++) {
			System.out.println("Unesite " + i + " indeks elementa niza:\t");
			X[i] = TextIO.getlnInt();
		}

		// provera za svaki indeks da li je denjiv sa "2" i smestanje u odgovarajuci niz
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) { // prvo parni u "A"
				A[brElA] = X[i]; // <-- na ovom mestu se vrednost dodaje u niz ako odgovara
				brElA++; // pa se tek onda uvecava
			} else {
				B[brElB] = X[i]; // <-- ostatak su neparni u "B"
				brElB++; // ista logika
			}
		}

		// ispis niza "A"
		System.out.print("Parni indeksi A = [ ");
		for (int i = 0; i < brElA; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println( "]");

		// ispis niza "B"
		System.out.print("Neparni indeksi B = [ ");
		for (int i = 0; i < brElB; i++) {
			System.out.print(B[i] + " ");
		}
		System.out.println("]");
	}
}
