package StatickeStrukturePodataka;

import prviProjekat.TextIO;

public class NizZadatak {

	public static void main(String[] args) {

		final int MAXELNIZA = 50;
		int N = 1, i, suma = 0;
		int NizPrirordnihBrojeva[] = new int[MAXELNIZA];
		int najveciBroj = NizPrirordnihBrojeva[0];
		int pozicijaNajvecegBroja = 0;

		System.out.println("Program za racunanje sume elemenata niza N prirodnih brojeva.");
		System.out.print("Unesite N:\t"); // prihvati broj elemenata niza

		N = TextIO.getlnInt();

		for (i = 0; i < N; i++) { // prihvati elemente niza od korisnika
			System.out.println("Unesite " + (i + 1) + ". element niza:\t");
			NizPrirordnihBrojeva[i] = TextIO.getlnInt();
		}

		for (i = 0; i < N; i++) { // izracunaj sumu elemenata niza
			suma += NizPrirordnihBrojeva[i];

			if (NizPrirordnihBrojeva[i] > najveciBroj) {
				najveciBroj = NizPrirordnihBrojeva[i];
				pozicijaNajvecegBroja = i;
			}
		}

		System.out.println("Suma elemenata niza izosi: " + suma);
		System.out.println("\nNajveci broj u nizu je: " + najveciBroj);
		System.out.print("Nalazi se na sledecim pozicijama: ");

		for (i = 0; i < NizPrirordnihBrojeva.length; i++) { // izracunaj poziciju maksimalnog elemenata niza
			if (NizPrirordnihBrojeva[pozicijaNajvecegBroja] == NizPrirordnihBrojeva[i]) {
				System.out.print("[" + (i + 1) + "] ");
			}
		}
	}
}
