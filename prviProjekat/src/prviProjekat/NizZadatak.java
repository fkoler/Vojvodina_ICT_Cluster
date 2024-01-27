package prviProjekat;

public class NizZadatak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int MAXELNIZA = 50; // final sluzi da oznaci vrednost koja se vise ne moze menjati
		int N = 1, i, suma = 0;
		int NizPrirordnihBrojeva[] = new int[MAXELNIZA];
		System.out.println("Program za racunanje sume elemenata niza N prirodnih brojeva.");
		System.out.print("Unesite N:\t"); // prihvati broi elemenata niza
		N = TextIO.getlnInt();
		for (i = 0; i < N; i++) { // prihvati elemente niza od korisnika
			System.out.println("Unesite " + (i + 1) + ". element niza:\t");
			NizPrirordnihBrojeva[i] = TextIO.getlnInt();
		}
		for (i = 0; i < N; i++) // izracunaj sumu elemenata niza
			suma += NizPrirordnihBrojeva[i];
		System.out.println("Suma elemenata niza izosi " + suma + ".");
		
		
	}
}