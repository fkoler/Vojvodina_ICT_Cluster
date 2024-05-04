package StatickeStrukturePodataka;

/* Dat je niz A od maksimalno 20 celobrojnih elemenata. Učitati n
elemenata, zatim učitati ceo broj br. Na izlazu ispisati ceo niz i broj
pojavljivanja broja br u nizu. */

public class _Zatadak3PojavljivanjeBrojaUNizu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n; // broj elemenata niza
		int br; // broj koji trazimo u nizu
		int i; // iterator
		int kontrola = 0; // broj pojavljivanja
		int[] A; // niz unesenih n brojeva

		System.out.println("Koliko elemenata zelite uneti u niz (max.20)?\nn = ");
		do {
			n = TextIO.getlnInt();
			if ((n < 0) || (n > 20)) {
				System.out.println("Uneli ste netacan broj. pokusajte ponovo.");
			}
		} while ((n < 0) || (n > 20));

		A = new int[n]; // nizu dodeljeno broj elemenata

		System.out.println("Molim vas da unosite elemente niza, koji mogu da budu samo celi brojevi.");
		for (i = 0; i < n; i++) {
			A[i] = TextIO.getlnInt(); // dodavanje brojeva u niz
		}

		System.out.println("Unosite broj koji zelite potraziti u nizu.");
		br = TextIO.getlnInt(); // broj za kontrolu

		System.out.print("A = [ ");
		for (i = 0; i < n; i++) {

			System.out.print(A[i]);
			if (i != (n - 1)) {
				System.out.print(", ");
			}
		}
		System.out.print(" ]\n");

		for (i = 0; i < n; i++) {
			if (A[i] == br) {
				kontrola++;
			}
		}
		System.out.print("\nBroj " + br + " nalazi se u nizu " + kontrola + " puta.");
	}
}