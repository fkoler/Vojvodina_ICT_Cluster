package StatickeStrukturePodataka;

/* Dat je niz A od maksimalno 40 celobrojnih elemenata. Učitati n
elemenata u niz A i formirati niz X pri čemu su elementi niza X apsolutne
vrednosti negativnih elemenata niza A. Koristiti abs funkciju. */

public class _Zadatak5AbsVrednosti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = new int[40];
		int[] X = new int[40];

		System.out.println("Unesite broj elemenata niza A (Minimum 1 i Maximum 40)");
		int n = TextIO.getInt();

		if (n > 40) {
			System.out.println("Broj elemenata ne sme biti veci od 40");
		}
		if (n < 1) {
			System.out.println("Broj elemenata ne sme biti manji od 1");
		}

		System.out.println("Unesite elemente niza A:");
		for (int i = 0; i < n; i++) {
			A[i] = TextIO.getInt();
		}

		int x = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] < 0) {
				X[x] = Math.abs(A[i]);
				x++;
			}
		}

		System.out.println("Niz X:");
		for (int i = 0; i < x; i++) {
			System.out.println(X[i] + " ");
		}
	}
}
