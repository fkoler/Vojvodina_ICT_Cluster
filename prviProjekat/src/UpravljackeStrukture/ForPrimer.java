package UpravljackeStrukture;

import prviProjekat.TextIO;

public class ForPrimer {

	public static void main(String[] args) {
		int N = 1;
		int i, suma = 0;
		System.out.println("Program za racunanje sume prvih N prirodnih brojeva.");
		System.out.println("Unesite N: ");
		do {
			N = TextIO.getlnInt();
			if (N < 1)
				System.out.println("N mora biti veci od 0. Unesite ponovo N: ");
		} while (N < 1);
		for (i = 1; i <= N; i++)
			suma += i;
		System.out.println("Suma prvih " + N + " prirodnih brojeva je: " + suma + ".");
	}
}
