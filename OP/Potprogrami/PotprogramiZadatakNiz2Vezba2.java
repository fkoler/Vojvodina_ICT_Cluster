package Potprogrami;

/* Implementirati program koji od korisnika prihvata N elemenata niza
(koji maksimalno može sadržati do 30 elemenata). Omogućiti
korisniku da bira neku od sledećih operacija: izračunavanje sume
elemenata niza, računanje srednje vrednosti niza, nalaženje
minimuma, nalaženje maksimuma. Omogućiti ponavljeno izvršavanje
ovih akcija. */

public class PotprogramiZadatakNiz2Vezba2 {

	public static void main(String[] args) {

		int ponovo = 0;

		do {

			final int MAXELNIZA = 30;
			int N = 0;
			int[] nizPrirodnihBrojeva = new int[MAXELNIZA];
			int operacija = 0;

			System.out.println("Program za racunanje: \n");
			System.out.println("\t1.Sume elemenata niza ( N maksimalno 30).");
			System.out.println("\t2.Srednje vrednosti niza (N maksimalno 30).");
			System.out.println("\t3.Minimalne vrednosti u nizu (N maksimalno 30).");
			System.out.println("\t4.Maksimalne vrednosti u nizu (N maksimalno 30).");
			System.out.println("\nOdaberite operaciju od 1 do 4");
			do {

				operacija = TextIO.getlnInt();

				if (operacija < 0 || operacija > 4) {
					System.out.println("Odaberite operaciju od 1 do 4");
				}
			} while (operacija < 0 || operacija > 4);

			do {
				N = unosBrojaElemNiza();

				if (N > MAXELNIZA) {
					System.out.println("N Niz moze sadrzati maksimalno 30 elemenata");
				}
			} while (N > MAXELNIZA);

			unosElemNiza(N, nizPrirodnihBrojeva);

			if (operacija == 1) {
				System.out.println("Suma elemenata niza iznosi: " + sumaVrednostNiza(N, nizPrirodnihBrojeva));
			} else if (operacija == 2) {
				System.out.println("Srednja vrednost niza iznosi: " + prosecnaVrednost(N, nizPrirodnihBrojeva));
			} else if (operacija == 3) {
				System.out.println("Minimalna vrednost niza iznosi: " + minimalnaVrednost(N, nizPrirodnihBrojeva));
			} else if (operacija == 4) {
				System.out.println("Maksimalna vrednost niza iznosi: " + maksimalnaVrednost(N, nizPrirodnihBrojeva));
			} else {
				System.out.println("Odaberite operaciju od 1 do 4");
				return;
			}

			System.out.println("Za ponovno pokretanja programa pritisnite taster 0");
			ponovo = TextIO.getlnInt();
			if (ponovo != 0) {
				System.out.println("Dovidjenja");
				return;
			}
		} while (ponovo != 0);

	}

	public static int unosBrojaElemNiza() {
		int brojEl = 0;
		System.out.println("Unesite koliko elemenata treba da sadrzi N niz:");
		brojEl = TextIO.getlnInt();
		return brojEl;
	}

	public static void unosElemNiza(int n, int[] nizElem) {
		int i = 0;
		for (i = 0; i < n; i++) {
			System.out.print("Unesite " + (i + 1) + ". element niza: ");
			nizElem[i] = TextIO.getlnInt();
		}
		System.out.println();
	}

	public static int sumaVrednostNiza(int n, int[] nizElem) {
		int suma = 0;
		for (int i = 0; i < n; i++)
			suma += nizElem[i];
		return suma;
	}

	public static double prosecnaVrednost(int n, int[] nizElem) {

		return (double) sumaVrednostNiza(n, nizElem) / n;
	}

	public static int maksimalnaVrednost(int n, int[] nizElem) {
		int maksimum = 0;
		for (int i = 0; i < n; i++) {
			if (maksimum < nizElem[i]) {
				maksimum = nizElem[i];
			}
		}
		return maksimum;
	}

	public static int minimalnaVrednost(int n, int[] nizElem) {
		int minimum = 0;
		for (int i = 0; i < n; i++) {
			if (minimum > nizElem[i]) {
				minimum = nizElem[i];
			}
		}
		return minimum;
	}
}
