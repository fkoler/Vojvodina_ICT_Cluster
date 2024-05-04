package StatickeStrukturePodataka;

public class NizZadatak2 {

	public static void main(String[] args) {
		int N = 1, i, suma = 0;
		int maxPozicija;
		System.out.println("Program za racunanje sume elemenata niza N prirodnih brojeva.");
		do {
			System.out.print("Unesite N:\t");
			N = TextIO.getlnInt();
			if (N < 1)
				System.out.print("Greška! Broj mora biti veći od 0");
		} while (N < 1);

		int NizPrirordnihBrojeva[] = new int[N];

		for (i = 0; i < NizPrirordnihBrojeva.length; i++) { // prihvati elemente niza od korisnika
			System.out.println("Unesite " + (i + 1) + ". element niza:\t");
			NizPrirordnihBrojeva[i] = TextIO.getlnInt();
		}

		for (i = 0; i < NizPrirordnihBrojeva.length; i++) // izracunaj sumu elemenata niza
			suma += NizPrirordnihBrojeva[i];
		System.out.println("Suma elemenata niza izosi " + suma + ".");

		maxPozicija = 0;
		for (i = 0; i < NizPrirordnihBrojeva.length; i++) // izracunaj poziciju maksimalnog elemenata niza
		{
			if (NizPrirordnihBrojeva[maxPozicija] < NizPrirordnihBrojeva[i]) {
				maxPozicija = i;
			}
		}
		System.out.println("Maksimalna vrednost elemenata niza iznosi " + NizPrirordnihBrojeva[maxPozicija] + ".");
		// System.out.println("Nalazi se na poziciji: " + (maxPozicija+1) + ".");

		System.out.print("Nalazi se na sledećim pozicijama: ");
		for (i = 0; i < NizPrirordnihBrojeva.length; i++) // izracunaj poziciju maksimalnog elemenata niza
		{
			if (NizPrirordnihBrojeva[maxPozicija] == NizPrirordnihBrojeva[i]) {
				System.out.print((i + 1) + " ");
			}
		}
	}
}