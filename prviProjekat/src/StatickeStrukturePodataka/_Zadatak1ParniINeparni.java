package StatickeStrukturePodataka;

/* Dat je niz X od maksimalno 12 celobrojnih elemenata. Učitati n
elemenata u niz X i formirati nizove A i B, pri čemu su elementi niza A
parni elementi niza X, a elementi niza B su neparni elementi niza X. */

public class _Zadatak1ParniINeparni {

	public static void main(String[] args) {

		int[] X = new int[12]; // niz od 12 elemenata
		int[] A = new int[12]; // ne mozemo znati kakav ce biti input
		int[] B = new int[12]; // A za parne; B za neparne
		int n = 0; // broj elemenata u X nizu
		int brElA = 0; // broj elemenata u A nizu
		int brElB = 0; // broj elemenata u B nizu

		// deo za unosenje "n" vrednosti
		System.out.println("Program za deljenje niza na podnizove parnih i neparnih brojeva.");
		do {
			System.out.print("Unesite n:\t");
			n = TextIO.getlnInt();
			if (n < 1 || n > 12) {
				System.out.print("Greška! Broj mora biti veći od 0 a manji od 13");
			}
		} while (n < 1 || n > 12);

		// prihvatanje elemente niza od korisnika i smestanje u niz "X"
		for (int i = 0; i < n; i++) {
			System.out.println("Unesite " + (i + 1) + ". element niza:\t");
			X[i] = TextIO.getlnInt();
		}

		// ovaj deo koda je ustvari sustina zadatka
		// provera za svaki broj da li je denjiv sa "2" i smestanje u odgovarajuci niz
		for (int i = 0; i < n; i++) {
			if (X[i] % 2 == 0) { // prvo parni u "A"
				A[brElA] = X[i]; // <-- na ovom mestu se vrednost dodaje u niz ako odgovara
				brElA++; // pa se tek onda uvecava
			} else {
				B[brElB] = X[i]; // <-- ostatak su neparni u "B"
				brElB++; // ista logika
			}
		}

		// ispis niza "A"
		if (brElA == 0) // da li je uopste nesto ubaceno u niz
			System.out.println("Niz A ne sadrži parne brojeve.");
		else {
			System.out.print("Parni A=["); // "brElA" je ukupan broj elemenata
			for (int i = 0; i < brElA - 1; i++) { // index dobijamo umanjenjem "brElA" za 1
				System.out.print(A[i] + ", ");
			}
			System.out.println(A[brElA - 1] + "]");
		}

		// ista logika ispis niza "B"
		if (brElB == 0)
			System.out.println("Niz ne sadrži neparne brojeve.");
		else {
			System.out.print("Neparni B=[");
			for (int i = 0; i < brElB - 1; i++) {
				System.out.print(B[i] + ", ");
			}
			System.out.println(B[brElB - 1] + "]");
		}
	}
}
