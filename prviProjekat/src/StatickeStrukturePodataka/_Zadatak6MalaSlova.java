package StatickeStrukturePodataka;

/* Dat je niz C od maksimalno 15 karaktera. Učitati n karaktera u niz C i
formirati niz A, pri čemu su elementi niza A samo mala slova iz niza C. */

public class _Zadatak6MalaSlova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int MAXELEMENATA = 15;
		char[] C = new char[MAXELEMENATA];
		char[] A = new char[MAXELEMENATA];

		int n, i, j = 0;
		char maloSlovo;

		do {
			System.out.print("Unesite broj elemenata niza (maksimalno " + MAXELEMENATA + "): ");
			n = TextIO.getlnInt();
		} while (n > MAXELEMENATA || n < 1);

		for (i = 0; i < n; i++) {
			System.out.print("Unesite " + (i + 1) + ". element niza: ");
			C[i] = TextIO.getChar();

			for (maloSlovo = 'a'; maloSlovo <= 'z'; maloSlovo++) {
				if (C[i] == maloSlovo) {
					A[j] = C[i];
					j++;
				}
			}
		}

		System.out.print("C = [ ");
		for (i = 0; i < n; i++) {
			System.out.print(C[i] + " ");
		}
		System.out.println("]");

		System.out.print("A = [ ");
		for (i = 0; i < j; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("]");
	}
}
