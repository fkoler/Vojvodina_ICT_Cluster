package UpravljackeStrukture;

import prviProjekat.TextIO;

public class _Zadatak5ProcenatBrojevaDeljivihSaTri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int delilac = 3;
		final int gornji = 62;
		final int donji = 15;

		int N = 0; // Ukupan broj Unetih Vrednosti (Brojeva)
		int broj; // Broj Koji Se Unosi
		int ukDeljivo = 0; // Ukupan Broj Deljivih
		double procenat;

//		unos ukupnog broja brojeva (koji treba da se unesu)
		do {
			System.out.println("Koliko brojeva zelite da unesete? (broj mora biti ceo i veci od 0):");
			N = TextIO.getlnInt();
		} while (N <= 0); // N - ne sme biti manji od 1

		for (int i = 1; i <= N; i++) {
			do {
				System.out.println("Unesite broj u opsegu od " + donji + " do " + gornji + ":");
				broj = TextIO.getlnInt();
				if (broj < donji || broj > gornji) {
					System.out.println("Uneta vrednost nije u zadatom opsegu.");
				}
			} while (broj < donji || broj > gornji);

			if (broj % delilac == 0) {
				ukDeljivo++;
			}
		}

		procenat = (double) ukDeljivo / N;

//		System.out.println("Procenat unetih brojeva deljivih sa " + delilac + " je: " + (procenat * 100) + "%");
		System.out.printf("Procenat unetih brojeva deljivih sa %d je:  %.2f%%", delilac, (procenat * 100));
	}
}
