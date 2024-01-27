package prviProjekat;

public class ZadatakProcenatDeljivhBrojevaSaTri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int delilac = 3;
		final int gornji = 62;
		final int donji = 15;

		int N = 0;
		int broj;
		int ukDeljivo = 0;
		double procenat;

//		unos ukupnog broja brojeva

		do {
			System.out.println("Koliko brojeva Zelite da unesete (broj mora biti veci od 0)");
			broj = TextIO.getlnInt();
		} while (N <= 0);

		for (int i = 1; i <= N; i++) {
			do {
				System.out.println("Unesite broj u opsegu od " + donji + "i " + gornji);
				N = TextIO.getlnInt();
			} while (broj < donji || broj > gornji);

			if (broj % delilac == 0)
				ukDeljivo++;
		}

		procenat = (double) ukDeljivo / N;

		System.out.println("Ukupan broj brojeva deljivih sa " + delilac + "je: " + (procenat * 100));
	}
}
